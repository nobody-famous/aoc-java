package aoc.y2023.day5;

import aoc.y2023.Problem2023;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.regex.Pattern;

public class Part1 extends Problem2023<Integer> {
    private final Pattern seedsRegEx = Pattern.compile("seeds:(.*)");
    private final Pattern mapRegEx = Pattern.compile("(\\S+)-to-(\\S+) map:");

    private static final String clearSeedSQL = """
            DELETE FROM "2023.day5".seeds
            """;
    private static final String clearMapsSQL = """
            DELETE FROM "2023.day5".maps
            """;
    private static final String insertSeedSQL = """
            INSERT INTO "2023.day5".seeds (number) VALUES (?)
            """;
    private static final String addToMapSQL = """
            INSERT INTO "2023.day5".maps (src, dst, src_start, dst_start, count) VALUES (?,?,?,?,?)
            """;

    private static final String minLocationSQL = """
            SELECT
                MIN(location)
            FROM
                (SELECT (WITH seed_diff AS (
                            SELECT number - src_start AS diff, dst_start AS dst
                            FROM "2023.day5".maps m
                            WHERE src = 'seed' AND number >= src_start AND number < src_start + count
                        ),
                        soil_value AS (
                            SELECT CASE WHEN EXISTS(SELECT diff FROM seed_diff)
                                    THEN (SELECT diff + dst FROM seed_diff)
                                    ELSE number
                                    END AS soil
                        ),
                        soil_diff AS (
                            SELECT s.soil - src_start AS diff, dst_start AS dst
                            FROM "2023.day5".maps m, soil_value s
                            WHERE src = 'soil' AND s.soil >= src_start AND s.soil < src_start + count
                        ),
                        fertilizer_value AS (
                            SELECT CASE WHEN EXISTS(SELECT diff FROM soil_diff)
                                    THEN (SELECT diff + dst FROM soil_diff)
                                    ELSE s.soil
                                    END AS fertilizer
                            FROM soil_value s
                        ),
                        fertilizer_diff AS (
                            SELECT s.fertilizer - src_start AS diff, dst_start AS dst
                            FROM "2023.day5".maps m, fertilizer_value s
                            WHERE src = 'fertilizer' AND s.fertilizer >= src_start AND s.fertilizer < src_start + count
                        ),
                        water_value AS (
                            SELECT CASE WHEN EXISTS(SELECT diff FROM fertilizer_diff)
                                    THEN (SELECT diff + dst FROM fertilizer_diff)
                                    ELSE s.fertilizer
                                    END AS water
                            FROM fertilizer_value s
                        ),
                        water_diff AS (
                            SELECT s.water - src_start AS diff, dst_start AS dst
                            FROM "2023.day5".maps m, water_value s
                            WHERE src = 'water' AND s.water >= src_start AND s.water < src_start + count
                        ),
                        light_value AS (
                            SELECT CASE WHEN EXISTS(SELECT diff FROM water_diff)
                                    THEN (SELECT diff + dst FROM water_diff)
                                    ELSE s.water
                                    END AS light
                            FROM water_value s
                        ),
                        light_diff AS (
                            SELECT s.light - src_start AS diff, dst_start AS dst
                            FROM "2023.day5".maps m, light_value s
                            WHERE src = 'light' AND s.light >= src_start AND s.light < src_start + count
                        ),
                        temperature_value AS (
                            SELECT CASE WHEN EXISTS(SELECT diff FROM light_diff)
                                    THEN (SELECT diff + dst FROM light_diff)
                                    ELSE s.light
                                    END AS temperature
                            FROM light_value s
                        ),
                        temperature_diff AS (
                            SELECT s.temperature - src_start AS diff, dst_start AS dst
                            FROM "2023.day5".maps m, temperature_value s
                            WHERE src = 'temperature' AND s.temperature >= src_start AND s.temperature < src_start + count
                        ),
                        humidity_value AS (
                            SELECT CASE WHEN EXISTS(SELECT diff FROM temperature_diff)
                                    THEN (SELECT diff + dst FROM temperature_diff)
                                    ELSE s.temperature
                                    END AS humidity
                            FROM temperature_value s
                        ),
                        humidity_diff AS (
                            SELECT s.humidity - src_start AS diff, dst_start AS dst
                            FROM "2023.day5".maps m, humidity_value s
                            WHERE src = 'humidity' AND s.humidity >= src_start AND s.humidity < src_start + count
                        ),
                        location_value AS (
                            SELECT CASE WHEN EXISTS(SELECT diff FROM humidity_diff)
                                    THEN (SELECT diff + dst FROM humidity_diff)
                                    ELSE s.humidity
                                    END AS location
                            FROM humidity_value s
                        )
                        SELECT location FROM location_value
                        ) as location
                        FROM "2023.day5".seeds)
            """;

    public Part1(String fileName, int exp) {
        super(fileName, exp);
    }

    private int solve(Connection conn) throws Exception {
        try (var ps = conn.prepareStatement(minLocationSQL)) {
            var result = ps.executeQuery();

            result.next();

            return result.getInt(1);
        }
    }

    @Override
    public Integer run(Connection conn, List<String> lines) {
        try {
            clearTables(conn);
            parseLines(conn, lines);
            return solve(conn);
        } catch (Exception ex) {
            System.out.println("Failed: " + ex.getMessage());
            return 0;
        }
    }

    private void clearTables(Connection conn) throws Exception {
        try (var seedsPS = conn.prepareStatement(clearSeedSQL);
             var mapsPS = conn.prepareStatement(clearMapsSQL)) {
            seedsPS.executeUpdate();
            mapsPS.executeUpdate();
        }
    }

    private void parseLines(Connection conn, List<String> lines) throws Exception {
        var src = "";
        var dst = "";

        try (var insertSeedPS = conn.prepareStatement(insertSeedSQL);
             var addToMapPS = conn.prepareStatement(addToMapSQL)) {
            try {
                for (var line : lines) {
                    var seedsMatcher = seedsRegEx.matcher(line);
                    var mapMatcher = mapRegEx.matcher(line);

                    if (seedsMatcher.matches()) {
                        parseSeeds(insertSeedPS, seedsMatcher.group(1));
                    } else if (mapMatcher.matches()) {
                        src = mapMatcher.group(1).trim();
                        dst = mapMatcher.group(2).trim();
                    } else if (line.isEmpty()) {
                        src = "";
                        dst = "";
                    } else {
                        addMapEntry(addToMapPS, src, dst, line);
                    }
                }
            } finally {
                insertSeedPS.executeBatch();
                addToMapPS.executeBatch();
            }
        }
    }

    private void addMapEntry(PreparedStatement ps, String src, String dst, String entryText) throws Exception {
        var items = entryText.trim().split("\\s+");

        ps.setString(1, src);
        ps.setString(2, dst);
        ps.setLong(3, Long.parseLong(items[1].trim()));
        ps.setLong(4, Long.parseLong(items[0].trim()));
        ps.setLong(5, Long.parseLong(items[2].trim()));
        ps.addBatch();
    }

    private void parseSeeds(PreparedStatement ps, String seedsText) throws Exception {
        var seeds = seedsText.trim().split("\\s+");

        for (var seed : seeds) {
            ps.setLong(1, Long.parseLong(seed));
            ps.addBatch();
        }
    }
}
