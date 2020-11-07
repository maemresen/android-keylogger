package com.maemresen.infsec.keylogapp.util;

/**
 * @author Emre Sen, 14.05.2019
 * @contact maemresen07@gmail.com
 */
public class LogHelper {


    private final static String LOG_TAG_PREFIX = "Keylogapp";

    public static String getLogTag(Class<?> clazz) {
        return String.format("%s-%s", LOG_TAG_PREFIX, clazz.getSimpleName());
    }
}
