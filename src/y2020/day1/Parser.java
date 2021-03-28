package y2020.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static List<Integer> parse(String fileName) throws Exception {
        var ints = new ArrayList<Integer>();

        try (var reader = new BufferedReader(new FileReader(fileName))) {
            parseLines(reader, ints);
        }

        return ints;
    }

    private static void parseLines(BufferedReader reader, List<Integer> out) throws Exception {
        var line = reader.readLine();

        while (line != null) {
            out.add(Integer.parseInt(line));

            line = reader.readLine();
        }
    }
}
