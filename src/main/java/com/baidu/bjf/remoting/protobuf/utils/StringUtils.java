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

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.ByteString;

/**
 * String utility class.
 * 
 * @author xiemalin
 * @since 1.2.5
 */
public class StringUtils {
    
    /**
     * 
     */
    public static final String EMPTY_STRING = "";
    
    /**
     * The empty String <code>""</code>.
     * @since 2.0
     */
    public static final String EMPTY = "";
    
    /**
     * <p>
     * Check if a String ends with a specified suffix.
     * </p>
     * 
     * <p>
     * <code>null</code>s are handled without exceptions. Two <code>null</code>
     * references are considered to be equal. The comparison is case sensitive.
     * </p>
     * 
     * <pre>
     * StringUtils.endsWith(null, null)      = true
     * StringUtils.endsWith(null, "abcdef")  = false
     * StringUtils.endsWith("def", null)     = false
     * StringUtils.endsWith("def", "abcdef") = true
     * StringUtils.endsWith("def", "ABCDEF") = false
     * </pre>
     * 
     * @see java.lang.String#endsWith(String)
     * @param str
     *            the String to check, may be null
     * @param suffix
     *            the suffix to find, may be null
     * @return <code>true</code> if the String ends with the suffix, case
     *         sensitive, or both <code>null</code>
     * @since 2.4
     */
    public static boolean endsWith(String str, String suffix) {
        return endsWith(str, suffix, false);
    }

    /**
     * <p>
     * Check if a String ends with a specified suffix (optionally case
     * insensitive).
     * </p>
     * 
     * @see java.lang.String#endsWith(String)
     * @param str
     *            the String to check, may be null
     * @param suffix
     *            the suffix to find, may be null
     * @param ignoreCase
     *            inidicates whether the compare should ignore case (case
     *            insensitive) or not.
     * @return <code>true</code> if the String starts with the prefix or both
     *         <code>null</code>
     */
    private static boolean endsWith(String str, String suffix, boolean ignoreCase) {
        if (str == null || suffix == null) {
            return (str == null && suffix == null);
        }
        if (suffix.length() > str.length()) {
            return false;
        }
        int strOffset = str.length() - suffix.length();
        return str.regionMatches(ignoreCase, strOffset, suffix, 0, suffix.length());
    }

    /**
     * <p>
     * Case insensitive check if a String ends with a specified suffix.
     * </p>
     * 
     * <p>
     * <code>null</code>s are handled without exceptions. Two <code>null</code>
     * references are considered to be equal. The comparison is case
     * insensitive.
     * </p>
     * 
     * <pre>
     * StringUtils.endsWithIgnoreCase(null, null)      = true
     * StringUtils.endsWithIgnoreCase(null, "abcdef")  = false
     * StringUtils.endsWithIgnoreCase("def", null)     = false
     * StringUtils.endsWithIgnoreCase("def", "abcdef") = true
     * StringUtils.endsWithIgnoreCase("def", "ABCDEF") = false
     * </pre>
     * 
     * @see java.lang.String#endsWith(String)
     * @param str
     *            the String to check, may be null
     * @param suffix
     *            the suffix to find, may be null
     * @return <code>true</code> if the String ends with the suffix, case
     *         insensitive, or both <code>null</code>
     * @since 2.4
     */
    public static boolean endsWithIgnoreCase(String str, String suffix) {
        return endsWith(str, suffix, true);
    }

    /**
     * <p>
     * Removes a substring only if it is at the end of a source string,
     * otherwise returns the source string.
     * </p>
     * 
     * <p>
     * A <code>null</code> source string will return <code>null</code>. An empty
     * ("") source string will return the empty string. A <code>null</code>
     * search string will return the source string.
     * </p>
     * 
     * <pre>
     * StringUtils.removeEnd(null, *)      = null
     * StringUtils.removeEnd("", *)        = ""
     * StringUtils.removeEnd(*, null)      = *
     * StringUtils.removeEnd("www.domain.com", ".com.")  = "www.domain.com"
     * StringUtils.removeEnd("www.domain.com", ".com")   = "www.domain"
     * StringUtils.removeEnd("www.domain.com", "domain") = "www.domain.com"
     * StringUtils.removeEnd("abc", "")    = "abc"
     * </pre>
     * 
     * @param str
     *            the source String to search, may be null
     * @param remove
     *            the String to search for and remove, may be null
     * @return the substring with the string removed if found, <code>null</code>
     *         if null String input
     * @since 2.1
     */
    public static String removeEnd(String str, String remove) {
        if (isEmpty(str) || isEmpty(remove)) {
            return str;
        }
        if (str.endsWith(remove)) {
            return str.substring(0, str.length() - remove.length());
        }
        return str;
    }

    /**
     * <p>
     * Case insensitive removal of a substring if it is at the end of a source
     * string, otherwise returns the source string.
     * </p>
     * 
     * <p>
     * A <code>null</code> source string will return <code>null</code>. An empty
     * ("") source string will return the empty string. A <code>null</code>
     * search string will return the source string.
     * </p>
     * 
     * <pre>
     * StringUtils.removeEnd(null, *)      = null
     * StringUtils.removeEnd("", *)        = ""
     * StringUtils.removeEnd(*, null)      = *
     * StringUtils.removeEnd("www.domain.com", ".com.")  = "www.domain.com."
     * StringUtils.removeEnd("www.domain.com", ".com")   = "www.domain"
     * StringUtils.removeEnd("www.domain.com", "domain") = "www.domain.com"
     * StringUtils.removeEnd("abc", "")    = "abc"
     * </pre>
     * 
     * @param str
     *            the source String to search, may be null
     * @param remove
     *            the String to search for (case insensitive) and remove, may be
     *            null
     * @return the substring with the string removed if found, <code>null</code>
     *         if null String input
     * @since 2.4
     */
    public static String removeEndIgnoreCase(String str, String remove) {
        if (isEmpty(str) || isEmpty(remove)) {
            return str;
        }
        if (endsWithIgnoreCase(str, remove)) {
            return str.substring(0, str.length() - remove.length());
        }
        return str;
    }

