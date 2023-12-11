package pairmatching.service;

import pairmatching.constants.FileConstants;
import pairmatching.constants.MatchConstants;
import pairmatching.model.Crews;
import pairmatching.utils.CrewFileReader;

import java.util.ArrayList;
import java.util.List;

public class MatchService {
    CrewFileReader crewFileReader = new CrewFileReader();

    public boolean proceedFeature(String featureChoice) {
        if (featureChoice.equals(MatchConstants.EXIT_FEATURE_STRING)) {
            return false;
        }
        return true;
    }

    public List<Crews> readCrewFiles() {
        List<Crews> allCrews = new ArrayList<>();
        for (FileConstants file : FileConstants.values()) {
            allCrews.add(crewFileReader.readCrewFile(file));
        }
        return allCrews;
    }
}
