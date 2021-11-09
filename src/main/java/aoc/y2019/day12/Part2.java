package aoc.y2019.day12;

import java.util.ArrayList;
import java.util.List;

import aoc.utils.geometry.Point3D;

public class Part2 extends Solver<Long> {
    public Part2(String fileName, long exp) {
        super(fileName, exp);
    }

    private void updateLoops(List<MoonLoops> loops, List<Moon> moons) {
        for (var ndx = 0; ndx < moons.size(); ndx += 1) {
            loops.get(ndx).insert(moons.get(ndx).pos);
        }
    }

    private boolean allDone(List<MoonLoops> loops) {
        for (var loop : loops) {
            if (!loop.hasAll()) {
                return false;
            }
        }

        return true;
    }

    private Point3D finalLoops(List<MoonLoops> loops) {
        var pt = new Point3D(0, 0, 0);

        for (var loop : loops) {
            var counts = loop.getCounts();

            if (counts.x > pt.x) {
                pt.x = counts.x;
            }

            if (counts.y > pt.y) {
                pt.y = counts.y;
            }

            if (counts.z > pt.z) {
                pt.z = counts.z;
            }
        }

        return pt;
    }

    private long[] gcd_reduce(long big, long small) {
        var result = big - small;

        while (result > small) {
            result -= small;
        }

        return new long[] { small, result };
    }

    private long gcd(long n1, long n2) {
        var big = n1 > n2 ? n1 : n2;
        var small = n1 > n2 ? n2 : n1;
        var result = small;

        while (small > 0) {
            result = small;

            var reduced = gcd_reduce(big, small);
            big = reduced[0];
            small = reduced[1];
        }

        return result;
    }

    private long lcm(long n1, long n2) {
        return (n1 * n2) / gcd(n1, n2);
    }

    public Long doWork(List<Moon> moons) {
        var loops = new ArrayList<MoonLoops>();

        for (var n = 0; n < moons.size(); n += 1) {
            loops.add(new MoonLoops());
        }

        while (!allDone(loops)) {
            updateLoops(loops, moons);
            timeStep(moons);
        }

        var pt = finalLoops(loops);

        return lcm(lcm(pt.x, pt.y), pt.z);
    }
}
