package pairmatching.model;

import java.util.ArrayList;
import java.util.List;

public class Pair {
    private final List<Crew> crewPair;

    public Pair(List<Crew> crews) {
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
        int sameCrewCount = 0;
        for (String crewPairName : crewPairNames) {
            for (String subjectPairName : subjectPairNames) {
                sameCrewCount += isSameNames(crewPairName, subjectPairName);
            }
        }
        return sameCrewCount >= 2;
    }

    private int isSameNames(String crewPairName, String subjectPairName) {
        if (crewPairName.equals(subjectPairName)) {
            return 1;
        }
        return 0;
    }
}
