/**
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.jprotobuf.plugin;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.gradle.api.DefaultTask;
import org.gradle.api.Task;
import org.gradle.api.internal.project.ProjectInternal;
import org.gradle.api.internal.tasks.compile.DefaultJavaCompileSpec;
import org.gradle.api.plugins.JavaPlugin;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * The Class PrecompileTask.
 */
public class PrecompileTask extends DefaultTask {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrecompileTask.class);

    @Input
    /** The output parent directory. */
    private String outputParentDirectory;

    @Input
    /** The output directory. */
    private String outputDirectory;

    @Input
    /** The filter class package. */
    private String filterClassPackage = ""; // multiple split by ";"

    @Input
    /** The generate proto file. */
    private String generateProtoFile = "false"; // true to generate proto file

    /** The classes. */
    private URL[] classes;
    
    /** The project. */
    private ProjectInternal project;
    
    /**
     * Sets the project.
     *
     * @param project the new project
     */
    public void setProject(ProjectInternal project) {
        this.project = project;
    }
    

    /**
     * getter method for property outputParentDirectory.
     *
     * @return the outputParentDirectory
     */
    public String getOutputParentDirectory() {
        return outputParentDirectory;
    }

    /**
     * setter method for property outputParentDirectory.
     *
     * @param outputParentDirectory the outputParentDirectory to set
     */
    public void setOutputParentDirectory(String outputParentDirectory) {
        this.outputParentDirectory = outputParentDirectory;
    }

    /**
     * getter method for property outputDirectory.
     *
     * @return the outputDirectory
     */
    public String getOutputDirectory() {
        return outputDirectory;
    }

    /**
     * setter method for property outputDirectory.
     *
     * @param outputDirectory the outputDirectory to set
     */
    public void setOutputDirectory(String outputDirectory) {
        this.outputDirectory = outputDirectory;
    }

    /**
     * getter method for property filterClassPackage.
     *
     * @return the filterClassPackage
     */
    public String getFilterClassPackage() {
        return filterClassPackage;
    }

    /**
     * setter method for property filterClassPackage.
     *
     * @param filterClassPackage the filterClassPackage to set
     */
    public void setFilterClassPackage(String filterClassPackage) {
        this.filterClassPackage = filterClassPackage;
    }

    /**
     * getter method for property generateProtoFile.
     *
     * @return the generateProtoFile
     */
    public String getGenerateProtoFile() {
        return generateProtoFile;
    }

    /**
     * setter method for property generateProtoFile.
     *
     * @param generateProtoFile the generateProtoFile to set
     */
    public void setGenerateProtoFile(String generateProtoFile) {
        this.generateProtoFile = generateProtoFile;
    }

    /**
     * Say greeting.
     */
    @TaskAction
    void doPrecompileAction() {
        LOGGER.info("begin to execute jprotobuf precompile action.");
        LOGGER.info("outputParentDirectory=" + outputParentDirectory);
        LOGGER.info("outputDirectory=" + outputDirectory);
        LOGGER.info("filterClassPackage=" + filterClassPackage);
        LOGGER.info("generateProtoFile=" + generateProtoFile);
        
        Task javaCompiletask = project.getTasks().getByName(JavaPlugin.COMPILE_JAVA_TASK_NAME);
        // get create spec method
        Method createSpecMethod = ReflectionUtils.findMethod(javaCompiletask.getClass(), "createSpec");
        final List<URL> list = new ArrayList<URL>();
        List<File> classFiles = new ArrayList<File>();
        if (createSpecMethod != null) {
            createSpecMethod.setAccessible(true);
            Object ret = ReflectionUtils.invokeMethod(createSpecMethod, javaCompiletask);
            DefaultJavaCompileSpec spec = (DefaultJavaCompileSpec) ret;
            
            List<File> compileClasspath = spec.getCompileClasspath();
            classFiles.addAll(compileClasspath);
            compileClasspath.forEach(path -> {
                try {
                    list.add(path.toURI().toURL());
                } catch (MalformedURLException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            });
        }
        

        String classesPath = outputParentDirectory + File.separator + PrecompilePlugin.CLASSES_PATH;
        mkdirs(classesPath);
        String libsPath = outputParentDirectory + File.separator + PrecompilePlugin.LIBS_PATH;
        mkdirs(libsPath);

        File classPath = new File(classesPath);
        try {
            list.add(classPath.toURI().toURL());
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        }
        listURLFiles(libsPath, "jar", list);
        classes = list.toArray(new URL[list.size()]);
        
        classFiles.add(classPath);
        
        URLClassLoader urlClassLoader = new URLClassLoader(classes, Protobuf.class.getClassLoader());
        try {
            Thread.currentThread().setContextClassLoader(urlClassLoader);
            String[] arguments =
                    new String[] { outputParentDirectory, outputDirectory, filterClassPackage, generateProtoFile };
            JprotobufPreCompileMain.classFiles = classFiles;
            JprotobufPreCompileMain.main(arguments);

            LOGGER.info("execute jprotobuf precompile action finished.");
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            try {
                urlClassLoader.close();
            } catch (Exception e) {
                LOGGER.warn(e.getMessage());
            }
        }

    }

    /**
     * List URL files.
     *
     * @param classesPath the classes path
     * @param ext the ext
     * @param list the list
     */
    private void listURLFiles(String classesPath, String ext, final List<URL> list) {
        Collection listFiles = FileUtils.listFiles(new File(classesPath), new String[] { ext }, true);
        if (listFiles != null) {
            for (Object f : listFiles) {
                try {
                    list.add(((File) f).toURI().toURL());
                } catch (Exception e) {
                    LOGGER.warn(e.getMessage());
                }
            }
        }
    }
    

    /**
     * Mkdir.
     *
     * @param path the path
     */
    private void mkdirs(String path) {
        File f = new File(path);
        f.mkdirs();
    }
}
