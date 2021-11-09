package aoc.y2019.day18;

import java.util.HashMap;

import aoc.utils.Problem;
import aoc.utils.geometry.Point;

public class Part1 extends Problem<Integer> {
    private Parser parser;
    private HashMap<Point, HashMap<Point, GraphNode>> graph = new HashMap<>();

    public Part1(String fileName, int exp) {
        super(exp);

        parser = new Parser(fileName);
    }

    private void addToGraph(Grid grid, Point pt) {
        var builder = new GraphBuilder(grid, pt);
        var nodes = builder.build();

        graph.put(pt, nodes);
    }

    public Integer run() {
        var grid = parser.parse();

        for (var entrance : grid.entrances) {
            addToGraph(grid, entrance);
        }

        for (var key : grid.keys.keySet()) {
            addToGraph(grid, key);
        }

        var walker= new DfsWalker(grid, graph);

        return walker.walk();
    }
}
