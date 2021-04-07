package y2020.day9;

public class Part1 extends Solver {
    public Part1(long[] input) {
        super(input, 25);
    }

    public long solve() {
        var answer = findWeakness(input, preambleLength);

        return answer;
    }
}
