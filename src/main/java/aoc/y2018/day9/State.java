package aoc.y2018.day9;

import java.util.HashSet;

public class State {
    private long[] scores;
    private Node[] marbles;
    private int curMarble;
    private int nextMarble;
    private int curPlayer;

    public State(int numPlayers, int lastMarble) {
        this.scores = new long[numPlayers];
        this.marbles = new Node[lastMarble + 1];

        for (var ndx = 0; ndx < numPlayers; ndx += 1) {
            this.scores[ndx] = 0;
        }

        for (var ndx = 0; ndx <= lastMarble; ndx += 1) {
            this.marbles[ndx] = new Node();
        }

        this.marbles[0].prev = 0;
        this.marbles[0].next = 0;

        this.curPlayer = 0;
        this.curMarble = 0;
        this.nextMarble = 1;
    }

    public long[] getScores() {
        return scores;
    }

    public long highScore() {
        var high = 0L;

        for (var score : scores) {
            if (score > high) {
                high = score;
            }
        }

        return high;
    }

    public void placeNext() {
        if ((nextMarble % 23) == 0) {
            updateScore();
        } else {
            insertMarble();
        }

        curPlayer = (curPlayer + 1) % scores.length;
        nextMarble += 1;
    }

    private void updateScore() {
        var marble = curMarble;

        for (var count = 0; count < 7; count += 1) {
            marble = marbles[marble].prev;
        }

        curMarble = marbles[marble].next;
        removeMarble(marble);

        scores[curPlayer] += nextMarble + marble;
    }

    private void removeMarble(int marble) {
        var prev = marbles[marble].prev;
        var next = marbles[marble].next;

        marbles[prev].next = next;
        marbles[next].prev = prev;
    }

    private void insertMarble() {
        var first = marbles[curMarble].next;
        var second = marbles[first].next;

        marbles[first].next = nextMarble;
        marbles[second].prev = nextMarble;

        marbles[nextMarble].prev = first;
        marbles[nextMarble].next = second;

        curMarble = nextMarble;
    }

    public String toString() {
        var sb = new StringBuilder();
        var marble = 0;
        var seen = new HashSet<Integer>();

        while (!seen.contains(marble)) {
            sb.append(" ");

            if (marble == curMarble) {
                sb.append("(").append(marble).append(")");
            } else {
                sb.append(marble);
            }

            seen.add(marble);

            marble = this.marbles[marble].next;
        }

        return sb.toString();
    }
}
