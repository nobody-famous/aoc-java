package aoc.y2018.day3;

public class Part2 extends Solution {
    public Part2(String fileName, int exp) {
        super(fileName, exp);
    }

    private boolean overlaps(Claim claim) {
        for (var x = claim.pt.x; x < claim.pt.x + claim.w; x += 1) {
            for (var y = claim.pt.y; y < claim.pt.y + claim.h; y += 1) {
                if (grid[x][y] > 1) {
                    return true;
                }
            }
        }

        return false;
    }

    public Integer doWork() {
        var id = 0;

        for (var claim : claims) {
            if (!overlaps(claim)) {
                id = claim.id;
                break;
            }
        }

        return id;
    }
}
