package aoc.y2024.day16;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

import aoc.utils.AocProblem;
import aoc.utils.Grid;

public abstract class Solver implements AocProblem<Integer> {
    protected static final int NORTH = 0;
    protected static final int SOUTH = 1;
    protected static final int EAST = 2;
    protected static final int WEST = 3;

    protected record Result(int dist, int tiles) {
    }

    protected record EndPoints(Grid.Loc start, Grid.Loc end) {
    }

    private record PathList(Grid.Loc loc, PathList next) {
    }

    private record PathNode(Grid.Loc loc, int dir, PathList path) {
    }

    protected EndPoints findEndPoints(Grid grid) {
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
            if (dists[node.loc().row()][node.loc().col()][EAST] == -1 || dists[node.loc().row()][node.loc().col()][EAST] == turnDist) {
                neighbors.add(new PathNode(node.loc(), EAST, node.path()));
                dists[node.loc().row()][node.loc().col()][EAST] = turnDist;
            }

            if (dists[node.loc().row()][node.loc().col()][WEST] == -1 || dists[node.loc().row()][node.loc().col()][WEST] == turnDist) {
                neighbors.add(new PathNode(node.loc(), WEST, node.path()));
                dists[node.loc().row()][node.loc().col()][WEST] = turnDist;
            }
        } else if (node.dir() == EAST || node.dir() == WEST) {
            if (dists[node.loc().row()][node.loc().col()][NORTH] == -1 || dists[node.loc().row()][node.loc().col()][NORTH] == turnDist) {
                neighbors.add(new PathNode(node.loc(), NORTH, node.path()));
                dists[node.loc().row()][node.loc().col()][NORTH] = turnDist;
            }

            if (dists[node.loc().row()][node.loc().col()][SOUTH] == -1 || dists[node.loc().row()][node.loc().col()][SOUTH] == turnDist) {
                neighbors.add(new PathNode(node.loc(), SOUTH, node.path()));
                dists[node.loc().row()][node.loc().col()][SOUTH] = turnDist;
            }
        }

        var nextNode = switch (node.dir()) {
        case NORTH -> new PathNode(new Grid.Loc(node.loc().row() - 1, node.loc().col()), NORTH, new PathList(new Grid.Loc(node.loc().row() - 1, node.loc().col()), node.path()));
        case SOUTH -> new PathNode(new Grid.Loc(node.loc().row() + 1, node.loc().col()), SOUTH, new PathList(new Grid.Loc(node.loc().row() + 1, node.loc().col()), node.path()));
        case EAST -> new PathNode(new Grid.Loc(node.loc().row(), node.loc().col() + 1), EAST, new PathList(new Grid.Loc(node.loc().row(), node.loc().col() + 1), node.path()));
        case WEST -> new PathNode(new Grid.Loc(node.loc().row(), node.loc().col() - 1), WEST, new PathList(new Grid.Loc(node.loc().row(), node.loc().col() - 1), node.path()));
        default -> throw new RuntimeException("Invalid direction " + node.dir());
        };

        var nextDist = dists[nextNode.loc().row()][nextNode.loc().col()][nextNode.dir()];
        if (grid.get(nextNode.loc()) == '.' && (nextDist == -1 || nextDist == moveDist)) {
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

    protected Result shortestDistance(Grid grid, EndPoints endPoints) {
        var startNode = new PathNode(endPoints.start, EAST, new PathList(endPoints.start, null));
        var dists = new int[grid.getRows()][grid.getCols()][4];
        var queue = new PriorityQueue<PathNode>((a, b) -> dists[a.loc().row()][a.loc().col()][a.dir()] > dists[b.loc().row()][b.loc().col()][b.dir()] ? 1 : -1);
        var dist = Integer.MAX_VALUE;
        var paths = new ArrayList<PathList>();

        initDists(dists);

        dists[endPoints.start.row()][endPoints.start.col()][EAST] = 0;
        queue.addAll(getNeighbors(dists, grid, startNode));

        while (!queue.isEmpty()) {
            var node = queue.poll();
            var nodeDist = dists[node.loc().row()][node.loc().col()][node.dir()];
            var neighbors = getNeighbors(dists, grid, node);

            if (node.loc().equals(endPoints.end()) && nodeDist <= dist) {
                dist = nodeDist;
                paths.add(node.path());
            }

            queue.addAll(neighbors);
        }

        var tiles = new HashSet<Grid.Loc>();
        for (var path : paths) {
            for (var entry = path; entry != null; entry = entry.next) {
                tiles.add(entry.loc());
            }
        }

        return new Result(dist, tiles.size());
    }
}
