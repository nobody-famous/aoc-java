package aoc.y2024.day12;

import java.util.List;

public class Part1 extends Solver {
    @Override
    protected int calculatePrice(List<Region> regions) {
        return regions
                .stream()
                .map(r -> r.area() * sumFences(r))
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static int sumFences(Region region) {
        return region.northFences().size()
                + region.southFences().size()
                + region.eastFences().size()
                + region.westFences().size();
    }
}
