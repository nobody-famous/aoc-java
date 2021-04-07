package y2020.day3;

public class Part1 extends Solver {
    public Part1(char[][] input) {
        super(input);
    }

    public long solve() {
        var answer = countTrees(input, 3, 1);

        return answer;
    }
}
