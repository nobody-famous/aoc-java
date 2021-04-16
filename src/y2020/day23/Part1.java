package y2020.day23;

import java.util.ArrayList;

import utils.Problem;

public class Part1 implements Problem {
    private int[] input;
    private Node[] board;
    private int current;

    public Part1(int[] input) {
        this.input = input;
    }

    private void printBoard() {
        System.out.print(1);

        var next = board[1].getNext();
        while (next != 1) {
            if (next == current) {
                System.out.print(" (" + next + ")");
            } else {
                System.out.print(" " + next);
            }

            next = board[next].getNext();
        }

        System.out.println();
    }

    private void printAnswer() {
        var next = board[1].getNext();

        while (next != 1) {
            System.out.print(next);
            next = board[next].getNext();
        }

        System.out.println();
    }

    private void buildBoard() {
        board = new Node[input.length + 1];

        for (var ndx = 0; ndx < input.length - 1; ndx += 1) {
            var cur = input[ndx];
            var next = input[ndx + 1];

            board[cur] = new Node(next);
        }

        var cur = input[input.length - 1];
        var next = input[0];

        board[cur] = new Node(next);
    }

    private void pickCups() {
        var cups = new ArrayList<Integer>();
        var cup = current;

        for (var count = 0; count < 3; count += 1) {
            cup = board[cup].getNext();
            cups.add(cup);
        }

        var last = cups.get(2);
        board[current].setNext(board[last].getNext());

        var dest = current - 1;
        if (dest < 1) {
            dest = 9;
        }

        while (cups.contains(dest)) {
            dest -= 1;
            if (dest < 1) {
                dest = 9;
            }
        }

        var tmp = board[dest].getNext();
        board[dest].setNext(cups.get(0));
        board[cups.get(2)].setNext(tmp);

        current = board[current].getNext();
    }

    public long solve() {
        buildBoard();
        current = input[0];

        for (var loop = 0; loop < 100; loop += 1) {
            pickCups();
        }

        printAnswer();

        return 0L;
    }
}
