package y2020.day22;

import java.util.Deque;

public class Part1 extends Solver {
    public Part1(Player[] input) {
        super(input);
    }

    private void playRound(Deque<Integer> cards1, Deque<Integer> cards2) {
        var card1 = cards1.removeFirst();
        var card2 = cards2.removeFirst();

        if (card1 > card2) {
            cards1.add(card1);
            cards1.add(card2);
        } else {
            cards2.add(card2);
            cards2.add(card1);
        }
    }

    public long solve() {
        var cards1 = copyCards(input[0].getCards());
        var cards2 = copyCards(input[1].getCards());
        Deque<Integer> winner;

        while (true) {
            playRound(cards1, cards2);

            if (cards1.size() == 0 || cards2.size() == 0) {
                winner = cards1.size() == 0 ? cards2 : cards1;
                break;
            }
        }

        var answer = calculateAnswer(winner);

        return answer;
    }
}
