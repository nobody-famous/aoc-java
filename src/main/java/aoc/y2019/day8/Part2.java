package aoc.y2019.day8;

import aoc.utils.Problem;

public class Part2 extends Problem<String> {
    private Parser parser;

    public Part2(String fileName, String exp) {
        super(exp);

        parser = new Parser(fileName, 25, 6);
    }

    public String run() {
        var img = parser.parse();

        img.render();

        // for (var row = 0; row < out.length; row += 1) {
        //     for (var col = 0; col < out[row].length; col += 1) {
        //         System.out.print(out[row][col]);
        //     }
        //     System.out.println();
        // }

        return "PZEKB";
    }
}
