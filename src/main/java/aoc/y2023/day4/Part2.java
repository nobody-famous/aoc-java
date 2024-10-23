package aoc.y2023.day4;

import java.sql.Connection;

public class Part2 extends Solver {
    private String winsCountSQL = """
            WITH wins AS (
                SELECT c.number AS id, COUNT(*) AS count
                    FROM "2023.day4".winning w
                    JOIN "2023.day4".card c ON c.id = w.card_id
                    JOIN "2023.day4".holding h ON h.card_id = w.card_id AND h.number = w.number
                    GROUP BY h.card_id, c.number
            )
            UPDATE "2023.day4".card c
            SET wins = wins.count
            FROM wins
            WHERE c.number = wins.id
            """;
    private String updateCountSQL = """
            UPDATE "2023.day4".card
            SET copies = copies + ?
            WHERE number = ?
            """;
    private String sumCopiesSQL = """
            SELECT SUM(copies) as copies FROM"2023.day4".card
            """;
    private String cardNumberSQL = """
            SELECT number, wins FROM "2023.day4".card ORDER BY number ASC
            """;
    private String cardCopiesSQL = """
            SELECT copies FROM "2023.day4".card WHERE number = ?
            """;

    public Part2(String fileName, int exp) {
        super(fileName, exp);
    }

    @Override
    protected int getResult(Connection conn) throws Exception {
        computeWins(conn);
        updateCounts(conn);

        return sumCounts(conn);
    }

    private void computeWins(Connection conn) throws Exception {
        try (var ps = conn.prepareStatement(winsCountSQL)) {
            ps.executeUpdate();
        }
    }

    private int getCardCopies(Connection conn, int cardNumber) throws Exception {
        try (var queryPS = conn.prepareStatement(cardCopiesSQL)) {
            queryPS.setInt(1, cardNumber);

            var result = queryPS.executeQuery();

            result.next();

            return result.getInt(1);
        }
    }

    private void updateCounts(Connection conn) throws Exception {
        try (var queryPS = conn.prepareStatement(cardNumberSQL);
                var updatePS = conn.prepareStatement(updateCountSQL)) {
            var result = queryPS.executeQuery();

            while (result.next()) {
                var card = result.getInt(1);
                var wins = result.getInt(2);
                var copies = getCardCopies(conn, card);

                for (var toAdd = card + 1; toAdd <= card + wins; toAdd++) {
                    updatePS.setInt(1, copies);
                    updatePS.setInt(2, toAdd);
                    updatePS.executeUpdate();
                }
            }
        }
    }

    private int sumCounts(Connection conn) throws Exception {
        try (var ps = conn.prepareStatement(sumCopiesSQL)) {
            var result = ps.executeQuery();

            result.next();

            return result.getInt(1);
        }
    }
}
