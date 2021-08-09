package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public abstract class Parser<T> {
    private String fileName;

    public Parser(String fileName) {
        this.fileName = fileName;
    }

    public abstract T parse();

    protected List<String> readLines() throws Exception {
        try (var reader = new BufferedReader(new FileReader(fileName))) {
            var lines = new ArrayList<String>();
            var line = reader.readLine();

            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }

            return lines;
        }
    }
}
