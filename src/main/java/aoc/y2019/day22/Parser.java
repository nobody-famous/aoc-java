package aoc.y2019.day22;

import java.util.List;

public class Parser extends aoc.utils.Parser<Shuffler> {
    private Technique parseLine(String line) {
        var parts = line.split(" ");

        if (parts.length == 2) {
            return new CutCards(Integer.parseInt(parts[1]));
        } else if ("stack".equals(parts[3])) {
            return new DealStack();
        } else {
            return new DealIncrement(Integer.parseInt(parts[3]));
        }
    }

    private Shuffler parseLines(List<String> lines) {
        var shuffler = new Shuffler();

        for (var line : lines) {
            shuffler.addStep(parseLine(line));
        }

        return shuffler;
    }

    @Override
    public Shuffler parse(List<String> lines) {
        try {
            return parseLines(lines);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
