package aoc.y2019.day24;

import java.util.HashSet;

import aoc.utils.Problem;

public class Part1 extends Problem<Integer> {
    private Parser parser;

    public Part1(String fileName, int exp) {
        super(exp);

        parser = new Parser(fileName);
    }

    private int countAdjacent(Grid grid, int x, int y) {
        var count = 0;

        count += grid.get(x - 1, y) == Grid.BUG ? 1 : 0;
        count += grid.get(x + 1, y) == Grid.BUG ? 1 : 0;
        count += grid.get(x, y - 1) == Grid.BUG ? 1 : 0;
        count += grid.get(x, y + 1) == Grid.BUG ? 1 : 0;

        return count;
    }

    private Grid minute(Grid grid) {
        var newGrid = new Grid();

        for (var y = 0; y < Grid.GRID_SIZE; y += 1) {
            for (var x = 0; x < Grid.GRID_SIZE; x += 1) {
                var count = countAdjacent(grid, x, y);

                if (grid.get(x, y) == Grid.BUG) {
                    newGrid.set(x, y, count == 1 ? Grid.BUG : Grid.EMPTY);
                } else {
                    newGrid.set(x, y, count == 1 || count == 2 ? Grid.BUG : Grid.EMPTY);
                }
            }
        }

        return newGrid;
    }

    @Override
    public Integer run() {
        var grid = parser.parse();
        var layouts = new HashSet<Integer>();
        Integer ans = null;

        layouts.add(grid.getRating());

        while (ans == null) {
            grid = minute(grid);

            if (layouts.contains(grid.getRating())) {
                ans = grid.getRating();
            } else {
                layouts.add(grid.getRating());
            }
        }

        return ans;
    }
}
