package aoc.y2023.day1;

public class Part1 extends Solver {
    public Part1(String fileName, int exp) {
        super(fileName, exp);
    }

    @Override
    String getQuery() {
        return """
                SELECT SUM(
                    CONCAT(SUBSTRING(value, '.*?(\\d)'), SUBSTRING(value, '.*(\\d)'))::numeric
                )
                FROM "2023.day1".calibration_value
                """;
    }
}
