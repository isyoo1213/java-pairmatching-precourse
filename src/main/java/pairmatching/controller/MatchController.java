package pairmatching.controller;

import pairmatching.utils.InputValidator;
import pairmatching.view.InputView;

public class MatchController {
    InputView inputView = new InputView();
    InputValidator inputValidator = new InputValidator();

    public void processMatch() {
        String featureChoice = getFeatureChoice();
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
}
