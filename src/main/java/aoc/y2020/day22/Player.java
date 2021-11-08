package aoc.y2020.day22;

import java.util.Deque;
import java.util.LinkedList;

public class Player {
    private int id;
    private Deque<Integer> cards;

    public Player(int id, int[] cardsList) {
        this.id = id;
        this.cards = new LinkedList<Integer>();

        for (var card : cardsList) {
            this.cards.add(card);
        }
    }

    public Deque<Integer> getCards() {
        return cards;
    }

    public String toString() {
        var builder = new StringBuilder();

        builder.append(id);
        builder.append(":");

        for (var card : cards) {
            builder.append(" " + card);
        }

        return builder.toString();
    }
}
