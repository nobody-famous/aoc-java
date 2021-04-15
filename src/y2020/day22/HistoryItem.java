package y2020.day22;

import java.util.Deque;

public class HistoryItem {
    private Deque<Integer> cards;

    public HistoryItem(Deque<Integer> cards) {
        this.cards = cards;
    }

    private boolean dequesEqual(Deque<Integer> us, Deque<Integer> them) {
        if (us.size() != them.size()) {
            return false;
        }

        var themIter = them.iterator();
        for (var card : us) {
            var themCard = themIter.next();

            if (card != themCard) {
                return false;
            }
        }

        return true;
    }

    public boolean equals(Deque<Integer> them) {
        return dequesEqual(cards, them);
    }

    public String toString() {
        return cards.toString();
    }
}
