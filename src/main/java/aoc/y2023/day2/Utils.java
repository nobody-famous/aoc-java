package aoc.y2023.day2;

import java.sql.Connection;

public interface Utils {
    static void clearTables(Connection conn) throws Exception {
        try (var ps = conn.prepareStatement("DELETE FROM \"2023.day2\".round")) {
            ps.executeUpdate();
        }

        try (var ps = conn.prepareStatement("DELETE FROM \"2023.day2\".game")) {
            ps.executeUpdate();
        }
    }
}
