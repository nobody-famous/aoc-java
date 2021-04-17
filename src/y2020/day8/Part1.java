package y2020.day8;

public class Part1 extends Solver {
    public Part1(Instruction[] prog, long expected) {
        super(prog, expected);
    }

    public Long run() {
        var answer = runProgram(prog);

        return answer;
    }
}
