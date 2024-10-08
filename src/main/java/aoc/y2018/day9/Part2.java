package aoc.y2018.day9;

import java.util.List;

import aoc.utils.Problem;

public class Part2 extends Problem<Long> {
    private Parser parser = new Parser();

    public Part2(String fileName, long exp) {
        super(fileName, exp);
    }

    @Override
    public Long run(List<String> lines) {
        var oldConfig = parser.parse(lines);
        var config = new Config(oldConfig.numPlayers(), oldConfig.lastMarble() * 100);
        var state = new State(config.numPlayers(), config.lastMarble());

        for (var count = 0; count < config.lastMarble(); count += 1) {
            state.placeNext();
        }

        return state.highScore();
    }
}
