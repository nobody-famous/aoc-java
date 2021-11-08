package aoc.y2019.day12;

import java.util.List;

import aoc.utils.geometry.Point3D;

public class Part1 extends Solver<Integer> {
    public Part1(String fileName, int exp) {
        super(fileName, exp);
    }

    private int energy(Point3D pt) {
        return Math.abs(pt.x) + Math.abs(pt.y) + Math.abs(pt.z);
    }

    private int energy(Moon moon) {
        return energy(moon.pos) * energy(moon.vel);
    }

    private int totalEnergy(List<Moon> moons) {
        int total = 0;

        for (var moon : moons) {
            total += energy(moon);
        }

        return total;
    }

    public Integer doWork(List<Moon> moons) {
        for (var loop = 0; loop < 1000; loop += 1) {
            timeStep(moons);
        }

        return totalEnergy(moons);
    }
}
