package aoc.y2019.day12;

import java.util.List;

import aoc.utils.Problem;

public abstract class Solver<T> extends Problem<T> {
    private Parser parser;

    public Solver(String fileName, T exp) {
        super(exp);

        parser = new Parser(fileName);
    }

    public abstract T doWork(List<Moon> moons);

    public T run() {
        var moons = parser.parse();

        return doWork(moons);
    }

    protected void gravity(Moon m1, Moon m2) {
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

    protected void velocity(Moon moon) {
        moon.pos.x += moon.vel.x;
        moon.pos.y += moon.vel.y;
        moon.pos.z += moon.vel.z;
    }

    protected void timeStep(List<Moon> moons) {
        for (var first = 0; first < moons.size() - 1; first += 1) {
            for (var second = first + 1; second < moons.size(); second += 1) {
                gravity(moons.get(first), moons.get(second));
            }
        }

        for (var moon : moons) {
            velocity(moon);
        }
    }
}
