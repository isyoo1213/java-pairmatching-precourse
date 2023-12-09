package pairmatching.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Crew {
    private final Map<String, String> crew;

    Crew(String crewName, String courseName) {
        Map<String, String> tempMap = new LinkedHashMap<>();
        tempMap.put("crewName", crewName);
        tempMap.put("courseName", courseName);
        crew = Map.copyOf(tempMap);
    }

    public String provideCrewName() {
        return crew.get("crewName");
    }
}
