package aoc.y2023.day2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.regex.Pattern;

import aoc.y2023.Problem2023;

public abstract class Solver extends Problem2023<Integer> {
    static String createGameSQL = """
            INSERT INTO "2023.day2".game (number) VALUES (?) RETURNING ID
            """;
    static String createRoundSQL = """
            INSERT INTO "2023.day2".round (game_id, red, blue, green)
            VALUES ((SELECT id FROM "2023.day2".game WHERE number = ?),?,?,?)
            """;

    static Pattern gameRegEx = Pattern.compile("Game (\\d+): (.*)");
    static Pattern cubeRegEx = Pattern.compile("(\\d+) (red|green|blue)");

    abstract String getQuery();

    public Solver(String fileName, int exp) {
        super(fileName, exp);
    }

    @Override
    public Integer run(Connection conn, List<String> lines) {
        try {
            Utils.clearTables(conn);
            populateTables(conn, lines);

            return calculateAnswer(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    private void createRounds(PreparedStatement ps, int gameId, String[] rounds) throws Exception {
        for (var round : rounds) {
            var cubes = round.split(",");
            var red = 0;
            var green = 0;
            var blue = 0;

            for (var cube : cubes) {
                var cubeMatcher = cubeRegEx.matcher(cube.trim());

                if (!cubeMatcher.matches()) {
                    throw new Exception("Invalid cube: " + cube);
                }

                var count = Integer.parseInt(cubeMatcher.group(1));
                var color = cubeMatcher.group(2).trim();

                if ("red".equals(color)) {
                    red = count;
                } else if ("green".equals(color)) {
                    green = count;
                } else if ("blue".equals(color)) {
                    blue = count;
                }
            }

            ps.setInt(1, gameId);
            ps.setInt(2, red);
            ps.setInt(3, blue);
            ps.setInt(4, green);
            ps.addBatch();
        }
    }

    private void populateTables(Connection conn, List<String> lines) throws Exception {
        try (var gamePS = conn.prepareStatement(createGameSQL);
                var roundPS = conn.prepareStatement(createRoundSQL)) {
            for (var line : lines) {
                var matcher = gameRegEx.matcher(line);

                if (!matcher.matches()) {
                    throw new Exception("Invalid input: " + line);
                }

                var gameId = Integer.parseInt(matcher.group(1));

                gamePS.setInt(1, gameId);
                gamePS.addBatch();

                createRounds(roundPS, gameId, matcher.group(2).split(";"));
            }

            gamePS.executeBatch();
            roundPS.executeBatch();
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
