package aoc.y2023.day1;

import java.sql.Connection;
import java.util.List;

import aoc.y2023.Problem2023;

public abstract class Solver extends Problem2023<Integer> {
    abstract String getQuery();

    public Solver(String fileName, int exp) {
        super(fileName, exp);
    }

    @Override
    public Integer run(Connection conn, List<String> lines) {
        try {
            Utils.clearTable(conn);
            Utils.populateTable(conn, lines);

            return calculateAnswer(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    private int calculateAnswer(Connection conn) throws Exception {
        var sql = getQuery();

        try (var ps = conn.prepareStatement(sql)) {
            var result = ps.executeQuery();

            if (result.next()) {
                return result.getInt(1);
            }
        }

        return 0;
    }
}
