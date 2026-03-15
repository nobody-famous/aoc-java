package aoc.y2020.day12;

import java.util.List;

public class Parser implements aoc.utils.Parser<List<Instruction>> {
    @Override
    public List<Instruction> parse(List<String> lines) {
        return lines.stream().map(Parser::parseLine).toList();
    }

    private static Instruction parseLine(String line) {
        var action = line.charAt(0);
        var value = Integer.parseInt(line.substring(1));

        return new Instruction(action, value);
    }
}
