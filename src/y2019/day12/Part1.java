package y2019.day12;

import java.util.List;

import utils.Problem;
import utils.geometry.Point3D;

public class Part1 extends Problem<Integer> {
    private Parser parser;

    public Part1(String fileName, int exp) {
        super(exp);

        parser = new Parser(fileName);
    }

    private void gravity(Moon m1, Moon m2) {
        var dx = 0;
        var dy = 0;
        var dz = 0;

        if (m1.pos.x != m2.pos.x) {
            dx = (m1.pos.x < m2.pos.x) ? 1 : -1;
        }

        if (m1.pos.y != m2.pos.y) {
            dy = (m1.pos.y < m2.pos.y) ? 1 : -1;
        }

        if (m1.pos.z != m2.pos.z) {
            dz = (m1.pos.z < m2.pos.z) ? 1 : -1;
        }

        m1.vel.x += dx;
        m2.vel.x -= dx;

        m1.vel.y += dy;
        m2.vel.y -= dy;

        m1.vel.z += dz;
        m2.vel.z -= dz;
    }

    private void velocity(Moon moon) {
        moon.pos.x += moon.vel.x;
        moon.pos.y += moon.vel.y;
        moon.pos.z += moon.vel.z;
    }

    private void timeStep(List<Moon> moons) {
        for (var first = 0; first < moons.size() - 1; first += 1) {
            for (var second = first + 1; second < moons.size(); second += 1) {
                gravity(moons.get(first), moons.get(second));
            }
        }

        for (var moon : moons) {
            velocity(moon);
        }
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

    public Integer run() {
        var moons = parser.parse();

        for (var loop = 0; loop < 1000; loop += 1) {
            timeStep(moons);
        }

        return totalEnergy(moons);
    }
}
