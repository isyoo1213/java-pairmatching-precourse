package pairmatching.utils;

import pairmatching.constants.Courses;
import pairmatching.constants.ExceptionMessages;
import pairmatching.constants.Level;
import pairmatching.constants.MatchConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputValidator {
    private static final String SPACING_STRING = " ";
    private static final String EMPTY_STRING = "";
    private static final String MISSION_SEPARATOR = ",";

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

    public List<String> convertToMissionChoice(String preprocessedInput) {
        if (!preprocessedInput.contains(MISSION_SEPARATOR)) {
            ExceptionMessages.WRONG_MISSION_FORMAT.throwException();
        }
        List<String> missionChoice = Stream.of(preprocessedInput.split(MISSION_SEPARATOR))
                .collect(Collectors.toList());
        if (missionChoice.size() != 3) {
            ExceptionMessages.WRONG_MISSION_FORMAT.throwException();
        }
        isWrongCourse(missionChoice.get(0));
        isWrongLevelOrMission(missionChoice.get(1), missionChoice.get(2));
        return missionChoice;
    }

    private void isWrongCourse(String courseName) {
        List<String> courseNames = new ArrayList<>();
        for (Courses course : Courses.values()) {
            courseNames.add(course.getCourseName());
        }
        if (!courseNames.contains(courseName)) {
            ExceptionMessages.WRONG_COURSE_INPUT.throwException();
        }
    }

    private void isWrongLevelOrMission(String levelNumber, String missionName) {
        if (!Level.LEVEL_WITH_NUMBERS.contains(levelNumber)) {
            ExceptionMessages.WRONG_LEVEL_INPUT.throwException();
        }
        isWrongMission(levelNumber, missionName);
    }

    private void isWrongMission(String levelNumber, String missionName) {
        List<String> missions = Level.LEVEL_BY_NUMBER.get(levelNumber).getMissions();
        if (!missions.contains(missionName)) {
            ExceptionMessages.WRONG_MISSION_INPUT.throwException();
        }
    }

    private boolean isWrongFeatureChoice(String preprocessedInput) {
        return !MatchConstants.FEATURE_LIST.contains(preprocessedInput);
    }
}
