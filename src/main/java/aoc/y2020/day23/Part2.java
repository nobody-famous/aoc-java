package aoc.y2020.day23;

import java.util.List;

public class Part2 extends Solver {
    public Part2() {
        super(1000000);
    }

    private void buildBoard(int[] input) {
        board = new int[1000001];

        for (var ndx = 0; ndx < input.length - 1; ndx += 1) {
            var cur = input[ndx];
            var next = input[ndx + 1];

            board[cur] = next;
        }

        var cur = input[input.length - 1];
        var next = 10;

        while (next < board.length) {
            board[cur] = next;
            cur = next;
            next += 1;
        }

        board[cur] = input[0];
    }

    @Override
    public Long solve(List<String> lines) {
        var input = lines.get(0).chars().map(c -> c - '0').toArray();

        buildBoard(input);

        current = input[0];

        for (var loop = 0; loop < 10000000; loop += 1) {
            pickCups();
        }

        var first = board[1];
        var second = board[first];

        return (long) first * (long) second;
    }
}
