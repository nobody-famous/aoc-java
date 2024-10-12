package aoc.y2023.day2;

import java.sql.Connection;
import java.util.List;
import java.util.regex.Pattern;

import aoc.y2023.Problem2023;

public abstract class Solver extends Problem2023<Integer> {
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

    private int createGame(Connection conn, int number) throws Exception {
        var sql = "INSERT INTO \"2023.day2\".game (number) VALUES (?) RETURNING ID";

        try (var ps = conn.prepareStatement(sql)) {
            ps.setInt(1, number);

            var result = ps.executeQuery();

            result.next();

            return result.getInt(1);
        }
    }

    private void createRound(Connection conn, int gameId, int red, int blue, int green) throws Exception {
        var sql = "INSERT INTO \"2023.day2\".round (game_id, red, blue, green) VALUES (?,?,?,?)";

        try (var ps = conn.prepareStatement(sql)) {
            ps.setInt(1, gameId);
            ps.setInt(2, red);
            ps.setInt(3, blue);
            ps.setInt(4, green);

            ps.executeUpdate();
        }
    }

    private void populateTables(Connection conn, List<String> lines) throws Exception {
        var gameRegEx = Pattern.compile("Game (\\d+): (.*)");
        var cubeRegEx = Pattern.compile("(\\d+) (red|green|blue)");

        for (var line : lines) {
            var matcher = gameRegEx.matcher(line);

            if (!matcher.matches()) {
                throw new Exception("Invalid input: " + line);
            }

            var gameId = Integer.parseInt(matcher.group(1));
            var id = createGame(conn, gameId);

            for (var round : matcher.group(2).split(";")) {
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

                createRound(conn, id, red, blue, green);
            }
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
