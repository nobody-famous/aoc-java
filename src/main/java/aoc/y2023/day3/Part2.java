package aoc.y2023.day3;

public class Part2 extends Solver {
    public Part2(String fileName, int expected) {
        super(fileName, expected);
    }

    @Override
    String getSQL() {
        return """
                SELECT SUM(n.value) FROM "2023.day3".number n
                JOIN "2023.day3".symbol s
                ON (s.y = n.y OR s.y = n.y + 1 OR s.y = n.y - 1)  AND s.x >= n.start_x - 1 AND s.x <= n.end_x + 1
                """;
    }
}