    /**
     * <p>
     * Checks if a String is empty ("") or null.
     * </p>
     * 
     * <pre>
     * StringUtils.isEmpty(null)      = true
     * StringUtils.isEmpty("")        = true
     * StringUtils.isEmpty(" ")       = false
     * StringUtils.isEmpty("bob")     = false
     * StringUtils.isEmpty("  bob  ") = false
     * </pre>
     * 
     * <p>
     * NOTE: This method changed in Lang version 2.0. It no longer trims the
     * String. That functionality is available in isBlank().
     * </p>
     * 
     * @param str
     *            the String to check, may be null
     * @return <code>true</code> if the String is empty or null
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    /**
     * <p>
     * Removes a substring only if it is at the begining of a source string,
     * otherwise returns the source string.
     * </p>
     * 
     * <p>
     * A <code>null</code> source string will return <code>null</code>. An empty
     * ("") source string will return the empty string. A <code>null</code>
     * search string will return the source string.
     * </p>
     * 
     * <pre>
     * StringUtils.removeStart(null, *)      = null
     * StringUtils.removeStart("", *)        = ""
     * StringUtils.removeStart(*, null)      = *
     * StringUtils.removeStart("www.domain.com", "www.")   = "domain.com"
     * StringUtils.removeStart("domain.com", "www.")       = "domain.com"
     * StringUtils.removeStart("www.domain.com", "domain") = "www.domain.com"
     * StringUtils.removeStart("abc", "")    = "abc"
     * </pre>
     * 
     * @param str
     *            the source String to search, may be null
     * @param remove
     *            the String to search for and remove, may be null
     * @return the substring with the string removed if found, <code>null</code>
     *         if null String input
     * @since 2.1
     */
    public static String removeStart(String str, String remove) {
        if (isEmpty(str) || isEmpty(remove)) {
            return str;
        }
        if (str.startsWith(remove)) {
            return str.substring(remove.length());
        }
        return str;
    }

    /**
     * <p>
     * Case insensitive removal of a substring if it is at the begining of a
     * source string, otherwise returns the source string.
     * </p>
     * 
     * <p>
     * A <code>null</code> source string will return <code>null</code>. An empty
     * ("") source string will return the empty string. A <code>null</code>
     * search string will return the source string.
     * </p>
     * 
     * <pre>
     * StringUtils.removeStartIgnoreCase(null, *)      = null
     * StringUtils.removeStartIgnoreCase("", *)        = ""
     * StringUtils.removeStartIgnoreCase(*, null)      = *
     * StringUtils.removeStartIgnoreCase("www.domain.com", "www.")   = "domain.com"
     * StringUtils.removeStartIgnoreCase("www.domain.com", "WWW.")   = "domain.com"
     * StringUtils.removeStartIgnoreCase("domain.com", "www.")       = "domain.com"
     * StringUtils.removeStartIgnoreCase("www.domain.com", "domain") = "www.domain.com"
     * StringUtils.removeStartIgnoreCase("abc", "")    = "abc"
     * </pre>
     * 
     * @param str
     *            the source String to search, may be null
     * @param remove
     *            the String to search for (case insensitive) and remove, may be
     *            null
     * @return the substring with the string removed if found, <code>null</code>
     *         if null String input
     * @since 2.4
     */
    public static String removeStartIgnoreCase(String str, String remove) {
        if (isEmpty(str) || isEmpty(remove)) {
            return str;
        }
        if (startsWithIgnoreCase(str, remove)) {
            return str.substring(remove.length());
        }
        return str;
    }

    /**
     * <p>
     * Check if a String starts with a specified prefix.
     * </p>
     * 
     * <p>
     * <code>null</code>s are handled without exceptions. Two <code>null</code>
     * references are considered to be equal. The comparison is case sensitive.
     * </p>
     * 
     * <pre>
     * StringUtils.startsWith(null, null)      = true
     * StringUtils.startsWith(null, "abcdef")  = false
     * StringUtils.startsWith("abc", null)     = false
     * StringUtils.startsWith("abc", "abcdef") = true
     * StringUtils.startsWith("abc", "ABCDEF") = false
     * </pre>
     * 
     * @see java.lang.String#startsWith(String)
     * @param str
     *            the String to check, may be null
     * @param prefix
     *            the prefix to find, may be null
     * @return <code>true</code> if the String starts with the prefix, case
     *         sensitive, or both <code>null</code>
     * @since 2.4
     */
    public static boolean startsWith(String str, String prefix) {
        return startsWith(str, prefix, false);
    }

    /**
     * <p>Check if a String starts with any of an array of specified strings.</p>
     * 
     * <pre>
     * StringUtils.startsWithAny(null, null)      = false
     * StringUtils.startsWithAny(null, new String[] {"abc"})  = false
     * StringUtils.startsWithAny("abcxyz", null)     = false
     * StringUtils.startsWithAny("abcxyz", new String[] {""}) = false
     * StringUtils.startsWithAny("abcxyz", new String[] {"abc"}) = true
     * StringUtils.startsWithAny("abcxyz", new String[] {null, "xyz", "abc"}) = true
     * </pre>
     *
     * @see #startsWith(String, String)
     * @param string  the String to check, may be null
     * @param searchStrings the Strings to find, may be null or empty
     * @return <code>true</code> if the String starts with any of the the prefixes, case insensitive, or
     *  both <code>null</code>
     * @since 2.5
     */
    public static boolean startsWithAny(String string, String[] searchStrings) {
        if (isEmpty(string) || isEmpty(searchStrings)) {
            return false;
        }
        for (int i = 0; i < searchStrings.length; i++) {
            String searchString = searchStrings[i];
            if (StringUtils.startsWith(string, searchString)) {
                return true;
            }
        }
        return false;
    }
    
    
    /**
     * <p>
     * Case insensitive check if a String starts with a specified prefix.
     * </p>
     * 
     * <p>
     * <code>null</code>s are handled without exceptions. Two <code>null</code>
     * references are considered to be equal. The comparison is case
     * insensitive.
     * </p>
     * 
     * <pre>
     * StringUtils.startsWithIgnoreCase(null, null)      = true
     * StringUtils.startsWithIgnoreCase(null, "abcdef")  = false
     * StringUtils.startsWithIgnoreCase("abc", null)     = false
     * StringUtils.startsWithIgnoreCase("abc", "abcdef") = true
     * StringUtils.startsWithIgnoreCase("abc", "ABCDEF") = true
     * </pre>
     * 
     * @see java.lang.String#startsWith(String)
     * @param str
     *            the String to check, may be null
     * @param prefix
     *            the prefix to find, may be null
     * @return <code>true</code> if the String starts with the prefix, case
     *         insensitive, or both <code>null</code>
     * @since 2.4
     */
    public static boolean startsWithIgnoreCase(String str, String prefix) {
        return startsWith(str, prefix, true);
    }

    /**
     * <p>
     * Check if a String starts with a specified prefix (optionally case
     * insensitive).
     * </p>
     * 
     * @see java.lang.String#startsWith(String)
     * @param str
     *            the String to check, may be null
     * @param prefix
     *            the prefix to find, may be null
     * @param ignoreCase
     *            inidicates whether the compare should ignore case (case
     *            insensitive) or not.
     * @return <code>true</code> if the String starts with the prefix or both
     *         <code>null</code>
     */
    private static boolean startsWith(String str, String prefix, boolean ignoreCase) {
        if (str == null || prefix == null) {
            return (str == null && prefix == null);
        }
        if (prefix.length() > str.length()) {
            return false;
        }
        return str.regionMatches(ignoreCase, 0, prefix, 0, prefix.length());
    }
    
