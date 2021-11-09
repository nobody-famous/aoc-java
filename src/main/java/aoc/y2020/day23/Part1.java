package aoc.y2020.day23;

public class Part1 extends Solver {
    public Part1(int[] input, long expected) {
        super(input, 9, expected);
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

    protected void buildBoard() {
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

    public Long run() {
        buildBoard();
        current = input[0];

        for (var loop = 0; loop < 100; loop += 1) {
            pickCups();
        }

        var answer = getAnswer();

        return Long.parseLong(answer);
    }
}
