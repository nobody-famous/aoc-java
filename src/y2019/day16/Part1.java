package y2019.day16;

import utils.Problem;

public class Part1 extends Problem<Integer> {
    private Parser parser;

    public Part1(String fileName, int exp) {
        super(exp);

        parser = new Parser(fileName);
    }

    public Integer run() {
        var nums = parser.parse();

        System.out.println(nums);

        return 0;
    }
}
