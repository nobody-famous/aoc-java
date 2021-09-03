package y2019.day12;

import java.util.List;

public class Part2 extends Solver<Long> {
    public Part2(String fileName, long exp) {
        super(fileName, exp);
    }

    public Long doWork(List<Moon> moons) {
        for (var loop = 0; loop < 100; loop += 1) {
            timeStep(moons);
            System.out.println(moons.get(0).pos);
        }
        return 0L;
    }
}
