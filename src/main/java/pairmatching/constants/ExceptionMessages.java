package pairmatching.constants;

public enum ExceptionMessages {
    NULL_INPUT("null은 입력할 수 없습니다."),
    EMPTY_INPUT("값을 입력해주세요."),
    WRONG_FEATURE_INPUT("1~3, Q를 입력해주세요."),
    WRONG_FILE_FORMAT("파일을 읽을 수 없습니다.");

    private final String exceptionMessage;
    private final String ERROR_TAG = "[ERROR] ";

    ExceptionMessages(String errorMessage) {
        this.exceptionMessage = ERROR_TAG + errorMessage;
    }

    public void throwException() {
        throw new IllegalArgumentException(exceptionMessage);
    }
}
