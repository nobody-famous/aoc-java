package aoc.y2020.day22;

import java.util.*;

public class Part2 extends Solver {
    public Part2(Player[] input, long expected) {
        super(input, expected);
    }

    private boolean dequesEqual(Deque<Integer> us, Deque<Integer> them) {
        if (us.size() != them.size()) {
            return false;
        }

        var themIterator = them.iterator();
        for (var card : us) {
            var themCard = themIterator.next();

            if (!Objects.equals(card, themCard)) {
                return false;
            }
        }

        return true;
    }

    private boolean alreadyPlayed(Map<Long, List<Deque<Integer>>> history, Deque<Integer> cards) {
        var hash = hashCards(cards);

        if (!history.containsKey(hash)) {
            return false;
        }

        var items = history.get(hash);
        for (var item : items) {
            if (dequesEqual(item, cards)) {
                return true;
            }
        }

        return false;
    }

    private long hashCards(Deque<Integer> cards) {
        if (cards.isEmpty()) {
            return 0;
        }

        var hash = 1L;
        for (var card : cards) {
            hash *= card;
        }

        return hash;
    }

    private void updateHistory(Map<Long, List<Deque<Integer>>> history, Deque<Integer> cards) {
        var hash = hashCards(cards);

        if (!history.containsKey(hash)) {
            history.put(hash, new ArrayList<>());
        }

        var list = history.get(hash);

        list.add(copyCards(cards));
    }

    private void playRound(Deque<Integer> cards1, Deque<Integer> cards2) {
        var card1 = cards1.removeFirst();
        var card2 = cards2.removeFirst();

        if (card1 <= cards1.size() && card2 <= cards2.size()) {
            var sub1 = copyCards(cards1, card1);
            var sub2 = copyCards(cards2, card2);

            var winner = play(sub1, sub2);
            if (winner == sub1) {
                cards1.add(card1);
                cards1.add(card2);
            } else {
                cards2.add(card2);
                cards2.add(card1);
            }
        } else if (card1 > card2) {
            cards1.add(card1);
            cards1.add(card2);
        } else {
            cards2.add(card2);
            cards2.add(card1);
        }

    }

    private Deque<Integer> play(Deque<Integer> cards1, Deque<Integer> cards2) {
        var history = new HashMap<Long, List<Deque<Integer>>>();

        while (true) {
            if (alreadyPlayed(history, cards1)) {
                return cards1;
            }

            if (cards1.isEmpty()) {
                return cards2;
            }

            if (cards2.isEmpty()) {
                return cards1;
            }

            updateHistory(history, cards1);
            playRound(cards1, cards2);
        }
    }

    public Long run() {
        var cards1 = input[0].getCards();
        var cards2 = input[1].getCards();

        var winner = play(cards1, cards2);

        return calculateAnswer(winner);
    }
}
