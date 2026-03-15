package aoc.y2020.day22;

import java.util.Deque;
import java.util.List;

public class Part1 extends Solver {
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

    @Override
    public Integer solve(List<String> lines) {
        var input = new Parser().parse(lines);
        var cards1 = copyCards(input.get(0).getCards());
        var cards2 = copyCards(input.get(1).getCards());
        Deque<Integer> winner;

        while (true) {
            playRound(cards1, cards2);

            if (cards1.isEmpty() || cards2.isEmpty()) {
                winner = cards1.isEmpty() ? cards2 : cards1;
                break;
            }
        }

        return calculateAnswer(winner);
    }
}
