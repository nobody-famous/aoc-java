package aoc.y2024.day16;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import aoc.utils.AocProblem;
import aoc.utils.Grid;

public class Part1 implements AocProblem<Integer> {
    private static final int NORTH = 0;
    private static final int SOUTH = 1;
    private static final int EAST = 2;
    private static final int WEST = 3;

    private record EndPoints(Grid.Loc start, Grid.Loc end) {
    }

    private record PathNode(Grid.Loc loc, int dir) {
    }

    private EndPoints findEndPoints(Grid grid) {
        Grid.Loc start = null;
        Grid.Loc end = null;

        for (var row = 0; row < grid.getRows(); row++) {
            for (var col = 0; col < grid.getCols(); col++) {
                if (grid.get(row, col) == 'S') {
                    start = new Grid.Loc(row, col);
                } else if (grid.get(row, col) == 'E') {
                    end = new Grid.Loc(row, col);
                }
            }
        }

        if (start == null || end == null) {
            throw new RuntimeException("Could not find end points");
        }

        return new EndPoints(start, end);
    }

    private List<PathNode> getNeighbors(int[][][] dists, Grid grid, PathNode node) {
        var neighbors = new ArrayList<PathNode>();
        var curDist = dists[node.loc().row()][node.loc().col()][node.dir()];
        var turnDist = curDist + 1000;
        var moveDist = curDist + 1;

        if (node.dir() == NORTH || node.dir() == SOUTH) {
            if (dists[node.loc().row()][node.loc().col()][EAST] == -1) {
                neighbors.add(new PathNode(node.loc(), EAST));
                dists[node.loc().row()][node.loc().col()][EAST] = turnDist;
            }

            if (dists[node.loc().row()][node.loc().col()][WEST] == -1) {
                neighbors.add(new PathNode(node.loc(), WEST));
                dists[node.loc().row()][node.loc().col()][WEST] = turnDist;
            }
        } else if (node.dir() == EAST || node.dir() == WEST) {
            if (dists[node.loc().row()][node.loc().col()][NORTH] == -1) {
                neighbors.add(new PathNode(node.loc(), NORTH));
                dists[node.loc().row()][node.loc().col()][NORTH] = turnDist;
            }

            if (dists[node.loc().row()][node.loc().col()][SOUTH] == -1) {
                neighbors.add(new PathNode(node.loc(), SOUTH));
                dists[node.loc().row()][node.loc().col()][SOUTH] = turnDist;
            }
        }

        var nextNode = switch (node.dir()) {
        case NORTH -> new PathNode(new Grid.Loc(node.loc().row() - 1, node.loc().col()), NORTH);
        case SOUTH -> new PathNode(new Grid.Loc(node.loc().row() + 1, node.loc().col()), SOUTH);
        case EAST -> new PathNode(new Grid.Loc(node.loc().row(), node.loc().col() + 1), EAST);
        case WEST -> new PathNode(new Grid.Loc(node.loc().row(), node.loc().col() - 1), WEST);
        default -> throw new RuntimeException("Invalid direction " + node.dir());
        };

        if (grid.get(nextNode.loc()) == '.' && dists[nextNode.loc().row()][nextNode.loc().col()][nextNode.dir()] == -1) {
            neighbors.add(nextNode);
            dists[nextNode.loc().row()][nextNode.loc().col()][node.dir()] = moveDist;
        }

        return neighbors;
    }

    private void initDists(int[][][] dists) {
        for (var row = 0; row < dists.length; row++) {
            for (var col = 0; col < dists[row].length; col++) {
                for (var dir = 0; dir < dists[row][col].length; dir++) {
                    dists[row][col][dir] = -1;
                }
            }
        }
    }

    private int shortestDistance(Grid grid, EndPoints endPoints) {
        var startNode = new PathNode(endPoints.start, EAST);
        var dists = new int[grid.getRows()][grid.getCols()][4];
        var queue = new PriorityQueue<PathNode>((a, b) -> dists[a.loc().row()][a.loc().col()][a.dir()] > dists[b.loc().row()][b.loc().col()][b.dir()] ? 1 : -1);

        initDists(dists);

        dists[endPoints.start.row()][endPoints.start.col()][EAST] = 0;

        queue.addAll(getNeighbors(dists, grid, startNode));

        while (!queue.peek().loc().equals(endPoints.end)) {
            var node = queue.poll();
            var neighbors = getNeighbors(dists, grid, node);

            queue.addAll(neighbors);
        }

        var node = queue.peek();

        return node != null && node.loc().equals(endPoints.end)
                ? dists[node.loc().row()][node.loc().col()][node.dir()]
                : 0;
    }

    @Override
    public Integer solve(List<String> lines) {
        var grid = Grid.parse(lines);
        var endPoints = findEndPoints(grid);

        grid.set(endPoints.start, '.');
        grid.set(endPoints.end, '.');

        return shortestDistance(grid, endPoints);
    }
}
