package y2020.day3;

public class Part1 extends Solver {
    public Part1(char[][] input, long expected) {
        super(input, expected);
    }

    public Long run() {
        var answer = countTrees(input, 3, 1);

        return answer;
    }
}
