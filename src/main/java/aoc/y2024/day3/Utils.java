package aoc.y2024.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface Utils {
    record MultiplyNumbers(int x, int y) {
    }

    interface MatchFound {
        void matchFound(Matcher matcher);
    }

    static List<MultiplyNumbers> parse(String line, Pattern pattern, MatchFound cb) {
        var numbers = new ArrayList<MultiplyNumbers>();
        var matcher = pattern.matcher(line);

        matcher.reset(line);
        while (matcher.find()) {
            cb.matchFound(matcher);
            numbers.add(new MultiplyNumbers(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2))));
        }

        return numbers;
    }

    static int calculateAnswer(List<Utils.MultiplyNumbers> numbers) {
        var answer = 0;

        for (var item : numbers) {
            answer += item.x() * item.y();
        }

        return answer;
    }
}
