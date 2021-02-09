package com.epam.task.third.creators;

import java.util.List;
import java.util.regex.Pattern;

public abstract class Validator {

    final static String DIGIT_PATTERN = "^[0-9 ]+$";

    public boolean isOnlyDigits(String line) {
        return Pattern.matches(DIGIT_PATTERN, line);
    }
    abstract boolean isValid(List<Integer> data);
}
