package y2020.day3;

public class Part1 extends Solver {
    protected long solve(char[][] input) {
        return countTrees(input, 3, 1);
    }

    public static void main(String[] args) {
        var solver = new Part1();
        var answer = solver.solve(Input.puzzle);

        System.out.println(answer);
    }
}
