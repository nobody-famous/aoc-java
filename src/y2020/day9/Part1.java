package y2020.day9;

public class Part1 extends Solver {
    public long solve(long[] input, int preambleLength) {
        return findWeakness(input, preambleLength);
    }

    public static void main(String[] args) {
        var solver = new Part1();
        var answer = solver.solve(Input.puzzle, 25);

        System.out.println(answer);
    }
}
