package pairmatching.controller;

import pairmatching.constants.MatchConstants;
import pairmatching.model.Crews;
import pairmatching.service.MatchService;
import pairmatching.utils.InputValidator;
import pairmatching.view.InputView;

import java.util.List;

public class MatchController {
    InputView inputView = new InputView();
    InputValidator inputValidator = new InputValidator();
    MatchService matchService = new MatchService();

    public void processMatch() {
        List<Crews> allCrews = matchService.readCrewFiles();
        boolean progressState = true;
        while (progressState) {
            String featureChoice = getFeatureChoice();
            progressState = proceedFeature(featureChoice);
        }
    }

    private String getFeatureChoice() {
        try {
            String featureChoice = inputView.askFeatures();
            String preprocessedFeatureChoice = inputValidator.preprocessInput(featureChoice);
            return inputValidator.convertToFeatureChoice(preprocessedFeatureChoice);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getFeatureChoice();
        }
    }

    private boolean proceedFeature(String featureChoice) {
        if (featureChoice.equals(MatchConstants.EXIT_FEATURE_STRING)) {
            return false;
        }
        return true;
    }
}
