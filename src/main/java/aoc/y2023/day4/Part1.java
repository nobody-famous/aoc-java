package aoc.y2023.day4;

import java.sql.Connection;

public class Part1 extends Solver {
    public Part1(String fileName, int exp) {
        super(fileName, exp);
    }

    private String resultSQL = """
            WITH counts AS (
                SELECT h.card_id AS id, COUNT(*) AS count
                FROM "2023.day4".winning w
                JOIN "2023.day4".holding h ON h.card_id = w.card_id AND h.number = w.number
                GROUP BY h.card_id
            )
            SELECT SUM(POW(2, count - 1)) AS result FROM counts
            """;

    @Override
    protected int getResult(Connection conn) throws Exception {
        try (var resultPS = conn.prepareStatement(resultSQL)) {
            var result = resultPS.executeQuery();

            result.next();

            return result.getInt(1);
        }
    }
}
