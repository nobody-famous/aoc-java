package aoc.y2018.day9;

import java.util.List;

import aoc.utils.Problem;

public class Part1 extends Problem<Long> {
    private Parser parser = new Parser();

    public Part1(String fileName, long exp) {
        super(fileName, exp);
    }

    @Override
    public Long run(List<String> lines) {
        var config = parser.parse(lines);
        var state = new State(config.numPlayers(), config.lastMarble());

        for (var count = 0; count < config.lastMarble(); count += 1) {
            state.placeNext();
        }

        return state.highScore();
    }
}
