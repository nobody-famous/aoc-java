package aoc.y2020.day22;

import java.util.Deque;
import java.util.LinkedList;

import aoc.y2020.Y2020Problem;

public abstract class Solver extends Y2020Problem<Long> {
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
        var iterator = cards.iterator();

        for (var n = 0; n < count; n += 1) {
            copy.add(iterator.next());
        }

        return copy;
    }

    protected long calculateAnswer(Deque<Integer> cards) {
        var multiplier = cards.size();
        var answer = 0L;

        for (var card : cards) {
            answer += (long) card * multiplier;
            multiplier -= 1;
        }

        return answer;
    }
}
