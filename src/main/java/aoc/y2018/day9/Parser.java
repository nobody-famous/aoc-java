package aoc.y2018.day9;

import java.util.List;
import java.util.regex.Pattern;

public class Parser extends aoc.utils.Parser<Config> {
    @Override
    public Config parse(List<String> lines) {
        try {
            var re = Pattern.compile("(\\d+) players; last marble is worth (\\d+) points");
            var matcher = re.matcher(lines.getFirst());

            if (!matcher.matches()) {
                throw new Exception("Invalid input: " + lines.getFirst());
            }

            return new Config(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
