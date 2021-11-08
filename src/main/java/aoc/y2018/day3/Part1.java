package aoc.y2018.day3;

public class Part1 extends Solution {
    public Part1(String fileName, int exp) {
        super(fileName, exp);
    }

    public Integer doWork() {
        var minPt = findMinPoint(claims);
        var count = 0;

        for (var x = minPt.x; x < grid.length; x += 1) {
            for (var y = minPt.y; y < grid[x].length; y += 1) {
                if (grid[x][y] > 1) {
                    count += 1;
                }
            }
        }

        return count;
    }
}
