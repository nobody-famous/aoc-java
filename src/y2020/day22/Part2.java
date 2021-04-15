package y2020.day22;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Part2 extends Solver {
    public Part2(Player[] input) {
        super(input);
    }

    private boolean alreadyPlayed(List<HistoryItem> history, Deque<Integer> cards1) {
        for (var item : history) {
            if (item.equals(cards1)) {
                return true;
            }
        }

        return false;
    }

    private void updateHistory(List<HistoryItem> history, Deque<Integer> cards1) {
        history.add(new HistoryItem(copyCards(cards1)));
    }

    private Deque<Integer> playRound(Deque<Integer> cards1, Deque<Integer> cards2) {
        var card1 = cards1.removeFirst();
        var card2 = cards2.removeFirst();
        Deque<Integer> winner = null;

        if (card1 <= cards1.size() && card2 <= cards2.size()) {
            var sub1 = copyCards(cards1, card1);
            var sub2 = copyCards(cards2, card2);

            winner = play(sub1, sub2);
            if (winner == sub1) {
                cards1.add(card1);
                cards1.add(card2);
            } else {
                cards2.add(card2);
                cards2.add(card1);
            }
        } else if (card1 > card2) {
            winner = cards1;
            cards1.add(card1);
            cards1.add(card2);
        } else {
            winner = cards2;
            cards2.add(card2);
            cards2.add(card1);
        }

        return winner;
    }

    private Deque<Integer> play(Deque<Integer> cards1, Deque<Integer> cards2) {
        var history = new ArrayList<HistoryItem>();

        while (true) {
            if (alreadyPlayed(history, cards1)) {
                return cards1;
            }

            if (cards1.size() == 0) {
                return cards2;
            }

            if (cards2.size() == 0) {
                return cards1;
            }

            updateHistory(history, cards1);
            playRound(cards1, cards2);
        }
    }

    public long solve() {
        var cards1 = input[0].getCards();
        var cards2 = input[1].getCards();

        var winner = play(cards1, cards2);
        var answer = calculateAnswer(winner);

        return answer;
    }
}
