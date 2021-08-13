package y2018.day4;

import utils.Problem;

public class Part1 extends Problem<Integer> {
    private Parser parser;

    public Part1(String fileName, int exp) {
        super(exp);

        parser = new Parser(fileName);
    }

    @Override
    public Integer run() {
        var records = parser.parse();

        for (var rec : records) {
            System.out.println(rec.date);
        }

        return 0;
    }
}
