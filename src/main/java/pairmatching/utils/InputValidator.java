package pairmatching.utils;

import pairmatching.constants.ExceptionMessages;

public class InputValidator {
    private static final String SPACING_STRING = " ";
    private static final String EMPTY_STRING = "";

    public String preprocessInput(String userInput) {
        if (userInput == null) {
            ExceptionMessages.NULL_INPUT.throwException();
        }
        userInput.replaceAll(SPACING_STRING, EMPTY_STRING);
        if (userInput.isEmpty()) {
            ExceptionMessages.EMPTY_INPUT.throwException();
        }
        return userInput;
    }
}
