package aoc.y2019.day24;

import java.util.HashMap;
import java.util.Map;

import aoc.utils.Problem;

public class Part2 extends Problem<Integer> {
    private Parser parser;
    private Map<Integer, Grid> grids = new HashMap<>();
    private Map<Integer, Grid> newGrids;

    public Part2(String fileName, int exp) {
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

    private int countHorRow(Grid grid, int y) {
        var count = 0;

        for (var x = 0; x < Grid.GRID_SIZE; x += 1) {
            if (grid.get(x, y) == Grid.BUG) {
                count += 1;
            }
        }

        return count;
    }

    private int countVertRow(Grid grid, int x) {
        var count = 0;

        for (var y = 0; y < Grid.GRID_SIZE; y += 1) {
            if (grid.get(x, y) == Grid.BUG) {
                count += 1;
            }
        }

        return count;
    }

    private void updateCell(Grid grid, Grid newGrid, int x, int y, int adjacent) {
        if (grid.get(x, y) == Grid.BUG) {
            newGrid.set(x, y, adjacent == 1 ? Grid.BUG : Grid.EMPTY);
        } else {
            newGrid.set(x, y, adjacent == 1 || adjacent == 2 ? Grid.BUG : Grid.EMPTY);
        }
    }

    private void updateInnerCircle(Grid grid, Grid newGrid, Grid center) {
        for (var y = 1; y < Grid.GRID_SIZE - 1; y += 1) {
            for (var x = 1; x < Grid.GRID_SIZE - 1; x += 1) {
                if (x == 2 && y == 2) {
                    continue;
                }

                var adjacent = countAdjacent(grid, x, y);

                if (center != null && x == 2 && y + 1 == 2) {
                    adjacent += countHorRow(center, 0);
                } else if (center != null && x == 2 && y - 1 == 2) {
                    adjacent += countHorRow(center, Grid.GRID_SIZE - 1);
                } else if (center != null && y == 2 && x + 1 == 2) {
                    adjacent += countVertRow(center, 0);
                } else if (center != null && y == 2 && x - 1 == 2) {
                    adjacent += countVertRow(center, Grid.GRID_SIZE - 1);
                }

                updateCell(grid, newGrid, x, y, adjacent);
            }
        }
    }

    private void updateHorRow(Grid grid, Grid newGrid, Grid outer, int y) {
        var outerY = (y == 0) ? 1 : 3;

        for (var x = 0; x < Grid.GRID_SIZE; x += 1) {
            var adjacent = countAdjacent(grid, x, y);

            if (outer != null) {
                adjacent += outer.get(2, outerY) == Grid.BUG ? 1 : 0;

                if (x == 0) {
                    adjacent += outer.get(1, 2) == Grid.BUG ? 1 : 0;
                } else if (x == Grid.GRID_SIZE - 1) {
                    adjacent += outer.get(3, 2) == Grid.BUG ? 1 : 0;
                }
            }

            updateCell(grid, newGrid, x, y, adjacent);
        }
    }

    private void updateVertRow(Grid grid, Grid newGrid, Grid outer, int x) {
        var outerX = (x == 0) ? 1 : 3;

        for (var y = 0; y < Grid.GRID_SIZE; y += 1) {
            var adjacent = countAdjacent(grid, x, y);

            if (outer != null) {
                adjacent += outer.get(outerX, 2) == Grid.BUG ? 1 : 0;

                if (y == 0) {
                    adjacent += outer.get(2, 1) == Grid.BUG ? 1 : 0;
                } else if (y == Grid.GRID_SIZE - 1) {
                    adjacent += outer.get(2, 3) == Grid.BUG ? 1 : 0;
                }
            }

            updateCell(grid, newGrid, x, y, adjacent);
        }
    }

    private void updateOuterCircle(Grid grid, Grid newGrid, Grid outer) {
        updateHorRow(grid, newGrid, outer, 0);
        updateHorRow(grid, newGrid, outer, Grid.GRID_SIZE - 1);

        updateVertRow(grid, newGrid, outer, 0);
        updateVertRow(grid, newGrid, outer, Grid.GRID_SIZE - 1);
    }

    private void updateGrid(int level) {
        var grid = grids.containsKey(level) ? grids.get(level) : new Grid();
        var center = grids.get(level + 1);
        var outer = grids.get(level - 1);

        Grid newGrid = new Grid();

        updateInnerCircle(grid, newGrid, center);
        updateOuterCircle(grid, newGrid, outer);

        if (newGrid.getRating() != 0) {
            newGrids.put(level, newGrid);
        }

        if (grids.containsKey(level) && !newGrids.containsKey(level + 1)) {
            updateGrid(level + 1);
        }

        if (grids.containsKey(level) && !newGrids.containsKey(level - 1)) {
            updateGrid(level - 1);
        }
    }

    private void minute() {
        newGrids = new HashMap<>();

        for (var level : grids.keySet()) {
            updateGrid(level);
        }

        grids = newGrids;
    }

    private int countBugs(Grid grid) {
        var count = 0;
        return count;
    }

    private int countBugs() {
        var count = 0;

        for (var grid : grids.values()) {
            count += countBugs(grid);
        }

        return count;
    }

    @Override
    public Integer run() {
        var grid = parser.parse();

        grids.put(0, grid);

        for (var loop = 0; loop < 10; loop += 1) {
            minute();
        }

        for (var entry : grids.entrySet()) {
            System.out.println("Level " + entry.getKey());
            System.out.println(entry.getValue());
        }

        return 0;
    }
}
