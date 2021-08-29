package y2019.day2;

import utils.Problem;
import y2019.intcode.Machine;
import y2019.intcode.Parser;

public class Part2 extends Problem<Integer> {
    private Parser parser;

    public Part2(String fileName, int exp) {
        super(exp);

        parser = new Parser(fileName);
    }

    private int runMachine(int[] prog, int noun, int verb) {
        var mach = new Machine(prog);

        mach.set(1, noun);
        mach.set(2, verb);

        while (!mach.isHalted()) {
            mach.exec();
        }

        return mach.get(0);
    }

    public Integer run() {
        var prog = parser.parse();
        var target = 19690720;
        var answer = 0;

        for (var noun = 0; answer == 0 && noun < 100; noun += 1) {
            for (var verb = 0; answer == 0 && verb < 100; verb += 1) {
                if (runMachine(prog, noun, verb) == target) {
                    answer = (100 * noun) + verb;
                }
            }
        }

        return answer;
    }
}
