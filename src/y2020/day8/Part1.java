package y2020.day8;

public class Part1 extends Solver {
    public long solve(Instruction[] prog) {
        return run(prog);
    }

    public static void main(String[] args) {
        var solver = new Part1();
        var answer = solver.solve(Input.puzzle);

        System.out.println(answer);
    }
}
