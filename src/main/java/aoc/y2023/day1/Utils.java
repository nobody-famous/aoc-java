package aoc.y2023.day1;

import java.sql.Connection;
import java.util.List;

public interface Utils {
    static void populateTable(Connection conn, List<String> values) throws Exception {
        try (var ps = conn.prepareStatement("INSERT INTO \"2023.day1\".calibration_value (value) VALUES (?)")) {
            for (var value : values) {
                ps.setString(1, value);
                ps.addBatch();
            }

            ps.executeBatch();
        }
    }

    static void clearTable(Connection conn) throws Exception {
        try (var ps = conn.prepareStatement("DELETE FROM \"2023.day1\".calibration_value")) {
            ps.executeUpdate();
        }
    }
}
