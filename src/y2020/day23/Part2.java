package y2020.day23;

public class Part2 extends Solver {
    public Part2(int[] input) {
        super(input, 1000000);
    }

    private void buildBoard() {
        board = new Node[1000001];

        for (var ndx = 0; ndx < input.length - 1; ndx += 1) {
            var cur = input[ndx];
            var next = input[ndx + 1];

            board[cur] = new Node(next);
        }

        var cur = input[input.length - 1];
        var next = 10;

        while (next < board.length) {
            board[cur] = new Node(next);
            cur = next;
            next += 1;
        }

        board[cur] = new Node(input[0]);
    }

    public long solve() {
        buildBoard();

        current = input[0];

        for (var loop = 0; loop < 10000000; loop += 1) {
            pickCups();
        }

        var first = board[1].getNext();
        var second = board[first].getNext();
        long answer = (long) first * (long) second;

        return answer;
    }
}
