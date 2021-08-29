package y2019.day5;

import utils.Problem;
import y2019.intcode.Machine;
import y2019.intcode.Parser;

public class Part2 extends Problem<Integer> {
    private Parser parser;

    public Part2(String fileName, int exp) {
        super(exp);

        parser = new Parser(fileName);
    }

    public Integer run() {
        var prog = parser.parse();
        var io = new MachIO(5);
        var mach = new Machine(prog, io);

        while (!mach.isHalted()) {
            mach.exec();
        }

        return io.getLastOutput();
    }
}
