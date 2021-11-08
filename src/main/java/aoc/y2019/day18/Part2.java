package aoc.y2019.day18;

import aoc.utils.geometry.Point;

public class Part2 extends Solver {
    public Part2(String fileName, int exp) {
        super(fileName, exp);
    }

    private void updateGrid(Grid grid) {
        var entrance = grid.getEntrances().iterator().next();
        var path = grid.getPath();

        grid.removeEntrance(entrance);
        grid.setMiddle(entrance);

        path.remove(new Point(entrance.x, entrance.y - 1));
        path.remove(new Point(entrance.x, entrance.y + 1));
        path.remove(new Point(entrance.x + 1, entrance.y));
        path.remove(new Point(entrance.x - 1, entrance.y));

        grid.addEntrance(new Point(entrance.x - 1, entrance.y - 1));
        grid.addEntrance(new Point(entrance.x + 1, entrance.y - 1));
        grid.addEntrance(new Point(entrance.x - 1, entrance.y + 1));
        grid.addEntrance(new Point(entrance.x + 1, entrance.y + 1));
    }

    protected int doWork(Grid grid) {
        updateGrid(grid);

        var keyMap = buildKeyMap(grid);
        var finder = new PathFinder(grid, keyMap);

        return finder.find();
    }
}
