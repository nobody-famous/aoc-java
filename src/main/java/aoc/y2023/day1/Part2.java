package aoc.y2023.day1;

public class Part2 extends Solver {
    public Part2(String fileName, int exp) {
        super(fileName, exp);
    }

    @Override
    String getQuery() {
        return """
                WITH values AS (
                    SELECT SUBSTRING(value, '.*?(one|two|three|four|five|six|seven|eight|nine|\\d)') as first,
                           SUBSTRING(value, '.*(one|two|three|four|five|six|seven|eight|nine|\\d)') as last
                    FROM "2023.day1".calibration_value
                ), digits AS (
                    SELECT CASE
                            WHEN first = 'one' THEN '1'
                            WHEN first = 'two' THEN '2'
                            WHEN first = 'three' THEN '3'
                            WHEN first = 'four' THEN '4'
                            WHEN first = 'five' THEN '5'
                            WHEN first = 'six' THEN '6'
                            WHEN first = 'seven' THEN '7'
                            WHEN first = 'eight' THEN '8'
                            WHEN first = 'nine' THEN '9'
                            ELSE first END AS first_digit,
                           CASE
                            WHEN last = 'one' THEN '1'
                            WHEN last = 'two' THEN '2'
                            WHEN last = 'three' THEN '3'
                            WHEN last = 'four' THEN '4'
                            WHEN last = 'five' THEN '5'
                            WHEN last = 'six' THEN '6'
                            WHEN last = 'seven' THEN '7'
                            WHEN last = 'eight' THEN '8'
                            WHEN last = 'nine' THEN '9'
                            ELSE last END AS last_digit
                    FROM values
                )
                SELECT SUM(CONCAT(first_digit, last_digit)::numeric)
                FROM digits
                """;
    }
}
