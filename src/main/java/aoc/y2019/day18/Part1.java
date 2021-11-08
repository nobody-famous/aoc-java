package aoc.y2019.day18;

public class Part1 extends Solver {
    public Part1(String fileName, int exp) {
        super(fileName, exp);
    }

    protected int doWork(Grid grid) {
        var keyMap = buildKeyMap(grid);
        var finder = new PathFinder(grid, keyMap);

        return finder.find();
    }
}
