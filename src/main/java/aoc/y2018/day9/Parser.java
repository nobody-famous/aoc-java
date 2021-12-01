package aoc.y2018.day9;

import java.util.regex.Pattern;

public class Parser extends aoc.utils.Parser<Config> {
    public Parser(String fileName) {
        super(fileName);
    }

    @Override
    public Config parse() {
        try {
            var lines = readLines();
            var re = Pattern.compile("(\\d+) players; last marble is worth (\\d+) points");
            var matcher = re.matcher(lines.get(0));

            if (!matcher.matches()) {
                throw new Exception("Invalid input: " + lines.get(0));
            }

            return new Config(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
