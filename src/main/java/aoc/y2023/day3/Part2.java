package aoc.y2023.day3;

public class Part2 extends Solver {
    public Part2(String fileName, int expected) {
        super(fileName, expected);
    }

    @Override
    String getSQL() {
        return """
                WITH agg AS (
                    SELECT s.id, count(*) as count, array_agg(n."value") AS values FROM "2023.day3".number n
                    JOIN "2023.day3".symbol s
                    ON (s.y = n.y OR s.y = n.y + 1 OR s.y = n.y - 1)  AND s.x >= n.start_x - 1 AND s.x <= n.end_x + 1
                    GROUP BY s.id
                )
                SELECT SUM(values[1] * values[2]) AS total
                FROM agg
                WHERE count = 2
                """;
    }
}
