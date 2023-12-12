package pairmatching.constants;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Level {

    LEVEL_1(1, List.of("자동차 경주", "로또", "숫자야구게임")),
    LEVEL_2(2, List.of("장바구니", "결제", "지하철노선도")),
    LEVEL_3(3, List.of()),
    LEVEL_4(4, List.of("성능개선", "배포")),
    LEVEL_5(5, List.of());

    public static final String LEVEL_STRING = "레벨";
    public static final List<String> LEVEL_WITH_NUMBERS =
            Arrays.stream(Level.values())
                    .map((level) -> LEVEL_STRING + level.getLevelNumber())
                    .collect(Collectors.toList());
    public static final Map<String, Level> LEVEL_BY_NUMBER =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(Level::getLevelWithNumber, Function.identity())));

    private final int levelNumber;
    private final List<String> missions;

    Level(int levelNumber, List<String> missions) {
        this.levelNumber = levelNumber;
        this.missions = missions;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public String getLevelWithNumber() {
        return LEVEL_STRING + levelNumber;
    }

    public List<String> getMissions() {
        return missions;
    }
}
