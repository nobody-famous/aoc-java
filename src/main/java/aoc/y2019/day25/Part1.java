package aoc.y2019.day25;

import aoc.utils.Problem;
import aoc.y2019.intcode.Parser;

public class Part1 extends Problem<Integer> {
    private Parser parser;
    private Droid droid;

    public Part1(String fileName, int exp) {
        super(exp);

        parser = new Parser(fileName);
    }

    private String nextLine() {
        var line = "";

        while (!droid.isHalted() && line.length() == 0) {
            line = droid.readLine();
        }

        return line;
    }

    @Override
    public Integer run() {
        var prog = parser.parse();
        var commands = new String[] { "north", "east", "north", "east", "take semiconductor", "west", "south", "west",
                "south", "east", "north", "take coin", "south", "east", "take candy cane", "west", "west", "south",
                "east", "take mouse", "south", "west", "" };

        droid = new Droid(prog);

        Integer ans = null;
        var cmdNdx = 0;
        while (ans == null) {
            if (droid.isHalted()) {
                break;
            }

            var line = nextLine();

            if ("Command?".equals(line)) {
                var cmd = commands[cmdNdx];
                droid.writeLine(cmd + "\n");
                cmdNdx += 1;
            } else if (line.contains("typing")) {
                var parts = line.split(" ");
                ans = Integer.parseInt(parts[11]);
            }
        }

        return ans;
    }
}
