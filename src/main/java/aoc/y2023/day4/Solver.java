package aoc.y2023.day4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.regex.Pattern;

import aoc.y2023.Problem2023;

public abstract class Solver extends Problem2023<Integer> {
    static final String createCardSQL = """
            INSERT INTO "2023.day4"."card" (number) VALUES (?) RETURNING ID
            """;
    static final String clearCardSQL = """
            DELETE FROM "2023.day4"."card"
            """;
    static final String createWinningSQL = """
            INSERT INTO "2023.day4".winning (card_id, number)
            VALUES ((SELECT id FROM "2023.day4".card WHERE number = ?),?)
            """;
    static final String clearWinningSQL = """
            DELETE FROM "2023.day4".winning
            """;
    static final String createHoldingSQL = """
            INSERT INTO "2023.day4".holding (card_id, number)
            VALUES ((SELECT id FROM "2023.day4".card WHERE number = ?),?)
            """;
    static final String clearHoldingSQL = """
            DELETE FROM "2023.day4".holding
            """;

    static final Pattern cardRegEx = Pattern.compile("Card\\s+(\\d+):\\s+(.*)\\s+\\|\\s+(.*)");

    protected abstract int getResult(Connection conn) throws Exception;

    public Solver(String fileName, int expected) {
        super(fileName, expected);
    }

    @Override
    public Integer run(Connection conn, List<String> lines) {
        try (var createCardPS = conn.prepareStatement(createCardSQL);
             var createWinningPS = conn.prepareStatement(createWinningSQL);
             var createHoldingPS = conn.prepareStatement(createHoldingSQL)) {

            clearTables(conn);
            parseLines(createCardPS, createWinningPS, createHoldingPS, lines);

            return getResult(conn);
        } catch (Exception ex) {
            System.out.println("Failed: " + ex.getMessage());
            return 0;
        }
    }

    private void clearTables(Connection conn) throws Exception {
        try (var clearCardPS = conn.prepareStatement(clearCardSQL);
             var clearWinningPS = conn.prepareStatement(clearWinningSQL);
             var clearHoldingPS = conn.prepareStatement(clearHoldingSQL)) {
            clearWinningPS.executeUpdate();
            clearHoldingPS.executeUpdate();
            clearCardPS.executeUpdate();
        }
    }

    private void addNumberList(PreparedStatement ps, int cardNumber, String[] numbers) throws Exception {
        for (var item : numbers) {
            var str = item.trim();

            if (str.isEmpty()) {
                continue;
            }

            var number = Integer.parseInt(str);
            ps.setInt(1, cardNumber);
            ps.setInt(2, number);
            ps.addBatch();
        }
    }

    private void parseLines(PreparedStatement createCardPS, PreparedStatement createWinningPS, PreparedStatement createHoldingPS, List<String> lines) throws Exception {
        for (var line : lines) {
            var matcher = cardRegEx.matcher(line.trim());

            if (!matcher.matches()) {
                throw new RuntimeException("Invalid input: " + line);
            }

            var cardNumber = Integer.parseInt(matcher.group(1));
            var winning = matcher.group(2).trim();
            var holding = matcher.group(3).trim();

            createCardPS.setInt(1, cardNumber);
            createCardPS.addBatch();

            addNumberList(createWinningPS, cardNumber, winning.split(" "));
            addNumberList(createHoldingPS, cardNumber, holding.split(" "));
        }

        createCardPS.executeBatch();
        createWinningPS.executeBatch();
        createHoldingPS.executeBatch();
    }
}
