package pairmatching.utils;

import pairmatching.constants.ExceptionMessages;
import pairmatching.constants.MatchConstants;

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

    public String convertToFeatureChoice(String preprocessedInput) {
        if (isWrongFeatureChoice(preprocessedInput)) {
            ExceptionMessages.WRONG_FEATURE_INPUT.throwException();
        }
        return preprocessedInput;
    }

    private boolean isWrongFeatureChoice(String preprocessedInput) {
        return !MatchConstants.FEATURE_LIST.contains(preprocessedInput);
    }
}
