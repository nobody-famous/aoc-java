package aoc.y2018.day9;

import java.util.List;

import aoc.utils.LongProblem;

public class Part1 extends LongProblem {
    private final Parser parser = new Parser();

    @Override
    public long solve(List<String> lines) {
        var config = parser.parse(lines);
        var state = new State(config.numPlayers(), config.lastMarble());

        for (var count = 0; count < config.lastMarble(); count += 1) {
            state.placeNext();
        }

        return state.highScore();
    }
}
