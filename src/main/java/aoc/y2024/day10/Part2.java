package aoc.y2024.day10;

import aoc.utils.Grid;
import aoc.utils.geometry.Point;

public class Part2 extends Solver {
    private static class TrailFinder {
        public int countTrails(Grid grid, Point pt) {
            if (grid.get(pt) == TRAIL_END) {
                return 1;
            }

            return findNeighbors(grid, pt, 1)
                    .stream()
                    .map(n -> countTrails(grid, n))
                    .mapToInt(Integer::intValue)
                    .sum();
        }
    }

    @Override
    public int run(Grid grid) {
        var heads = findTrailEnds(grid, TRAIL_HEAD);
        var total = 0;

        for (var head : heads) {
            total += new TrailFinder().countTrails(grid, head);
        }

        return total;
    }
}