    /**
     * <p>Gets the substring before the first occurrence of a separator.
     * The separator is not returned.</p>
     *
     * <p>A <code>null</code> string input will return <code>null</code>.
     * An empty ("") string input will return the empty string.
     * A <code>null</code> separator will return the input string.</p>
     *
     * <pre>
     * StringUtils.substringBefore(null, *)      = null
     * StringUtils.substringBefore("", *)        = ""
     * StringUtils.substringBefore("abc", "a")   = ""
     * StringUtils.substringBefore("abcba", "b") = "a"
     * StringUtils.substringBefore("abc", "c")   = "ab"
     * StringUtils.substringBefore("abc", "d")   = "abc"
     * StringUtils.substringBefore("abc", "")    = ""
     * StringUtils.substringBefore("abc", null)  = "abc"
     * </pre>
     *
     * @param str  the String to get a substring from, may be null
     * @param separator  the String to search for, may be null
     * @return the substring before the first occurrence of the separator,
     *  <code>null</code> if null String input
     * @since 2.0
     */
    public static String substringBefore(String str, String separator) {
        if (isEmpty(str) || separator == null) {
            return str;
        }
        if (separator.length() == 0) {
            return EMPTY;
        }
        int pos = str.indexOf(separator);
        if (pos == -1) {
            return str;
        }
        return str.substring(0, pos);
    }
    
    /**
     * <p>Gets the substring before the last occurrence of a separator.
     * The separator is not returned.</p>
     *
     * <p>A <code>null</code> string input will return <code>null</code>.
     * An empty ("") string input will return the empty string.
     * An empty or <code>null</code> separator will return the input string.</p>
     *
     * <pre>
     * StringUtils.substringBeforeLast(null, *)      = null
     * StringUtils.substringBeforeLast("", *)        = ""
     * StringUtils.substringBeforeLast("abcba", "b") = "abc"
     * StringUtils.substringBeforeLast("abc", "c")   = "ab"
     * StringUtils.substringBeforeLast("a", "a")     = ""
     * StringUtils.substringBeforeLast("a", "z")     = "a"
     * StringUtils.substringBeforeLast("a", null)    = "a"
     * StringUtils.substringBeforeLast("a", "")      = "a"
     * </pre>
     *
     * @param str  the String to get a substring from, may be null
     * @param separator  the String to search for, may be null
     * @return the substring before the last occurrence of the separator,
     *  <code>null</code> if null String input
     * @since 2.0
     */
    public static String substringBeforeLast(String str, String separator) {
        if (isEmpty(str) || isEmpty(separator)) {
            return str;
        }
        int pos = str.lastIndexOf(separator);
        if (pos == -1) {
            return str;
        }
        return str.substring(0, pos);
    }
    
    /**
     * <p>Gets the substring after the last occurrence of a separator.
     * The separator is not returned.</p>
     *
     * <p>A <code>null</code> string input will return <code>null</code>.
     * An empty ("") string input will return the empty string.
     * An empty or <code>null</code> separator will return the empty string if
     * the input string is not <code>null</code>.</p>
     *
     * <pre>
     * StringUtils.substringAfterLast(null, *)      = null
     * StringUtils.substringAfterLast("", *)        = ""
     * StringUtils.substringAfterLast(*, "")        = ""
     * StringUtils.substringAfterLast(*, null)      = ""
     * StringUtils.substringAfterLast("abc", "a")   = "bc"
     * StringUtils.substringAfterLast("abcba", "b") = "a"
     * StringUtils.substringAfterLast("abc", "c")   = ""
     * StringUtils.substringAfterLast("a", "a")     = ""
     * StringUtils.substringAfterLast("a", "z")     = ""
     * </pre>
     *
     * @param str  the String to get a substring from, may be null
     * @param separator  the String to search for, may be null
     * @return the substring after the last occurrence of the separator,
     *  <code>null</code> if null String input
     * @since 2.0
     */
    public static String substringAfterLast(String str, String separator) {
        if (isEmpty(str)) {
            return str;
        }
        if (isEmpty(separator)) {
            return EMPTY;
        }
        int pos = str.lastIndexOf(separator);
        if (pos == -1 || pos == (str.length() - separator.length())) {
            return EMPTY;
        }
        return str.substring(pos + separator.length());
    }

