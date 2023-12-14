package pairmatching.constants;

public enum ExceptionMessages {
    NULL_INPUT("null은 입력할 수 없습니다."),
    EMPTY_INPUT("값을 입력해주세요."),
    WRONG_FEATURE_INPUT("1~3, Q를 입력해주세요."),
    WRONG_FILE_FORMAT("파일을 읽을 수 없습니다."),
    WRONG_COURSE_INPUT("존재하지 않는 코스입니다."),
    WRONG_LEVEL_INPUT("존재하지 않는 레벨입니다."),
    WRONG_MISSION_INPUT("레벨에 포함되지 않는 미션입니다."),
    WRONG_REMATCHING_INPUT("네/아니오를 입력해주세요."),
    WRONG_MISSION_FORMAT("쉼표 구분자(,)를 이용해 코스, 레벨, 미션을 입력해주세요.");

    private final String exceptionMessage;
    private final String ERROR_TAG = "[ERROR] ";

    ExceptionMessages(String errorMessage) {
        this.exceptionMessage = ERROR_TAG + errorMessage;
    }

    public void throwException() {
        throw new IllegalArgumentException(exceptionMessage);
    }
}
