package y2020.day22;

import java.util.Deque;
import java.util.LinkedList;

import utils.Problem;

public abstract class Solver extends Problem<Long> {
    protected Player[] input;

    protected Solver(Player[] input, long expected) {
        super(expected);
        this.input = input;
    }

    protected Deque<Integer> copyCards(Deque<Integer> cards) {
        return copyCards(cards, cards.size());
    }

    protected Deque<Integer> copyCards(Deque<Integer> cards, int count) {
        var copy = new LinkedList<Integer>();
        var iter = cards.iterator();

        for (var n = 0; n < count; n += 1) {
            copy.add(iter.next());
        }

        return copy;
    }

    protected long calculateAnswer(Deque<Integer> cards) {
        var mult = cards.size();
        var answer = 0L;

        for (var card : cards) {
            answer += card * mult;
            mult -= 1;
        }

        return answer;
    }
}
