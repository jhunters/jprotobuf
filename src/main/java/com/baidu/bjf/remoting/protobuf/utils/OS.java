/*
 * Copyright (c) Baidu Inc. All rights reserved.
 * 
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.baidu.bjf.remoting.protobuf.utils;

import java.util.Locale;

/**
 * Condition that tests the OS type.
 */
public final class OS {
    private static final String FAMILY_OS_400 = "os/400";

    private static final String FAMILY_Z_OS = "z/os";

    private static final String FAMILY_WIN9X = "win9x";

    private static final String FAMILY_OPENVMS = "openvms";

    private static final String FAMILY_UNIX = "unix";

    private static final String FAMILY_TANDEM = "tandem";

    private static final String FAMILY_MAC = "mac";

    private static final String FAMILY_DOS = "dos";

    private static final String FAMILY_NETWARE = "netware";

    private static final String FAMILY_OS_2 = "os/2";

    private static final String FAMILY_WINDOWS = "windows";

    private static final String OS_NAME = System.getProperty("os.name").toLowerCase(Locale.US);

    private static final String OS_ARCH = System.getProperty("os.arch").toLowerCase(Locale.US);

    private static final String OS_VERSION = System.getProperty("os.version").toLowerCase(Locale.US);

    private static final String PATH_SEP = System.getProperty("path.separator");

    /**
     * Default constructor
     */
    private OS() {
    }

    /**
     * Determines if the OS on which Ant is executing matches the given OS family. * Possible values:<br />
     * <ul>
     * <li>dos</li>
     * <li>mac</li>
     * <li>netware</li>
     * <li>os/2</li>
     * <li>tandem</li>
     * <li>unix</li>
     * <li>windows</li>
     * <li>win9x</li>
     * <li>z/os</li>
     * <li>os/400</li>
     * </ul>
     * 
     * @param family the family to check for
     * @return true if the OS matches
     */
    private static boolean isFamily(final String family) {
        return isOs(family, null, null, null);
    }

    public static boolean isFamilyDOS() {
        return isFamily(FAMILY_DOS);
    }

    public static boolean isFamilyMac() {
        return isFamily(FAMILY_MAC);
    }

    public static boolean isFamilyNetware() {
        return isFamily(FAMILY_NETWARE);
    }

    public static boolean isFamilyOS2() {
        return isFamily(FAMILY_OS_2);
    }

    public static boolean isFamilyTandem() {
        return isFamily(FAMILY_TANDEM);
    }

    public static boolean isFamilyUnix() {
        return isFamily(FAMILY_UNIX);
    }

    public static boolean isFamilyWindows() {
        return isFamily(FAMILY_WINDOWS);
    }

    public static boolean isFamilyWin9x() {
        return isFamily(FAMILY_WIN9X);
    }

    public static boolean isFamilyZOS() {
        return isFamily(FAMILY_Z_OS);
    }

    public static boolean isFamilyOS400() {
        return isFamily(FAMILY_OS_400);
    }

    public static boolean isFamilyOpenVms() {
        return isFamily(FAMILY_OPENVMS);
    }

    /**
     * Determines if the OS on which Ant is executing matches the given OS name.
     * 
     * @param name the OS name to check for
     * @return true if the OS matches
     */
    public static boolean isName(final String name) {
        return isOs(null, name, null, null);
    }

    /**
     * Determines if the OS on which Ant is executing matches the given OS architecture.
     * 
     * @param arch the OS architecture to check for
     * @return true if the OS matches
     */
    public static boolean isArch(final String arch) {
        return isOs(null, null, arch, null);
    }

    /**
     * Determines if the OS on which Ant is executing matches the given OS version.
     * 
     * @param version the OS version to check for
     * @return true if the OS matches
     */
    public static boolean isVersion(final String version) {
        return isOs(null, null, null, version);
    }

    /**
     * Determines if the OS on which Ant is executing matches the given OS family, name, architecture and version
     * 
     * @param family The OS family
     * @param name The OS name
     * @param arch The OS architecture
     * @param version The OS version
     * @return true if the OS matches
     */
    public static boolean isOs(final String family, final String name, final String arch, final String version) {
        boolean retValue = false;

        if (family != null || name != null || arch != null || version != null) {

            boolean isFamily = true;
            boolean isName = true;
            boolean isArch = true;
            boolean isVersion = true;

            if (family != null) {
                if (family.equals(FAMILY_WINDOWS)) {
                    isFamily = OS_NAME.indexOf(FAMILY_WINDOWS) > -1;
                } else if (family.equals(FAMILY_OS_2)) {
                    isFamily = OS_NAME.indexOf(FAMILY_OS_2) > -1;
                } else if (family.equals(FAMILY_NETWARE)) {
                    isFamily = OS_NAME.indexOf(FAMILY_NETWARE) > -1;
                } else if (family.equals(FAMILY_DOS)) {
                    isFamily = PATH_SEP.equals(";") && !isFamily(FAMILY_NETWARE);
                } else if (family.equals(FAMILY_MAC)) {
                    isFamily = OS_NAME.indexOf(FAMILY_MAC) > -1;
                } else if (family.equals(FAMILY_TANDEM)) {
                    isFamily = OS_NAME.indexOf("nonstop_kernel") > -1;
                } else if (family.equals(FAMILY_UNIX)) {
                    isFamily = PATH_SEP.equals(":") && !isFamily(FAMILY_OPENVMS)
                            && (!isFamily(FAMILY_MAC) || OS_NAME.endsWith("x"));
                } else if (family.equals(FAMILY_WIN9X)) {
                    isFamily = isFamily(FAMILY_WINDOWS) && (OS_NAME.indexOf("95") >= 0 || OS_NAME.indexOf("98") >= 0
                            || OS_NAME.indexOf("me") >= 0 || OS_NAME.indexOf("ce") >= 0);
                } else if (family.equals(FAMILY_Z_OS)) {
                    isFamily = OS_NAME.indexOf(FAMILY_Z_OS) > -1 || OS_NAME.indexOf("os/390") > -1;
                } else if (family.equals(FAMILY_OS_400)) {
                    isFamily = OS_NAME.indexOf(FAMILY_OS_400) > -1;
                } else if (family.equals(FAMILY_OPENVMS)) {
                    isFamily = OS_NAME.indexOf(FAMILY_OPENVMS) > -1;
                } else {
                    throw new IllegalArgumentException("Don\'t know how to detect os family \"" + family + "\"");
                }
            }
            if (name != null) {
                isName = name.equals(OS_NAME);
            }
            if (arch != null) {
                isArch = arch.equals(OS_ARCH);
            }
            if (version != null) {
                isVersion = version.equals(OS_VERSION);
            }
            retValue = isFamily && isName && isArch && isVersion;
        }
        return retValue;
    }
}
