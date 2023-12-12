package pairmatching.model;

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
}
