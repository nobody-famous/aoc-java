package aoc.y2019.day18;

import java.util.HashMap;
import java.util.List;

import aoc.utils.AocProblem;
import aoc.utils.geometry.Point;

public abstract class Solver implements AocProblem<Integer> {
    private final Parser parser = new Parser();
    private final HashMap<Point, HashMap<Point, GraphNode>> graph = new HashMap<>();

    private void addToGraph(Grid grid, Point pt) {
        var builder = new GraphBuilder(grid, pt);
        var nodes = builder.build();

        graph.put(pt, nodes);
    }

    @Override
    public Integer solve(List<String> lines) {
        var grid = parser.parse(lines);

        for (var entrance : grid.entrances) {
            addToGraph(grid, entrance);
        }

        for (var key : grid.keys.keySet()) {
            addToGraph(grid, key);
        }

        var walker = new DfsWalker(grid, graph);

        return walker.walk();
    }
}
