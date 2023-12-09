package pairmatching.model;

import java.util.ArrayList;
import java.util.List;

public class Pair {
    private final List<Crew> crewPair;

    private Pair(List<Crew> crews) {
        List<Crew> tempList = new ArrayList<>(crews);
        crewPair = List.copyOf(tempList);
    }

    public List<String> providePairNames() {
        List<String> pairNames = new ArrayList<>();
        for (Crew crew : crewPair) {
            String crewName = crew.provideCrewName();
            pairNames.add(crewName);
        }
        return List.copyOf(pairNames);
    }

    public boolean hasTwoMoreSameNames(Pair subjectPair) {
        List<String> crewPairNames = this.providePairNames();
        List<String> subjectPairNames = subjectPair.providePairNames();
        return crewPairNames.containsAll(subjectPairNames) || subjectPairNames.containsAll(crewPairNames);
    }
}
