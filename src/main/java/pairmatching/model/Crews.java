package pairmatching.model;

import pairmatching.constants.Courses;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Crews {

    Map<Courses, List<Crew>> crewsInfo;

    public Crews(Courses course, List<Crew> crews) {
        Map<Courses, List<Crew>> tempMap = new LinkedHashMap<>();
        tempMap.put(course, crews);
        crewsInfo = Map.copyOf(tempMap);
    }

    public Map<String, List<String>> provideCrewsInfo() {
        Map<String, List<String>> tempMap = new LinkedHashMap<>();
        for (Map.Entry<Courses, List<Crew>> crewInfo : crewsInfo.entrySet()) {
            String courseName = crewInfo.getKey().getCourseName();
            List<String> crewNames = new ArrayList<>();
            for (Crew crew : crewInfo.getValue()) {
                String crewName = crew.provideCrewName();
                crewNames.add(crewName);
            }
            tempMap.put(courseName, crewNames);
        }
        return Map.copyOf(tempMap);
    }

    public Crew provideCrewByName(Courses course, String crewName) {
        List<Crew> crewsByCourse = crewsInfo.get(course);
        return crewsByCourse.stream()
                .filter((crew) -> crew.provideCrewName().equals(crewName))
                .findFirst()
                .orElseThrow();
    }
}
