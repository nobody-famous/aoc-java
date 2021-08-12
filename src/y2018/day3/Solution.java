package y2018.day3;

import java.util.List;

import utils.Problem;
import utils.geometry.Point;

public abstract class Solution extends Problem<Integer> {
    private Parser parser;

    protected List<Claim> claims;
    protected int[][] grid;

    public Solution(String fileName, int exp) {
        super(exp);

        parser = new Parser(fileName);
    }

    protected abstract Integer doWork();

    protected Point findMaxPoint(List<Claim> claims) {
        var maxX = 0;
        var maxY = 0;

        for (var claim : claims) {
            var pt = claim.pt;

            maxX = Math.max(maxX, pt.x + claim.w);
            maxY = Math.max(maxY, pt.y + claim.h);
        }

        return new Point(maxX, maxY);
    }

    protected Point findMinPoint(List<Claim> claims) {
        var minX = 0;
        var minY = 0;

        for (var claim : claims) {
            var pt = claim.pt;

            minX = Math.min(minX, pt.x);
            minY = Math.min(minY, pt.y);
        }

        return new Point(minX, minY);
    }

    private int[][] buildGrid(List<Claim> claims) {
        var maxPt = findMaxPoint(claims);
        var grid = new int[maxPt.x][maxPt.y];

        for (var claim : claims) {
            for (var x = claim.pt.x; x < claim.pt.x + claim.w; x += 1) {
                for (var y = claim.pt.y; y < claim.pt.y + claim.h; y += 1) {
                    grid[x][y] += 1;
                }
            }
        }

        return grid;
    }

    @Override
    public Integer run() {
        claims = parser.parse();
        grid = buildGrid(claims);

        return doWork();
    }
}
