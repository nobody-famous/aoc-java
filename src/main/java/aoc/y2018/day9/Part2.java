package aoc.y2018.day9;

import aoc.utils.Problem;

public class Part2 extends Problem<Long> {
    private Parser parser;

    public Part2(String fileName, long exp) {
        super(exp);

        parser = new Parser(fileName);
    }

    @Override
    public Long run() {
        var oldConfig = parser.parse();
        var config = new Config(oldConfig.numPlayers(), oldConfig.lastMarble() * 100);
        var state = new State(config.numPlayers(), config.lastMarble());

        for (var count = 0; count < config.lastMarble(); count += 1) {
            state.placeNext();
        }

        return state.highScore();
    }
}
