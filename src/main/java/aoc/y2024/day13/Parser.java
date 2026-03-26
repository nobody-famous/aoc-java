package aoc.y2024.day13;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser implements aoc.utils.Parser<List<MachineData>> {
    private static final Pattern buttonPattern = Pattern.compile("Button (.): X\\+(\\d+), Y\\+(\\d+)");
    private static final Matcher buttonMatcher = buttonPattern.matcher("");
    private static final Pattern prizePattern = Pattern.compile("Prize: X=(\\d+), Y=(\\d+)");
    private static final Matcher prizeMatcher = prizePattern.matcher("");

    @Override
    public List<MachineData> parse(List<String> lines) {
        Movement buttonA = null;
        Movement buttonB = null;
        Movement prize = null;
        var data = new ArrayList<MachineData>();

        for (var line : lines) {
            buttonMatcher.reset(line);
            prizeMatcher.reset(line);

            if ("".equals(line.trim())) {
                data.add(new MachineData(buttonA, buttonB, prize));
                buttonA = null;
                buttonB = null;
                prize = null;
            } else if (buttonMatcher.matches()) {
                var buttonData = new Movement(Long.parseLong(buttonMatcher.group(2)), Long.parseLong(buttonMatcher.group(3)));

                if ("A".equals(buttonMatcher.group(1))) {
                    buttonA = buttonData;
                } else if ("B".equals(buttonMatcher.group(1))) {
                    buttonB = buttonData;
                } else {
                    throw new RuntimeException("Invalid button name: " + buttonMatcher.group(1));
                }
            } else if (prizeMatcher.matches()) {
                prize = new Movement(Long.parseLong(prizeMatcher.group(1)), Long.parseLong(prizeMatcher.group(2)));
            } else {
                throw new RuntimeException("Invalid input: " + line);
            }
        }

        if (buttonA != null) {
            data.add(new MachineData(buttonA, buttonB, prize));
        }

        return data;
    }
}
