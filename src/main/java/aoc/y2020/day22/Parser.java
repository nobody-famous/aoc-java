package aoc.y2020.day22;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser implements aoc.utils.Parser<List<Player>> {
    private final Pattern playerPattern = Pattern.compile("Player (\\d+):");
    private final Matcher playerMatcher = playerPattern.matcher("");

    @Override
    public List<Player> parse(List<String> lines) {
        var players = new ArrayList<Player>();
        var id = -1;
        var cards = new ArrayList<Integer>();

        for (var line : lines) {
            if (line.trim().length() == 0) {
                players.add(new Player(id, cards));
                id = -1;
                cards = new ArrayList<Integer>();
                continue;
            }

            playerMatcher.reset(line);

            if (playerMatcher.matches()) {
                id = Integer.parseInt(playerMatcher.group(1));
                continue;
            }

            cards.add(Integer.parseInt(line));
        }

        if (id >= 0) {
            players.add(new Player(id, cards));
        }

        return players;
    }
}
