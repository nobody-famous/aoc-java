package aoc.y2024.day12;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import aoc.utils.Grid;

public class Part2 extends Solver {
    private record RegionData(int area, Map<Integer, List<Integer>> north, Map<Integer, List<Integer>> south, Map<Integer, List<Integer>> east, Map<Integer, List<Integer>> west) {
    }

    @Override
    protected int calculatePrice(List<Region> regions) {
        return regions
                .stream()
                .map(Part2::createData)
                .map(d -> d.area * countFences(d))
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static void sortLists(RegionData region) {
        region.north.values().forEach(list -> list.sort(Integer::compareTo));
        region.south.values().forEach(list -> list.sort(Integer::compareTo));
        region.east.values().forEach(list -> list.sort(Integer::compareTo));
        region.west.values().forEach(list -> list.sort(Integer::compareTo));
    }

    private static int countFences(RegionData data) {
        sortLists(data);

        var count = sumValues(data.north())
                + sumValues(data.south())
                + sumValues(data.east())
                + sumValues(data.west());

        return count;
    }

    private static int sumValues(Map<Integer, List<Integer>> data) {
        return data
                .values()
                .stream()
                .map(Part2::countConnected)
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static int countConnected(List<Integer> data) {
        var total = 1;

        for (var index = 1; index < data.size(); index++) {
            if (data.get(index) != data.get(index - 1) + 1) {
                total++;
            }
        }

        return total;
    }

    private static RegionData createData(Region region) {
        return new RegionData(
                region.area(),
                region.northFences()
                        .stream()
                        .collect(Collectors.groupingBy(Grid.Loc::row, Collectors.mapping(Grid.Loc::col, Collectors.toList()))),
                region.southFences()
                        .stream()
                        .collect(Collectors.groupingBy(Grid.Loc::row, Collectors.mapping(Grid.Loc::col, Collectors.toList()))),
                region.eastFences()
                        .stream()
                        .collect(Collectors.groupingBy(Grid.Loc::col, Collectors.mapping(Grid.Loc::row, Collectors.toList()))),
                region.westFences()
                        .stream()
                        .collect(Collectors.groupingBy(Grid.Loc::col, Collectors.mapping(Grid.Loc::row, Collectors.toList()))));
    }
}
