package pairmatching.model;

import java.util.ArrayList;
import java.util.List;

public class Pairs {
    private final List<Pair> pairs;

    public Pairs(List<Pair> pairs) {
        this.pairs = List.copyOf(pairs);
    }

    public boolean hasSamePair(Pairs subPairs) {
        boolean hasSamePair = false;
        for (int i = 0; i < pairs.size(); i++) {
            if (pairs.get(i).hasTwoMoreSameNames(subPairs.pairs.get(i))) {
              hasSamePair = true;
            }
        }
        return hasSamePair;
    }

    public List<String> providePairsNames() {
        List<String> convertedPairsNames = new ArrayList<>();
        for (Pair pair : pairs) {
            List<String> pairNames = pair.providePairNames();
            String convertedPairNames = "";
            for (int i = 0; i < pairNames.size(); i++) {
                if (i != 0) {
                    convertedPairNames += " : ";
                }
                convertedPairNames += pairNames.get(i);
            }
            convertedPairsNames.add(convertedPairNames);
        }
        return convertedPairsNames;
    }
}
