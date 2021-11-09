package aoc.y2019.day18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import aoc.utils.geometry.Point;

public class GraphBuilder {
    private Grid grid;
    private Point start;
    private Point enter = null;
    private int dist = 0;
    private HashMap<Point, GraphNode> nodes = new HashMap<>();
    private HashSet<Point> seen = new HashSet<>();

    public GraphBuilder(Grid grid, Point start) {
        this.grid = grid;
        this.start = start;

    }

    private void visit(List<GraphNode> toVisit, Point pt, GraphNode node) {
        if (seen.contains(pt)) {
            return;
        }

        seen.add(pt);

        if (grid.entrances.contains(pt)) {
            enter = pt;
        }

        if (grid.spaces.contains(pt)) {
            toVisit.add(new GraphNode(pt, enter, dist, node.needKeys, node.hasKeys));
        } else if (grid.keys.containsKey(pt)) {
            var key = grid.keys.get(pt);
            var mask = grid.masks.get(key);
            var newNode = new GraphNode(pt, enter, dist, node.needKeys, node.hasKeys | mask);

            if ((mask & node.needKeys) == 0) {
                nodes.put(pt, newNode);
            }

            toVisit.add(newNode);
        } else if (grid.doors.containsKey(pt)) {
            var door = grid.doors.get(pt);
            var mask = grid.masks.get(door);

            toVisit.add(new GraphNode(pt, enter, dist, node.needKeys | mask, node.hasKeys));
        }
    }

    private List<GraphNode> visit(GraphNode node) {
        var points = new ArrayList<GraphNode>();

        visit(points, new Point(node.pt.x, node.pt.y - 1), node);
        visit(points, new Point(node.pt.x, node.pt.y + 1), node);
        visit(points, new Point(node.pt.x + 1, node.pt.y), node);
        visit(points, new Point(node.pt.x - 1, node.pt.y), node);

        return points;
    }

    private void buildNodes() {
        var needKeys = grid.keys.containsKey(start) ? grid.masks.get(grid.keys.get(start)) : 0;
        var toVisit = Arrays.<GraphNode>asList(new GraphNode(start, enter, 0, needKeys, 0));

        while (toVisit.size() > 0) {
            var neighbors = new ArrayList<GraphNode>();

            dist += 1;
            for (var node : toVisit) {
                var points = visit(node);

                neighbors.addAll(points);
            }

            toVisit = neighbors;
        }
    }

    private void setNodeEntrances() {
        for (var node : nodes.values()) {
            node.enter = enter;
        }
    }

    public HashMap<Point, GraphNode> build() {
        seen.add(start);

        if (grid.entrances.contains(start)) {
            enter = start;
        }

        buildNodes();
        setNodeEntrances();

        return nodes;
    }
}
