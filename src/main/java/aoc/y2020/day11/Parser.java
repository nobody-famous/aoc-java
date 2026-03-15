package aoc.y2020.day11;

import java.util.List;

public class Parser implements aoc.utils.Parser<char[][]> {
    @Override
    public char[][] parse(List<String> lines) {
        var board = new char[lines.size()][lines.get(0).length()];

        for (var row = 0; row < lines.size(); row++) {
            var line = lines.get(row);

            for (var col = 0; col < line.length(); col++) {
                board[row][col] = line.charAt(col);
            }
        }

        return board;
    }
}
