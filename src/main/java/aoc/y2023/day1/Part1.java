package aoc.y2023.day1;

import java.sql.Connection;
import java.util.List;

import aoc.y2023.Problem2023;

public class Part1 extends Problem2023<Integer> {
    public Part1(String fileName, int exp) {
        super(fileName, exp);
    }

    @Override
    public Integer run(Connection conn, List<String> lines) {
        try {
            clearTable(conn);
            populateTable(conn, lines);

            var sql = """
                    SELECT SUM(
                        CONCAT(SUBSTRING(value, '.*?(\\d)'), SUBSTRING(value, '.*(\\d)'))::numeric
                    )
                    FROM "2023.day1".calibration_value
                    """;
            try (var ps = conn.prepareStatement(sql)) {
                var result = ps.executeQuery();

                if (result.next()) {
                    return result.getInt(1);
                }
            }

            return 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    private void populateTable(Connection conn, List<String> values) throws Exception {
        try (var ps = conn.prepareStatement("INSERT INTO \"2023.day1\".calibration_value (value) VALUES (?)")) {
            for (var value : values) {
                ps.setString(1, value);
                ps.addBatch();
            }

            ps.executeBatch();
        }
    }

    private void clearTable(Connection conn) throws Exception {
        try (var ps = conn.prepareStatement("DELETE FROM \"2023.day1\".calibration_value")) {
            ps.executeUpdate();
        }
    }
}
