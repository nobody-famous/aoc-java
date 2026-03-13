package aoc.y2020.day8;

import java.util.List;

public class Parser implements aoc.utils.Parser<List<Instruction>> {
    @Override
    public List<Instruction> parse(List<String> lines) {
        return lines.stream().map(Parser::parseLine).toList();
    }

    private static Instruction parseLine(String line) {
        var parts = line.split(" ");
        var op = parts[0].trim();
        var arg = Integer.parseInt(parts[1].trim());

        return new Instruction(op, arg);
    }
}
