package aoc.y2019.day22;

import aoc.utils.Problem;

public class Part2 extends Problem<Long> {
    private Parser parser;

    public Part2(String fileName, long exp) {
        super(exp);

        parser = new Parser(fileName);
    }

    @Override
    public Long run() {
        var shuffler = parser.parse();
        var size = 119315717514047L;
        var iters = 101741582076661L;

        var ndx = 0L;
        // for (long i = 0; i < 100000; i += 1) {
        for (long i = 0; i < 1; i += 1) {
            ndx = shuffler.apply(size, ndx);
            System.out.println(ndx);
            if (ndx == 805) {
                System.out.println("FOUND IT " + i);
            }
        }

        return 0L;
    }
}
