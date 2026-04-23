package aoc.y2024.day17;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser implements aoc.utils.Parser<Config> {
    private final Pattern regPattern = Pattern.compile("Register (.): (\\d+)");
    private final Matcher regMatcher = regPattern.matcher("");
    private final Pattern progPattern = Pattern.compile("Program: (.*)");
    private final Matcher progMatcher = progPattern.matcher("");

    @Override
    public Config parse(List<String> lines) {
        var regA = 0;
        var regB = 0;
        var regC = 0;
        var prog = List.of(0);

        for (var line : lines) {
            regMatcher.reset(line);
            progMatcher.reset(line);

            if (regMatcher.matches()) {
                var reg = regMatcher.group(1);
                var value = Integer.parseInt(regMatcher.group(2));

                if ("A".equals(reg)) {
                    regA = value;
                } else if ("B".equals(reg)) {
                    regB = value;
                } else if ("C".equals(reg)) {
                    regC = value;
                }
            } else if (progMatcher.matches()) {
                prog = Arrays.stream(progMatcher.group(1).split(","))
                        .map(Integer::parseInt)
                        .toList();
            }
        }

        return new Config(regA, regB, regC, prog);
    }
}
