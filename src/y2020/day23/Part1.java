package y2020.day23;

public class Part1 extends Solver {
    public Part1(int[] input) {
        super(input, 9);
    }

    private String getAnswer() {
        var builder = new StringBuilder();
        var next = board[1].getNext();

        while (next != 1) {
            builder.append(next);
            next = board[next].getNext();
        }

        return builder.toString();
    }

    protected void buildBoard() {
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

    public long solve() {
        buildBoard();
        current = input[0];

        for (var loop = 0; loop < 100; loop += 1) {
            pickCups();
        }

        var answer = getAnswer();

        System.out.println(answer);
        return 0L;
    }
}
