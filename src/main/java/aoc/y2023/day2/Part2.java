package aoc.y2023.day2;

public class Part2 extends Solver {
    public Part2(String fileName, int exp) {
        super(fileName, exp);
    }

    @Override
    String getQuery() {
        var sql = """
                WITH powers AS (
                    SELECT max(red) * max(blue) * max(green) AS power FROM "2023.day2".round r
                    LEFT JOIN "2023.day2".game g on g.id = r.game_id
                    GROUP BY g.number
                )
                SELECT SUM(power) FROM powers
                """;
        return sql;
    }
}
