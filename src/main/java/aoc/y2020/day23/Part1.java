package aoc.y2020.day23;

import java.util.List;

public class Part1 extends Solver {
    public Part1() {
        super(9);
    }

    private String getAnswer() {
        var builder = new StringBuilder();
        var next = board[1];

        while (next != 1) {
            builder.append(next);
            next = board[next];
        }

        return builder.toString();
    }

    protected void buildBoard(int[] input) {
        board = new int[input.length + 1];

        for (var ndx = 0; ndx < input.length - 1; ndx += 1) {
            var cur = input[ndx];
            var next = input[ndx + 1];

            board[cur] = next;
        }

        var cur = input[input.length - 1];
        var next = input[0];

        board[cur] = next;
    }

    @Override
    public Long solve(List<String> lines) {
        var input = lines.get(0).chars().map(c -> c - '0').toArray();

        buildBoard(input);
        current = input[0];

        for (var loop = 0; loop < 100; loop += 1) {
            pickCups();
        }

        var answer = getAnswer();

        return Long.parseLong(answer);
    }
}
