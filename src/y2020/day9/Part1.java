package y2020.day9;

public class Part1 extends Solver {
    public Part1(long[] input, long expected) {
        super(input, 25, expected);
    }

    public Long run() {
        var answer = findWeakness(input, preambleLength);

        return answer;
    }
}
