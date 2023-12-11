package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.constants.Courses;
import pairmatching.constants.Level;

import java.util.List;

public class InputView {
    private static final String DIVIDE_LINE = "#############################################";
    private static final String CHOICE_INFO = "과정, 레벨, 미션을 선택하세요.";
    private static final String CHOICE_EXAMPLE = "ex) 백엔드, 레벨1, 자동차경주";
    private static final String COURSE_STRING = "과정: %s\n";
    private static final String MISSION_STRING = "미션:";
    private static final String LEVEL_STRING = "  - 레벨%s: %s\n";
    private static final String COURSE_DELIMITER = " | ";
    private static final String MISSION_DELIMITER = " | ";

    public String askFeatures() {
        System.out.println("기능을 선택하세요.");
        System.out.println("1. 페어 매칭");
        System.out.println("2. 페어 조회");
        System.out.println("3. 페어 초기화");
        System.out.println("Q. 종료");

        return Console.readLine();
    }

    public String askMissionInfo() {
        System.out.println(System.lineSeparator() + DIVIDE_LINE);
        printCourses();
        printMissions();
        System.out.println(DIVIDE_LINE);
        System.out.println(CHOICE_INFO);
        System.out.println(CHOICE_EXAMPLE);
        return Console.readLine();
    }

    private void printMissions() {
        System.out.println(MISSION_STRING);
        printLevels();

    }

    private void printLevels() {
        for (Level level : Level.values()) {
            System.out.printf(LEVEL_STRING, level.getLevelNumber(), String.join(MISSION_DELIMITER, level.getMissions()));
        }
    }

    private void printCourses() {
        System.out.printf(COURSE_STRING, String.join(COURSE_DELIMITER, List.of(Courses.BACKEND.getCourseName(), Courses.FRONTEND.getCourseName())));
    }
}
