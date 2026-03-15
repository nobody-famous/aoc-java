package aoc.y2020.day22;

import java.util.Deque;
import java.util.LinkedList;

import aoc.utils.AocProblem;

public abstract class Solver implements AocProblem<Integer> {
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

    protected int calculateAnswer(Deque<Integer> cards) {
        var multiplier = cards.size();
        var answer = 0;

        for (var card : cards) {
            answer += card * multiplier;
            multiplier -= 1;
        }

        return answer;
    }
}
