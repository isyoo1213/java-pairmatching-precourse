package pairmatching.constants;

import java.util.List;

public enum Level {

    LEVE_1(1, List.of("자동차 경주", "로또", "숫자야구게임")),
    LEVE_2(2, List.of("장바구니", "결제", "지하철노선도")),
    LEVE_3(3, List.of()),
    LEVE_4(4, List.of("성능개선", "배포")),
    LEVE_5(5, List.of());

    private final int levelNumber;
    private final List<String> missions;

    Level(int levelNumber, List<String> missions) {
        this.levelNumber = levelNumber;
        this.missions = missions;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public List<String> getMissions() {
        return missions;
    }
}
