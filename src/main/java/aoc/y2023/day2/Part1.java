package aoc.y2023.day2;

public class Part1 extends Solver {
    public Part1(String fileName, int exp) {
        super(fileName, exp);
    }

    @Override
    String getQuery() {
        return """
                WITH round_possible AS (
                    SELECT g.number as game_id, r.red <= 12 AND r.green <= 13 AND r.blue <= 14 as possible FROM "2023.day2".round r
                    LEFT JOIN "2023.day2".game g ON g.id = r.game_id
                ), game_possible AS (
                    SELECT game_id, bool_and(possible) as result FROM round_possible
                    GROUP BY game_id
                )
                SELECT SUM(game_possible.game_id) FROM game_possible WHERE result
                """;
    }
}
