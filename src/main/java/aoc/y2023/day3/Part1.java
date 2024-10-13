package aoc.y2023.day3;

import java.sql.Connection;
import java.util.List;

import aoc.y2023.Problem2023;

public class Part1 extends Problem2023<Integer> {
    public Part1(String fileName, int expected) {
        super(fileName, expected);
    }

    @Override
    public Integer run(Connection conn, List<String> lines) {
        var parser = new Parser(
                (y, startX, endX, value) -> foundNumber(conn, y, startX, endX, value),
                (y, x, ch) -> foundSymbol(conn, y, x, ch));

        parser.parseLines(lines);

        return 0;
    }

    private void foundNumber(Connection conn, int y, int startX, int endX, int number) {
        System.out.println("***** FOUND NUMBER " + number);
    }

    private void foundSymbol(Connection conn, int y, int x, char ch) {
        System.out.println("***** FOUND SYMBOL " + ch);
    }
}
