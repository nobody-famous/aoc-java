package aoc.y2019.day12;

import java.util.List;

import aoc.utils.geometry.Point3D;

public class Part1 extends Solver {
    private int energy(Point3D pt) {
        return Math.abs(pt.x) + Math.abs(pt.y) + Math.abs(pt.z);
    }

    private int energy(Moon moon) {
        return energy(moon.pos) * energy(moon.vel);
    }

    private long totalEnergy(List<Moon> moons) {
        long total = 0L;

        for (var moon : moons) {
            total += energy(moon);
        }

        return total;
    }

    public long doWork(List<Moon> moons) {
        for (var loop = 0; loop < 1000; loop += 1) {
            timeStep(moons);
        }

        return totalEnergy(moons);
    }
}
