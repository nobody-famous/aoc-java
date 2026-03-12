package aoc.y2019.day8;

import java.util.List;

import aoc.utils.StringProblem;

public class Part2 extends StringProblem {
    private final Parser parser = new Parser(25, 6);

    @Override
    public String solve(List<String> lines) {
        var img = parser.parse(lines);

        // var canvas = img.render();
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
