package com.iAxis.secure_chat.utils;

/**
 * @author aditya.chakma
 * @since 20 Jan, 2025
 */
public final class EntityUtils {

    public static <T extends Number> boolean isValidIdentifier(T id) {
        return id != null && id.longValue() != 0L;
    }

}
