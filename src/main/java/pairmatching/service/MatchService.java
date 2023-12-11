package pairmatching.service;

import pairmatching.constants.MatchConstants;
import pairmatching.utils.CrewFileReader;


public class MatchService {
    CrewFileReader crewFileReader = new CrewFileReader();

    public boolean proceedFeature(String featureChoice) {
        if (featureChoice.equals(MatchConstants.EXIT_FEATURE_STRING)) {
            return false;
        }
        return true;
    }
}
