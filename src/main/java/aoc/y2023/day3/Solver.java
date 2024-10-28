package aoc.y2023.day3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import aoc.y2023.Problem2023;

public abstract class Solver extends Problem2023<Integer> {
    private static final String insertNumberSQL = """
            INSERT INTO "2023.day3"."number" (y, start_x, end_x, value) VALUES (?,?,?,?)
            """;
    private static final String insertSymbolSQL = """
            INSERT INTO "2023.day3".symbol (y, x, value) VALUES (?,?,?)
            """;

    abstract String getSQL();

    public Solver(String fileName, int expected) {
        super(fileName, expected);
    }

    @Override
    public Integer run(Connection conn, List<String> lines) {
        try (var numberPS = conn.prepareStatement(insertNumberSQL);
             var symbolPS = conn.prepareStatement(insertSymbolSQL)) {
            clearTables(conn);
            populateTables(numberPS, symbolPS, lines);

            numberPS.executeBatch();
            symbolPS.executeBatch();

            var ps = conn.prepareStatement(getSQL());
            var result = ps.executeQuery();

            result.next();

            return result.getInt(1);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }

    private void clearTables(Connection conn) throws Exception {
        try (var numberPS = conn.prepareStatement("DELETE FROM \"2023.day3\".\"number\"");
             var symbolPS = conn.prepareStatement("DELETE FROM \"2023.day3\".symbol")) {
            numberPS.executeUpdate();
            symbolPS.executeUpdate();
        }
    }

    private void populateTables(PreparedStatement numberPS, PreparedStatement symbolPS, List<String> lines)
            throws Exception {
        var parser = new Parser(
                (y, startX, endX, value) -> foundNumber(numberPS, y, startX, endX, value),
                (y, x, ch) -> foundSymbol(symbolPS, y, x, ch));

        parser.parseLines(lines);
    }

    private void foundNumber(PreparedStatement ps, int y, int startX, int endX, int number) throws Exception {
        ps.setInt(1, y);
        ps.setInt(2, startX);
        ps.setInt(3, endX);
        ps.setInt(4, number);
        ps.addBatch();
    }

    private void foundSymbol(PreparedStatement ps, int y, int x, char ch) throws Exception {
        ps.setInt(1, y);
        ps.setInt(2, x);
        ps.setString(3, String.valueOf(ch));
        ps.addBatch();
    }
}
