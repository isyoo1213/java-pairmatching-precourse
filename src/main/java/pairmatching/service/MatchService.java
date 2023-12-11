package pairmatching.service;

import pairmatching.constants.FileConstants;
import pairmatching.model.Crews;
import pairmatching.utils.CrewFileReader;

import java.util.ArrayList;
import java.util.List;

public class MatchService {
    CrewFileReader crewFileReader = new CrewFileReader();

    public List<Crews> readCrewFiles() {
        List<Crews> allCrews = new ArrayList<>();
        for (FileConstants file : FileConstants.values()) {
            allCrews.add(crewFileReader.readCrewFile(file));
        }
        return allCrews;
    }
}
