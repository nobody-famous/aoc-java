package y2019.day7;

import utils.Problem;
import y2019.intcode.Parser;

public class Part1 extends Problem<Long> {
    private Parser parser;

    public Part1(String fileName, long exp) {
        super(exp);

        this.parser = new Parser(fileName);
    }

    public Long run() {
        var prog = parser.parse();
        var perms = Utils.findPerms(new int[] { 0, 1, 2, 3, 4 });

        var most = 0L;

        for (var perm : perms) {
            var circuit = new Circuit(prog, 5);

            circuit.init(perm);

            var signal = circuit.run(0);
            if (signal > most) {
                most = signal;
            }
        }

        return most;
    }
}
