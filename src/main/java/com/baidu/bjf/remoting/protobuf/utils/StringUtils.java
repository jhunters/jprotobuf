/**
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 *
 */
package com.baidu.bjf.remoting.protobuf.utils;

/**
 * String utility class.
 * 
 * @author xiemalin
 * @since 1.2.5
 */
public class StringUtils {
    
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

}
