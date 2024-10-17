package aoc.y2023.day4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.regex.Pattern;

import aoc.y2023.Problem2023;

public class Part1 extends Problem2023<Integer> {
    static String createCardSQL = """
            INSERT INTO "2023.day4"."card" (number) VALUES (?) RETURNING ID
            """;
    static String createWinningSQL = """
            INSERT INTO "2023.day4".winning (card_id, number)
            VALUES ((SELECT id FROM "2023.day4".card WHERE number = ?),?)
            """;
    static String createHoldingSQL = """
            INSERT INTO "2023.day4".holding (card_id, number)
            VALUES ((SELECT id FROM "2023.day4".card WHERE number = ?),?)
            """;

    static String resultSQL = """
            WITH counts AS (
                SELECT h.card_id AS id, COUNT(*) AS count
                FROM "2023.day4".winning w
                JOIN "2023.day4".holding h ON h.card_id = w.card_id AND h.number = w.number
                GROUP BY h.card_id
            )
            SELECT SUM(POW(2, count - 1)) AS result FROM counts
            """;

    static Pattern cardRegEx = Pattern.compile("Card\\s+(\\d+):\\s+(.*)\\s+\\|\\s+(.*)");

    public Part1(String fileName, int exp) {
        super(fileName, exp);
    }

    private record PreparedStatements(
            PreparedStatement createCard,
            PreparedStatement createWinning,
            PreparedStatement createHolding) {
    }

    @Override
    public Integer run(Connection conn, List<String> lines) {
        // TODO: clear the tables before each run

        try (var createCardPS = conn.prepareStatement(createCardSQL);
                var createWinningPS = conn.prepareStatement(createWinningSQL);
                var createHoldingPS = conn.prepareStatement(createHoldingSQL);
                var resultPS = conn.prepareStatement(resultSQL)) {

            parseLines(new PreparedStatements(createCardPS, createWinningPS, createHoldingPS), lines);
            
            var result = resultPS.executeQuery();

            result.next();

            return result.getInt(1);
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    private void addNumberList(PreparedStatement ps, int cardNumber, String[] numbers) throws Exception {
        for (var item : numbers) {
            var str = item.trim();

            if (str.length() == 0) {
                continue;
            }

            var number = Integer.parseInt(str);
            ps.setInt(1, cardNumber);
            ps.setInt(2, number);
            ps.addBatch();
        }
    }

    private void parseLines(PreparedStatements ps, List<String> lines) throws Exception {
        for (var line : lines) {
            var matcher = cardRegEx.matcher(line.trim());

            if (!matcher.matches()) {
                throw new RuntimeException("Invalid input: " + line);
            }

            var cardNumber = Integer.parseInt(matcher.group(1));
            var winning = matcher.group(2).trim();
            var holding = matcher.group(3).trim();

            ps.createCard().setInt(1, cardNumber);
            ps.createCard().addBatch();

            addNumberList(ps.createWinning(), cardNumber, winning.split(" "));
            addNumberList(ps.createHolding(), cardNumber, holding.split(" "));
        }

        ps.createCard().executeBatch();
        ps.createWinning().executeBatch();
        ps.createHolding().executeBatch();
    }
}
