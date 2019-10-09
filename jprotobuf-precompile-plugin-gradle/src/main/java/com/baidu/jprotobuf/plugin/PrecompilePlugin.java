/**
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.jprotobuf.plugin;

import org.gradle.api.Plugin;
import org.gradle.api.internal.project.ProjectInternal;
import org.gradle.api.plugins.JavaPlugin;

/**
 * The Class PrecompilePlugin.
 */
public class PrecompilePlugin implements Plugin<ProjectInternal> {

    /** The Constant BUILD_NEEDED_TASK_NAME. */
    private static final String BUILD_NEEDED_TASK_NAME = "jprotobuf_precompile";

    /** The Constant LIBS_PATH. */
    protected static final String LIBS_PATH = "libs";

    /** The Constant CLASSES_PATH. */
    protected static final String CLASSES_PATH = "classes/java/main";

    /**
     * The name of the test runtime classpath configuration.
     *
     * @since 3.4
     */
    public static final String TEST_RUNTIME_CLASSPATH_CONFIGURATION_NAME = "testRuntimeClasspath";

    /**
     * Apply.
     *
     * @param project the project
     */
    public void apply(final ProjectInternal project) {
        final String outputParentDirectory = project.getBuildDir().getAbsolutePath();

        project.getPluginManager().apply(JavaPlugin.class);

        PrecompileTask task = project.getTasks().create(PrecompilePlugin.BUILD_NEEDED_TASK_NAME, PrecompileTask.class);

        task.setOutputParentDirectory(outputParentDirectory);
        task.setOutputDirectory(outputParentDirectory + "/classes");
        
        task.setProject(project);
    }

}
