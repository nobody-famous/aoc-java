package y2019.day2;

import utils.Problem;
import y2019.intcode.Machine;
import y2019.intcode.Parser;

public class Part1 extends Problem<Integer> {
    private y2019.intcode.Parser parser;

    public Part1(String fileName, int exp) {
        super(exp);

        parser = new Parser(fileName);
    }

    public Integer run() {
        var prog = parser.parse();
        var mach = new Machine(prog);

        mach.set(1, 12);
        mach.set(2, 2);

        while (!mach.isHalted()) {
            mach.exec();
        }

        return mach.get(0);
    }
}
