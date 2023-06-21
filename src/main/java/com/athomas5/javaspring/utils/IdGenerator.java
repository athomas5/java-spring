package com.athomas5.javaspring.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class IdGenerator {
    // private static final Integer NUMBER_OF_CHARS_FOR_VERSION_IDS = 5;
    private static final Integer NUMBER_OF_DIGITS_FOR_IDS = 12;

    public static Long generateId() {
        return Long.valueOf(RandomStringUtils.randomNumeric(NUMBER_OF_DIGITS_FOR_IDS));
    }
}