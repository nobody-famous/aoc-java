package aoc.y2019.day8;

import java.util.List;

import aoc.utils.Problem;

public class Part2 extends Problem<String> {
    private Parser parser = new Parser(25, 6);

    public Part2(String fileName, String exp) {
        super(fileName, exp);
    }

    @Override
    public String run(List<String> lines) {
        var img = parser.parse(lines);

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
