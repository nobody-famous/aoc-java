package y2020.day23;

import utils.Problem;

public class Part1 implements Problem {
    private int[] input;

    public Part1(int[] input) {
        this.input = input;
    }

    private void printBoard(Node[] board) {
        for (var ndx = 0; ndx < board.length; ndx += 1) {
            var node = board[ndx];

            if (node == null) {
                continue;
            }

            System.out.println(ndx + " -> " + node.getNext());
        }
    }

    private Node[] buildBoard() {
        var board = new Node[input.length + 1];

        for (var ndx = 0; ndx < input.length - 1; ndx += 1) {
            var cur = input[ndx];
            var next = input[ndx + 1];

            board[cur] = new Node(next);
        }

        var cur = input[input.length - 1];
        var next = input[0];

        board[cur] = new Node(next);

        return board;
    }

    public long solve() {
        var board = buildBoard();
        var current = input[0];

        System.out.println(current);
        printBoard(board);

        return 0L;
    }
}
