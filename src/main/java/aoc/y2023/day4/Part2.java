package aoc.y2023.day4;

import java.sql.Connection;
import java.util.HashMap;

public class Part2 extends Solver {
    private String countSQL = """
            SELECT c.number AS id, COUNT(*) AS count
                FROM "2023.day4".winning w
                JOIN "2023.day4".card c ON c.id = w.card_id
                JOIN "2023.day4".holding h ON h.card_id = w.card_id AND h.number = w.number
                GROUP BY h.card_id, c.number
            """;
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
    private String cardNumberSQL = """
            SELECT number, copies, wins FROM "2023.day4".card ORDER BY number ASC
            """;

    public Part2(String fileName, int exp) {
        super(fileName, exp);
    }

    @Override
    protected int getResult(Connection conn) throws Exception {
        computeWins(conn);
        updateCounts(conn);

        printTable(conn);
        // return sumCounts(counts);
        return 0;
    }

    private void printTable(Connection conn) throws Exception {
        try (var ps = conn.prepareStatement("SELECT number, copies, wins FROM \"2023.day4\".card")) {
            var result = ps.executeQuery();

            while (result.next()) {
                System.out.println("***** " + result.getInt(1) + " " + result.getInt(2) + " " + result.getInt(3));
            }
        }
    }

    private void initCounts(Connection conn, HashMap<Integer, Integer> counts) throws Exception {
        try (var ps = conn.prepareStatement(cardNumberSQL)) {
            var result = ps.executeQuery();

            while (result.next()) {
                counts.put(result.getInt(1), 1);
            }
        }
    }

    private void computeWins(Connection conn) throws Exception {
        try (var ps = conn.prepareStatement(winsCountSQL)) {
            ps.executeUpdate();
        }
    }

    private void updateCounts(Connection conn) throws Exception {
        try (var queryPS = conn.prepareStatement(cardNumberSQL);
                var updatePS = conn.prepareStatement(updateCountSQL)) {
            var result = queryPS.executeQuery();

            while (result.next()) {
                var card = result.getInt(1);
                var copies = result.getInt(2);
                var wins = result.getInt(3);

                System.out.println("***** UPDATE " + card + " " + wins);
                for (var toAdd = card + 1; toAdd <= card + wins; toAdd++) {
                    updatePS.setInt(1, copies);
                    updatePS.setInt(2, toAdd);
                    System.out.println("**** TOADD " + toAdd + " " + copies);
                    updatePS.executeUpdate();
                }
            }
        }
        // for (var card = 1; counts.containsKey(card); card++) {
        //     var cardWins = wins.containsKey(card) ? wins.get(card) : 0;
        //     var cardCount = counts.get(card);

        //     for (var toAdd = card + 1; toAdd <= card + cardWins; toAdd++) {
        //         var current = counts.get(toAdd);
        //         counts.put(toAdd, current + cardCount);
        //     }
        // }
    }

    private int sumCounts(HashMap<Integer, Integer> counts) {
        int sum = 0;

        for (var card = 1; counts.containsKey(card); card++) {
            sum += counts.get(card);
        }

        return sum;
    }
}
