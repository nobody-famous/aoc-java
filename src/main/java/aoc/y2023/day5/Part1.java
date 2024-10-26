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

    public Part1(String fileName, int exp) {
        super(fileName, exp);
    }

    @Override
    public Integer run(Connection conn, List<String> lines) {
        try {
            clearTables(conn);
            parseLines(conn, lines);
            return 0;
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
        ps.setInt(3, Integer.parseInt(items[0].trim()));
        ps.setInt(4, Integer.parseInt(items[1].trim()));
        ps.setInt(5, Integer.parseInt(items[2].trim()));
        ps.addBatch();
    }

    private void parseSeeds(PreparedStatement ps, String seedsText) throws Exception {
        var seeds = seedsText.trim().split("\\s+");

        for (var seed : seeds) {
            ps.setInt(1, Integer.parseInt(seed));
            ps.addBatch();
        }
    }
}
