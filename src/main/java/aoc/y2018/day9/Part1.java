package aoc.y2018.day9;

import aoc.utils.Problem;

public class Part1 extends Problem<Long> {
    private Parser parser;

    public Part1(String fileName, long exp) {
        super(exp);

        parser = new Parser(fileName);
    }

    @Override
    public Long run() {
        var config = parser.parse();
        var state = new State(config.numPlayers(), config.lastMarble());

        for (var count = 0; count < config.lastMarble(); count += 1) {
            state.placeNext();
        }

        return state.highScore();
    }
}
