package com.iAxis.secure_chat.utils;

/**
 * @author aditya.chakma
 * @since 19 Jan, 2025
 */
public final class StringUtils {

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

}