    /**
     * <p>Capitalizes a String changing the first letter to title case as
     * per {@link Character#toTitleCase(char)}. No other letters are changed.</p>
     *
     * <p>For a word based algorithm, see {@link WordUtils#capitalize(String)}.
     * A <code>null</code> input String returns <code>null</code>.</p>
     *
     * <pre>
     * StringUtils.capitalize(null)  = null
     * StringUtils.capitalize("")    = ""
     * StringUtils.capitalize("cat") = "Cat"
     * StringUtils.capitalize("cAt") = "CAt"
     * </pre>
     *
     * @param str  the String to capitalize, may be null
     * @return the capitalized String, <code>null</code> if null String input
     * @see WordUtils#capitalize(String)
     * @see #uncapitalize(String)
     * @since 2.0
     */
    public static String capitalize(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return str;
        }
        return new StringBuffer(strLen)
            .append(Character.toTitleCase(str.charAt(0)))
            .append(str.substring(1))
            .toString();
    }
    
    /**
     * <p>
     * Escapes the characters in a <code>String</code> using Java String rules.
     * </p>
     * 
     * <p>
     * Deals correctly with quotes and control-chars (tab, backslash, cr, ff, etc.)
     * </p>
     * 
     * <p>
     * So a tab becomes the characters <code>'\\'</code> and <code>'t'</code>.
     * </p>
     * 
     * <p>
     * The only difference between Java strings and JavaScript strings is that in JavaScript, a single quote must be
     * escaped.
     * </p>
     * 
     * <p>
     * Example:
     * 
     * <pre>
     * input string: He didn't say, "Stop!"
     * output string: He didn't say, \"Stop!\"
     * </pre>
     * 
     * </p>
     * 
     * @param str String to escape values in, may be null
     * @return String with escaped values, <code>null</code> if null string input
     */
    public static String escapeJava(String str) {
        return escapeJavaStyleString(str, false);
    }

    /**
     * <p>
     * Escapes the characters in a <code>String</code> using Java String rules to a <code>Writer</code>.
     * </p>
     * 
     * <p>
     * A <code>null</code> string input has no effect.
     * </p>
     * 
     * @see #escapeJava(java.lang.String)
     * @param out Writer to write escaped string into
     * @param str String to escape values in, may be null
     * @throws IllegalArgumentException if the Writer is <code>null</code>
     * @throws IOException if error occurs on underlying Writer
     */
    public static void escapeJava(Writer out, String str) throws IOException {
        escapeJavaStyleString(out, str, false);
    }

    /**
     * <p>
     * Worker method for the {@link #escapeJavaScript(String)} method.
     * </p>
     * 
     * @param str String to escape values in, may be null
     * @param escapeSingleQuotes escapes single quotes if <code>true</code>
     * @return the escaped string
     */
    private static String escapeJavaStyleString(String str, boolean escapeSingleQuotes) {
        if (str == null) {
            return null;
        }
        try {
            StringWriter writer = new StringWriter(str.length() * 2);
            escapeJavaStyleString(writer, str, escapeSingleQuotes);
            return writer.toString();
        } catch (IOException ioe) {
            // this should never ever happen while writing to a StringWriter
            ioe.printStackTrace();
            return null;
        }
    }

    /**
     * <p>
     * Worker method for the {@link #escapeJavaScript(String)} method.
     * </p>
     * 
     * @param out write to receieve the escaped string
     * @param str String to escape values in, may be null
     * @param escapeSingleQuote escapes single quotes if <code>true</code>
     * @throws IOException if an IOException occurs
     */
    private static void escapeJavaStyleString(Writer out, String str, boolean escapeSingleQuote) throws IOException {
        if (out == null) {
            throw new IllegalArgumentException("The Writer must not be null");
        }
        if (str == null) {
            return;
        }
        int sz;
        sz = str.length();
        for (int i = 0; i < sz; i++) {
            char ch = str.charAt(i);

            // handle unicode
            if (ch > 0xfff) {
                out.write("\\u" + hex(ch));
            } else if (ch > 0xff) {
                out.write("\\u0" + hex(ch));
            } else if (ch > 0x7f) {
                out.write("\\u00" + hex(ch));
            } else if (ch < 32) {
                switch (ch) {
                    case '\b':
                        out.write('\\');
                        out.write('b');
                        break;
                    case '\n':
                        out.write('\\');
                        out.write('n');
                        break;
                    case '\t':
                        out.write('\\');
                        out.write('t');
                        break;
                    case '\f':
                        out.write('\\');
                        out.write('f');
                        break;
                    case '\r':
                        out.write('\\');
                        out.write('r');
                        break;
                    default:
                        if (ch > 0xf) {
                            out.write("\\u00" + hex(ch));
                        } else {
                            out.write("\\u000" + hex(ch));
                        }
                        break;
                }
            } else {
                switch (ch) {
                    case '\'':
                        if (escapeSingleQuote) {
                            out.write('\\');
                        }
                        out.write('\'');
                        break;
                    case '"':
                        out.write('\\');
                        out.write('"');
                        break;
                    case '\\':
                        out.write('\\');
                        out.write('\\');
                        break;
                    case '/':
                        out.write('\\');
                        out.write('/');
                        break;
                    default:
                        out.write(ch);
                        break;
                }
            }
        }
    }

    /**
     * <p>
     * Unescapes any Java literals found in the <code>String</code>. For example, it will turn a sequence of
     * <code>'\'</code> and <code>'n'</code> into a newline character, unless the <code>'\'</code> is preceded by
     * another <code>'\'</code>.
     * </p>
     * 
     * @param str the <code>String</code> to unescape, may be null
     * @return a new unescaped <code>String</code>, <code>null</code> if null string input
     */
    public static String unescapeJava(String str) {
        if (str == null) {
            return null;
        }
        try {
            StringWriter writer = new StringWriter(str.length());
            unescapeJava(writer, str);
            return writer.toString();
        } catch (IOException ioe) {
            // this should never ever happen while writing to a StringWriter
            ioe.printStackTrace();
            return null;
        }
    }

    /**
     * <p>
     * Unescapes any Java literals found in the <code>String</code> to a <code>Writer</code>.
     * </p>
     * 
     * <p>
     * For example, it will turn a sequence of <code>'\'</code> and <code>'n'</code> into a newline character, unless
     * the <code>'\'</code> is preceded by another <code>'\'</code>.
     * </p>
     * 
     * <p>
     * A <code>null</code> string input has no effect.
     * </p>
     * 
     * @param out the <code>Writer</code> used to output unescaped characters
     * @param str the <code>String</code> to unescape, may be null
     * @throws IllegalArgumentException if the Writer is <code>null</code>
     * @throws IOException if error occurs on underlying Writer
     */
    public static void unescapeJava(Writer out, String str) throws IOException {
        if (out == null) {
            throw new IllegalArgumentException("The Writer must not be null");
        }
        if (str == null) {
            return;
        }
        int sz = str.length();
        StringBuffer unicode = new StringBuffer(4);
        boolean hadSlash = false;
        boolean inUnicode = false;
        for (int i = 0; i < sz; i++) {
            char ch = str.charAt(i);
            if (inUnicode) {
                // if in unicode, then we're reading unicode
                // values in somehow
                unicode.append(ch);
                if (unicode.length() == 4) {
                    // unicode now contains the four hex digits
                    // which represents our unicode character
                    try {
                        int value = Integer.parseInt(unicode.toString(), 16);
                        out.write((char) value);
                        unicode.setLength(0);
                        inUnicode = false;
                        hadSlash = false;
                    } catch (NumberFormatException nfe) {
                        throw new RuntimeException("Unable to parse unicode value: " + unicode, nfe);
                    }
                }
                continue;
            }
            if (hadSlash) {
                // handle an escaped value
                hadSlash = false;
                switch (ch) {
                    case '\\':
                        out.write('\\');
                        break;
                    case '\'':
                        out.write('\'');
                        break;
                    case '\"':
                        out.write('"');
                        break;
                    case 'r':
                        out.write('\r');
                        break;
                    case 'f':
                        out.write('\f');
                        break;
                    case 't':
                        out.write('\t');
                        break;
                    case 'n':
                        out.write('\n');
                        break;
                    case 'b':
                        out.write('\b');
                        break;
                    case 'u': {
                        // uh-oh, we're in unicode country....
                        inUnicode = true;
                        break;
                    }
                    default:
                        out.write(ch);
                        break;
                }
                continue;
            } else if (ch == '\\') {
                hadSlash = true;
                continue;
            }
            out.write(ch);
        }
        if (hadSlash) {
            // then we're in the weird case of a \ at the end of the
            // string, let's output it anyway.
            out.write('\\');
        }
    }

    /**
     * <p>
     * Returns an upper case hexadecimal <code>String</code> for the given character.
     * </p>
     * 
     * @param ch The character to convert.
     * @return An upper case hexadecimal <code>String</code>
     */
    private static String hex(char ch) {
        return Integer.toHexString(ch).toUpperCase();
    }

    /**
     * <p>
     * Splits the provided text into an array, using whitespace as the separator. Whitespace is defined by
     * {@link Character#isWhitespace(char)}.
     * </p>
     * 
     * <p>
     * The separator is not included in the returned String array. Adjacent separators are treated as one separator. For
     * more control over the split use the StrTokenizer class.
     * </p>
     * 
     * <p>
     * A <code>null</code> input String returns <code>null</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.split(null)       = null
     * StringUtils.split("")         = []
     * StringUtils.split("abc def")  = ["abc", "def"]
     * StringUtils.split("abc  def") = ["abc", "def"]
     * StringUtils.split(" abc ")    = ["abc"]
     * </pre>
     * 
     * @param str the String to parse, may be null
     * @return an array of parsed Strings, <code>null</code> if null String input
     */
    public static String[] split(String str) {
        return split(str, null, -1);
    }

    /**
     * <p>
     * Splits the provided text into an array, separator specified. This is an alternative to using StringTokenizer.
     * </p>
     * 
     * <p>
     * The separator is not included in the returned String array. Adjacent separators are treated as one separator. For
     * more control over the split use the StrTokenizer class.
     * </p>
     * 
     * <p>
     * A <code>null</code> input String returns <code>null</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.split(null, *)         = null
     * StringUtils.split("", *)           = []
     * StringUtils.split("a.b.c", '.')    = ["a", "b", "c"]
     * StringUtils.split("a..b.c", '.')   = ["a", "b", "c"]
     * StringUtils.split("a:b:c", '.')    = ["a:b:c"]
     * StringUtils.split("a b c", ' ')    = ["a", "b", "c"]
     * </pre>
     * 
     * @param str the String to parse, may be null
     * @param separatorChar the character used as the delimiter
     * @return an array of parsed Strings, <code>null</code> if null String input
     * @since 2.0
     */
    public static String[] split(String str, char separatorChar) {
        return splitWorker(str, separatorChar, false);
    }

    /**
     * <p>
     * Splits the provided text into an array, separators specified. This is an alternative to using StringTokenizer.
     * </p>
     * 
     * <p>
     * The separator is not included in the returned String array. Adjacent separators are treated as one separator. For
     * more control over the split use the StrTokenizer class.
     * </p>
     * 
     * <p>
     * A <code>null</code> input String returns <code>null</code>. A <code>null</code> separatorChars splits on
     * whitespace.
     * </p>
     * 
     * <pre>
     * StringUtils.split(null, *)         = null
     * StringUtils.split("", *)           = []
     * StringUtils.split("abc def", null) = ["abc", "def"]
     * StringUtils.split("abc def", " ")  = ["abc", "def"]
     * StringUtils.split("abc  def", " ") = ["abc", "def"]
     * StringUtils.split("ab:cd:ef", ":") = ["ab", "cd", "ef"]
     * </pre>
     * 
     * @param str the String to parse, may be null
     * @param separatorChars the characters used as the delimiters, <code>null</code> splits on whitespace
     * @return an array of parsed Strings, <code>null</code> if null String input
     */
    public static String[] split(String str, String separatorChars) {
        return splitWorker(str, separatorChars, -1, false);
    }

    /**
     * <p>
     * Splits the provided text into an array with a maximum length, separators specified.
     * </p>
     * 
     * <p>
     * The separator is not included in the returned String array. Adjacent separators are treated as one separator.
     * </p>
     * 
     * <p>
     * A <code>null</code> input String returns <code>null</code>. A <code>null</code> separatorChars splits on
     * whitespace.
     * </p>
     * 
     * <p>
     * If more than <code>max</code> delimited substrings are found, the last returned string includes all characters
     * after the first <code>max - 1</code> returned strings (including separator characters).
     * </p>
     * 
     * <pre>
     * StringUtils.split(null, *, *)            = null
     * StringUtils.split("", *, *)              = []
     * StringUtils.split("ab de fg", null, 0)   = ["ab", "cd", "ef"]
     * StringUtils.split("ab   de fg", null, 0) = ["ab", "cd", "ef"]
     * StringUtils.split("ab:cd:ef", ":", 0)    = ["ab", "cd", "ef"]
     * StringUtils.split("ab:cd:ef", ":", 2)    = ["ab", "cd:ef"]
     * </pre>
     * 
     * @param str the String to parse, may be null
     * @param separatorChars the characters used as the delimiters, <code>null</code> splits on whitespace
     * @param max the maximum number of elements to include in the array. A zero or negative value implies no limit
     * @return an array of parsed Strings, <code>null</code> if null String input
     */
    public static String[] split(String str, String separatorChars, int max) {
        return splitWorker(str, separatorChars, max, false);
    }

    /**
     * <p>
     * Splits the provided text into an array, separator string specified.
     * </p>
     * 
     * <p>
     * The separator(s) will not be included in the returned String array. Adjacent separators are treated as one
     * separator.
     * </p>
     * 
     * <p>
     * A <code>null</code> input String returns <code>null</code>. A <code>null</code> separator splits on whitespace.
     * </p>
     * 
     * <pre>
     * StringUtils.splitByWholeSeparator(null, *)               = null
     * StringUtils.splitByWholeSeparator("", *)                 = []
     * StringUtils.splitByWholeSeparator("ab de fg", null)      = ["ab", "de", "fg"]
     * StringUtils.splitByWholeSeparator("ab   de fg", null)    = ["ab", "de", "fg"]
     * StringUtils.splitByWholeSeparator("ab:cd:ef", ":")       = ["ab", "cd", "ef"]
     * StringUtils.splitByWholeSeparator("ab-!-cd-!-ef", "-!-") = ["ab", "cd", "ef"]
     * </pre>
     * 
     * @param str the String to parse, may be null
     * @param separator String containing the String to be used as a delimiter, <code>null</code> splits on whitespace
     * @return an array of parsed Strings, <code>null</code> if null String was input
     */
    public static String[] splitByWholeSeparator(String str, String separator) {
        return splitByWholeSeparatorWorker(str, separator, -1, false);
    }

    /**
     * <p>
     * Splits the provided text into an array, separator string specified. Returns a maximum of <code>max</code>
     * substrings.
     * </p>
     * 
     * <p>
     * The separator(s) will not be included in the returned String array. Adjacent separators are treated as one
     * separator.
     * </p>
     * 
     * <p>
     * A <code>null</code> input String returns <code>null</code>. A <code>null</code> separator splits on whitespace.
     * </p>
     * 
     * <pre>
     * StringUtils.splitByWholeSeparator(null, *, *)               = null
     * StringUtils.splitByWholeSeparator("", *, *)                 = []
     * StringUtils.splitByWholeSeparator("ab de fg", null, 0)      = ["ab", "de", "fg"]
     * StringUtils.splitByWholeSeparator("ab   de fg", null, 0)    = ["ab", "de", "fg"]
     * StringUtils.splitByWholeSeparator("ab:cd:ef", ":", 2)       = ["ab", "cd:ef"]
     * StringUtils.splitByWholeSeparator("ab-!-cd-!-ef", "-!-", 5) = ["ab", "cd", "ef"]
     * StringUtils.splitByWholeSeparator("ab-!-cd-!-ef", "-!-", 2) = ["ab", "cd-!-ef"]
     * </pre>
     * 
     * @param str the String to parse, may be null
     * @param separator String containing the String to be used as a delimiter, <code>null</code> splits on whitespace
     * @param max the maximum number of elements to include in the returned array. A zero or negative value implies no
     *            limit.
     * @return an array of parsed Strings, <code>null</code> if null String was input
     */
    public static String[] splitByWholeSeparator(String str, String separator, int max) {
        return splitByWholeSeparatorWorker(str, separator, max, false);
    }

    /**
     * <p>
     * Splits the provided text into an array, separator string specified.
     * </p>
     * 
     * <p>
     * The separator is not included in the returned String array. Adjacent separators are treated as separators for
     * empty tokens. For more control over the split use the StrTokenizer class.
     * </p>
     * 
     * <p>
     * A <code>null</code> input String returns <code>null</code>. A <code>null</code> separator splits on whitespace.
     * </p>
     * 
     * <pre>
     * StringUtils.splitByWholeSeparatorPreserveAllTokens(null, *)               = null
     * StringUtils.splitByWholeSeparatorPreserveAllTokens("", *)                 = []
     * StringUtils.splitByWholeSeparatorPreserveAllTokens("ab de fg", null)      = ["ab", "de", "fg"]
     * StringUtils.splitByWholeSeparatorPreserveAllTokens("ab   de fg", null)    = ["ab", "", "", "de", "fg"]
     * StringUtils.splitByWholeSeparatorPreserveAllTokens("ab:cd:ef", ":")       = ["ab", "cd", "ef"]
     * StringUtils.splitByWholeSeparatorPreserveAllTokens("ab-!-cd-!-ef", "-!-") = ["ab", "cd", "ef"]
     * </pre>
     * 
     * @param str the String to parse, may be null
     * @param separator String containing the String to be used as a delimiter, <code>null</code> splits on whitespace
     * @return an array of parsed Strings, <code>null</code> if null String was input
     * @since 2.4
     */
    public static String[] splitByWholeSeparatorPreserveAllTokens(String str, String separator) {
        return splitByWholeSeparatorWorker(str, separator, -1, true);
    }

    /**
     * <p>
     * Splits the provided text into an array, separator string specified. Returns a maximum of <code>max</code>
     * substrings.
     * </p>
     * 
     * <p>
     * The separator is not included in the returned String array. Adjacent separators are treated as separators for
     * empty tokens. For more control over the split use the StrTokenizer class.
     * </p>
     * 
     * <p>
     * A <code>null</code> input String returns <code>null</code>. A <code>null</code> separator splits on whitespace.
     * </p>
     * 
     * <pre>
     * StringUtils.splitByWholeSeparatorPreserveAllTokens(null, *, *)               = null
     * StringUtils.splitByWholeSeparatorPreserveAllTokens("", *, *)                 = []
     * StringUtils.splitByWholeSeparatorPreserveAllTokens("ab de fg", null, 0)      = ["ab", "de", "fg"]
     * StringUtils.splitByWholeSeparatorPreserveAllTokens("ab   de fg", null, 0)    = ["ab", "", "", "de", "fg"]
     * StringUtils.splitByWholeSeparatorPreserveAllTokens("ab:cd:ef", ":", 2)       = ["ab", "cd:ef"]
     * StringUtils.splitByWholeSeparatorPreserveAllTokens("ab-!-cd-!-ef", "-!-", 5) = ["ab", "cd", "ef"]
     * StringUtils.splitByWholeSeparatorPreserveAllTokens("ab-!-cd-!-ef", "-!-", 2) = ["ab", "cd-!-ef"]
     * </pre>
     * 
     * @param str the String to parse, may be null
     * @param separator String containing the String to be used as a delimiter, <code>null</code> splits on whitespace
     * @param max the maximum number of elements to include in the returned array. A zero or negative value implies no
     *            limit.
     * @return an array of parsed Strings, <code>null</code> if null String was input
     * @since 2.4
     */
    public static String[] splitByWholeSeparatorPreserveAllTokens(String str, String separator, int max) {
        return splitByWholeSeparatorWorker(str, separator, max, true);
    }

    /**
     * Performs the logic for the <code>splitByWholeSeparatorPreserveAllTokens</code> methods.
     * 
     * @param str the String to parse, may be <code>null</code>
     * @param separator String containing the String to be used as a delimiter, <code>null</code> splits on whitespace
     * @param max the maximum number of elements to include in the returned array. A zero or negative value implies no
     *            limit.
     * @param preserveAllTokens if <code>true</code>, adjacent separators are treated as empty token separators; if
     *            <code>false</code>, adjacent separators are treated as one separator.
     * @return an array of parsed Strings, <code>null</code> if null String input
     * @since 2.4
     */
    private static String[]
            splitByWholeSeparatorWorker(String str, String separator, int max, boolean preserveAllTokens) {
        if (str == null) {
            return null;
        }

        int len = str.length();

        if (len == 0) {
            return new String[0];
        }

        if ((separator == null) || (EMPTY_STRING.equals(separator))) {
            // Split on whitespace.
            return splitWorker(str, null, max, preserveAllTokens);
        }

        int separatorLength = separator.length();

        ArrayList substrings = new ArrayList();
        int numberOfSubstrings = 0;
        int beg = 0;
        int end = 0;
        while (end < len) {
            end = str.indexOf(separator, beg);

            if (end > -1) {
                if (end > beg) {
                    numberOfSubstrings += 1;

                    if (numberOfSubstrings == max) {
                        end = len;
                        substrings.add(str.substring(beg));
                    } else {
                        // The following is OK, because String.substring( beg, end ) excludes
                        // the character at the position 'end'.
                        substrings.add(str.substring(beg, end));

                        // Set the starting point for the next search.
                        // The following is equivalent to beg = end + (separatorLength - 1) + 1,
                        // which is the right calculation:
                        beg = end + separatorLength;
                    }
                } else {
                    // We found a consecutive occurrence of the separator, so skip it.
                    if (preserveAllTokens) {
                        numberOfSubstrings += 1;
                        if (numberOfSubstrings == max) {
                            end = len;
                            substrings.add(str.substring(beg));
                        } else {
                            substrings.add(EMPTY_STRING);
                        }
                    }
                    beg = end + separatorLength;
                }
            } else {
                // String.substring( beg ) goes from 'beg' to the end of the String.
                substrings.add(str.substring(beg));
                end = len;
            }
        }

        return (String[]) substrings.toArray(new String[substrings.size()]);
    }

    /**
     * Performs the logic for the <code>split</code> and <code>splitPreserveAllTokens</code> methods that do not return
     * a maximum array length.
     * 
     * @param str the String to parse, may be <code>null</code>
     * @param separatorChar the separate character
     * @param preserveAllTokens if <code>true</code>, adjacent separators are treated as empty token separators; if
     *            <code>false</code>, adjacent separators are treated as one separator.
     * @return an array of parsed Strings, <code>null</code> if null String input
     */
    private static String[] splitWorker(String str, char separatorChar, boolean preserveAllTokens) {
        // Performance tuned for 2.0 (JDK1.4)

        if (str == null) {
            return null;
        }
        int len = str.length();
        if (len == 0) {
            return new String[0];
        }
        List list = new ArrayList();
        int i = 0, start = 0;
        boolean match = false;
        boolean lastMatch = false;
        while (i < len) {
            if (str.charAt(i) == separatorChar) {
                if (match || preserveAllTokens) {
                    list.add(str.substring(start, i));
                    match = false;
                    lastMatch = true;
                }
                start = ++i;
                continue;
            }
            lastMatch = false;
            match = true;
            i++;
        }
        if (match || (preserveAllTokens && lastMatch)) {
            list.add(str.substring(start, i));
        }
        return (String[]) list.toArray(new String[list.size()]);
    }

    /**
     * Performs the logic for the <code>split</code> and <code>splitPreserveAllTokens</code> methods that return a
     * maximum array length.
     * 
     * @param str the String to parse, may be <code>null</code>
     * @param separatorChars the separate character
     * @param max the maximum number of elements to include in the array. A zero or negative value implies no limit.
     * @param preserveAllTokens if <code>true</code>, adjacent separators are treated as empty token separators; if
     *            <code>false</code>, adjacent separators are treated as one separator.
     * @return an array of parsed Strings, <code>null</code> if null String input
     */
    private static String[] splitWorker(String str, String separatorChars, int max, boolean preserveAllTokens) {
        // Performance tuned for 2.0 (JDK1.4)
        // Direct code is quicker than StringTokenizer.
        // Also, StringTokenizer uses isSpace() not isWhitespace()

        if (str == null) {
            return null;
        }
        int len = str.length();
        if (len == 0) {
            return new String[0];
        }
        List list = new ArrayList();
        int sizePlus1 = 1;
        int i = 0, start = 0;
        boolean match = false;
        boolean lastMatch = false;
        if (separatorChars == null) {
            // Null separator means use whitespace
            while (i < len) {
                if (Character.isWhitespace(str.charAt(i))) {
                    if (match || preserveAllTokens) {
                        lastMatch = true;
                        if (sizePlus1++ == max) {
                            i = len;
                            lastMatch = false;
                        }
                        list.add(str.substring(start, i));
                        match = false;
                    }
                    start = ++i;
                    continue;
                }
                lastMatch = false;
                match = true;
                i++;
            }
        } else if (separatorChars.length() == 1) {
            // Optimise 1 character case
            char sep = separatorChars.charAt(0);
            while (i < len) {
                if (str.charAt(i) == sep) {
                    if (match || preserveAllTokens) {
                        lastMatch = true;
                        if (sizePlus1++ == max) {
                            i = len;
                            lastMatch = false;
                        }
                        list.add(str.substring(start, i));
                        match = false;
                    }
                    start = ++i;
                    continue;
                }
                lastMatch = false;
                match = true;
                i++;
            }
        } else {
            // standard case
            while (i < len) {
                if (separatorChars.indexOf(str.charAt(i)) >= 0) {
                    if (match || preserveAllTokens) {
                        lastMatch = true;
                        if (sizePlus1++ == max) {
                            i = len;
                            lastMatch = false;
                        }
                        list.add(str.substring(start, i));
                        match = false;
                    }
                    start = ++i;
                    continue;
                }
                lastMatch = false;
                match = true;
                i++;
            }
        }
        if (match || (preserveAllTokens && lastMatch)) {
            list.add(str.substring(start, i));
        }
        return (String[]) list.toArray(new String[list.size()]);
    }
    
    
    /**
     * Like {@link #escapeBytes(ByteString)}, but used for byte array.
     */
    public static String escapeBytes(final byte[] input) {
      return escapeBytes(new ByteSequence() {
        public int size() {
          return input.length;
        }
        public byte byteAt(int offset) {
          return input[offset];
        }
      });
    }
    
    private interface ByteSequence {
        int size();
        byte byteAt(int offset);
      }
    
    /**
     * Escapes bytes in the format used in protocol buffer text format, which
     * is the same as the format used for C string literals.  All bytes
     * that are not printable 7-bit ASCII characters are escaped, as well as
     * backslash, single-quote, and double-quote characters.  Characters for
     * which no defined short-hand escape sequence is defined will be escaped
     * using 3-digit octal sequences.
     */
    private static String escapeBytes(final ByteSequence input) {
      final StringBuilder builder = new StringBuilder(input.size());
      for (int i = 0; i < input.size(); i++) {
        final byte b = input.byteAt(i);
        if (b == -62) {
            continue;
        }
        
        switch (b) {
          // Java does not recognize \a or \v, apparently.
          case 0x07: builder.append("\\007" ); break;
          case '\b': builder.append("\\010" ); break;
          //case '\f': builder.append("\\f" ); break;
          case '\f': builder.append("\\014" ); break;
          case '\n': builder.append("\\n" ); break;
          case '\r': builder.append("\\r" ); break;
          case '\t': builder.append("\\t" ); break;
          //case 0x0b: builder.append("\\v" ); break;
          case 0x0b: builder.append("\\013" ); break;
          case '\\': builder.append("\\\\"); break;
          case '\'': builder.append("\\\'"); break;
          case '"' : builder.append("\\\""); break;
          default:
            // Only ASCII characters between 0x20 (space) and 0x7e (tilde) are
            // printable.  Other byte values must be escaped.
            if (b >= 0x20 && b <= 0x7e) {
              builder.append((char) b);
            } else {
              builder.append('\\');
              builder.append((char) ('0' + ((b >>> 6) & 3)));
              builder.append((char) ('0' + ((b >>> 3) & 7)));
              builder.append((char) ('0' + (b & 7)));
            }
            break;
        }
      }
      return builder.toString();
    }
    
    /**
     * <p>
     * Convert a <code>String</code> to an <code>int</code>, returning <code>zero</code> if the conversion fails.
     * </p>
     * 
     * <p>
     * If the string is <code>null</code>, <code>zero</code> is returned.
     * </p>
     * 
     * <pre>
     *   NumberUtils.toInt(null) = 0
     *   NumberUtils.toInt("")   = 0
     *   NumberUtils.toInt("1")  = 1
     * </pre>
     * 
     * @param str the string to convert, may be null
     * @return the int represented by the string, or <code>zero</code> if conversion fails
     * @since 2.1
     */
    public static int toInt(String str) {
        return toInt(str, 0);
    }

    /**
     * <p>
     * Convert a <code>String</code> to an <code>int</code>, returning a default value if the conversion fails.
     * </p>
     * 
     * <p>
     * If the string is <code>null</code>, the default value is returned.
     * </p>
     * 
     * <pre>
     *   NumberUtils.stringToInt(null, 1) = 1
     *   NumberUtils.stringToInt("", 1)   = 1
     *   NumberUtils.stringToInt("1", 0)  = 1
     * </pre>
     * 
     * @param str the string to convert, may be null
     * @param defaultValue the default value
     * @return the int represented by the string, or the default if conversion fails
     * @deprecated Use {@link #toInt(String, int)} This method will be removed in Commons Lang 3.0
     */
    public static int stringToInt(String str, int defaultValue) {
        return toInt(str, defaultValue);
    }

    /**
     * <p>
     * Convert a <code>String</code> to an <code>int</code>, returning a default value if the conversion fails.
     * </p>
     * 
     * <p>
     * If the string is <code>null</code>, the default value is returned.
     * </p>
     * 
     * <pre>
     *   NumberUtils.toInt(null, 1) = 1
     *   NumberUtils.toInt("", 1)   = 1
     *   NumberUtils.toInt("1", 0)  = 1
     * </pre>
     * 
     * @param str the string to convert, may be null
     * @param defaultValue the default value
     * @return the int represented by the string, or the default if conversion fails
     * @since 2.1
     */
    public static int toInt(String str, int defaultValue) {
        if (str == null) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return defaultValue;
        }
    }

    /**
     * <p>
     * Convert a <code>String</code> to an <code>long</code>, returning a default value if the conversion fails.
     * </p>
     * 
     * <p>
     * If the string is <code>null</code>, the default value is returned.
     * </p>
     * 
     * <pre>
     *   NumberUtils.toLong(null) = 0
     *   NumberUtils.toLong("")   = 0
     *   NumberUtils.toLong("1")  = 1
     * </pre>
     * 
     * @param str the string to convert, may be null
     * @return the long represented by the string, or the default if conversion fails
     * @since 2.1
     */
    public static long toLong(String str) {
        return toLong(str, 0);
    }

    /**
     * <p>
     * Convert a <code>String</code> to an <code>long</code>, returning a default value if the conversion fails.
     * </p>
     * 
     * <p>
     * If the string is <code>null</code>, the default value is returned.
     * </p>
     * 
     * <pre>
     *   NumberUtils.toLong(null, 1) = 1
     *   NumberUtils.toLong("", 1)   = 1
     *   NumberUtils.toLong("1", 0)  = 1
     * </pre>
     * 
     * @param str the string to convert, may be null
     * @param defaultValue the default value
     * @return the long represented by the string, or the default if conversion fails
     * @since 2.1
     */
    public static long toLong(String str, long defaultValue) {
        if (str == null) {
            return defaultValue;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException nfe) {
            return defaultValue;
        }
    }
    
    /**
     * <p>Removes control characters (char &lt;= 32) from both
     * ends of this String returning an empty String ("") if the String
     * is empty ("") after the trim or if it is <code>null</code>.
     *
     * <p>The String is trimmed using {@link String#trim()}.
     * Trim removes start and end characters &lt;= 32.
     * To strip whitespace use {@link #stripToEmpty(String)}.</p>
     *
     * <pre>
     * StringUtils.trimToEmpty(null)          = ""
     * StringUtils.trimToEmpty("")            = ""
     * StringUtils.trimToEmpty("     ")       = ""
     * StringUtils.trimToEmpty("abc")         = "abc"
     * StringUtils.trimToEmpty("    abc    ") = "abc"
     * </pre>
     *
     * @param str  the String to be trimmed, may be null
     * @return the trimmed String, or an empty String if <code>null</code> input
     * @since 2.0
     */
    public static String trimToEmpty(String str) {
        return str == null ? EMPTY : str.trim();
    }
    
    /**
     * <p>Uncapitalizes a String, changing the first character to lower case as
     * per {@link Character#toLowerCase(int)}. No other characters are changed.</p>
     *
     * <p>For a word based algorithm, see {@link org.apache.commons.lang3.text.WordUtils#uncapitalize(String)}.
     * A {@code null} input String returns {@code null}.</p>
     *
     * <pre>
     * StringUtils.uncapitalize(null)  = null
     * StringUtils.uncapitalize("")    = ""
     * StringUtils.uncapitalize("cat") = "cat"
     * StringUtils.uncapitalize("Cat") = "cat"
     * StringUtils.uncapitalize("CAT") = "cAT"
     * </pre>
     *
     * @param str the String to uncapitalize, may be null
     * @return the uncapitalized String, {@code null} if null String input
     * @see org.apache.commons.lang3.text.WordUtils#uncapitalize(String)
     * @see #capitalize(String)
     * @since 2.0
     */
    public static String uncapitalize(final String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return str;
        }

        final int firstCodepoint = str.codePointAt(0);
        final int newCodePoint = Character.toLowerCase(firstCodepoint);
        if (firstCodepoint == newCodePoint) {
            // already capitalized
            return str;
        }

        final int newCodePoints[] = new int[strLen]; // cannot be longer than the char array
        int outOffset = 0;
        newCodePoints[outOffset++] = newCodePoint; // copy the first codepoint
        for (int inOffset = Character.charCount(firstCodepoint); inOffset < strLen; ) {
            final int codepoint = str.codePointAt(inOffset);
            newCodePoints[outOffset++] = codepoint; // copy the remaining ones
            inOffset += Character.charCount(codepoint);
         }
        return new String(newCodePoints, 0, outOffset);
    }

    /**
     * To lower case.
     *
     * @param str the str
     * @return the string
     */
    public static String toLowerCase(final String str) {
        if (isEmpty(str)) {
            return str;
        }
        
        return str.toLowerCase();
    }
    
    /**
     * <p>Checks if an array of Objects is empty or <code>null</code>.</p>
     *
     * @param array  the array to test
     * @return <code>true</code> if the array is empty or <code>null</code>
     * @since 2.1
     */
    public static boolean isEmpty(Object[] array) {
        return array == null || array.length == 0;
    }
}
