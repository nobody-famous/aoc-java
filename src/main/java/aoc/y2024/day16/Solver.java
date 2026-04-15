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

    private record PathNode(Grid.Loc loc, int dir) {
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

    private void updateNode(Grid grid, Grid.Loc loc, Grid.Loc from, int dir, int[][] dists, List<PathNode> neighbors, int targetDist) {
        if (grid.get(loc) != '.' || (dists[loc.row()][loc.col()] != -1 && dists[loc.row()][loc.col()] != targetDist)) {
            return;
        }

        neighbors.add(new PathNode(loc, dir));
        dists[loc.row()][loc.col()] = targetDist;
    }

    private List<PathNode> getNeighbors(int[][] dists, Grid grid, PathNode node) {
        var neighbors = new ArrayList<PathNode>();
        var curDist = dists[node.loc().row()][node.loc().col()];
        var turnDist = curDist + 1001;
        var moveDist = curDist + 1;

        if (node.dir() == NORTH || node.dir() == SOUTH) {
            updateNode(grid, new Grid.Loc(node.loc().row(), node.loc().col() + 1), node.loc(), EAST, dists, neighbors, turnDist);
            updateNode(grid, new Grid.Loc(node.loc().row(), node.loc().col() - 1), node.loc(), WEST, dists, neighbors, turnDist);
        } else if (node.dir() == EAST || node.dir() == WEST) {
            updateNode(grid, new Grid.Loc(node.loc().row() + 1, node.loc().col()), node.loc(), SOUTH, dists, neighbors, turnDist);
            updateNode(grid, new Grid.Loc(node.loc().row() - 1, node.loc().col()), node.loc(), NORTH, dists, neighbors, turnDist);
        }

        var nextNode = switch (node.dir()) {
        case NORTH -> new PathNode(new Grid.Loc(node.loc().row() - 1, node.loc().col()), NORTH);
        case SOUTH -> new PathNode(new Grid.Loc(node.loc().row() + 1, node.loc().col()), SOUTH);
        case EAST -> new PathNode(new Grid.Loc(node.loc().row(), node.loc().col() + 1), EAST);
        case WEST -> new PathNode(new Grid.Loc(node.loc().row(), node.loc().col() - 1), WEST);
        default -> throw new RuntimeException("Invalid direction " + node.dir());
        };

        updateNode(grid, nextNode.loc(), node.loc(), node.dir(), dists, neighbors, moveDist);

        return neighbors;
    }

    private void initDists(int[][] dists) {
        for (var row = 0; row < dists.length; row++) {
            for (var col = 0; col < dists[row].length; col++) {
                dists[row][col] = -1;
            }
        }
    }

    protected Result shortestDistance(Grid grid, EndPoints endPoints) {
        var startNode = new PathNode(endPoints.start, EAST);
        var dists = new int[grid.getRows()][grid.getCols()];
        var queue = new PriorityQueue<PathNode>((a, b) -> dists[a.loc().row()][a.loc().col()] > dists[b.loc().row()][b.loc().col()] ? 1 : -1);
        var dist = Integer.MAX_VALUE;

        initDists(dists);

        dists[endPoints.start.row()][endPoints.start.col()] = 0;
        queue.addAll(getNeighbors(dists, grid, startNode));

        while (!queue.isEmpty()) {
            var node = queue.poll();
            var nodeDist = dists[node.loc().row()][node.loc().col()];
            var neighbors = getNeighbors(dists, grid, node);

            if (node.loc().equals(endPoints.end()) && nodeDist <= dist) {
                dist = nodeDist;
            }

            queue.addAll(neighbors);
        }

        var frontier = new ArrayList<Grid.Loc>();
        var nodes = new HashSet<Grid.Loc>();

        nodes.add(endPoints.start);
        nodes.add(endPoints.end);

        var endToCheck = List.of(
                new Grid.Loc(endPoints.end.row() - 1, endPoints.end.col()),
                new Grid.Loc(endPoints.end.row() + 1, endPoints.end.col()),
                new Grid.Loc(endPoints.end.row(), endPoints.end.col() - 1),
                new Grid.Loc(endPoints.end.row(), endPoints.end.col() + 1));

        for (var neighbor : endToCheck) {
            if (dists[neighbor.row()][neighbor.col()] == dist - 1) {
                frontier.add(neighbor);
                nodes.add(neighbor);
            }
        }

        while (!frontier.isEmpty()) {
            var nextFrontier = new ArrayList<Grid.Loc>();

            for (var node : frontier) {
                var curDist = dists[node.row()][node.col()];
                var toCheck = List.of(
                        new Grid.Loc(node.row() - 1, node.col()),
                        new Grid.Loc(node.row() + 1, node.col()),
                        new Grid.Loc(node.row(), node.col() - 1),
                        new Grid.Loc(node.row(), node.col() + 1));

                for (var neighbor : toCheck) {
                    if (grid.get(neighbor) != '.') {
                        continue;
                    }

                    if (dists[neighbor.row()][neighbor.col()] == curDist - 1 || dists[neighbor.row()][neighbor.col()] == curDist + 1000 - 1 || dists[neighbor.row()][neighbor.col()] == curDist - 1000 - 1) {
                        nextFrontier.add(neighbor);
                        nodes.add(neighbor);
                    }
                }
            }

            frontier = nextFrontier;
        }

        // System.out.println();
        // for (var row = 0; row < dists.length; row++) {
        //     for (var col = 0; col < dists[row].length; col++) {
        //         System.out.print(String.format("%7s", dists[row][col]));
        //     }
        //     System.out.println();
        // }
        // System.out.println();

        for (var node : nodes.stream().sorted((a, b) -> {
            if (a.row() > b.row()) {
                return 1;
            } else if (a.row() < b.row()) {
                return -1;
            } else if (a.col() > b.col()) {
                return 1;
            } else if (a.col() < b.col()) {
                return -1;
            } else {
                return 0;
            }
        }).toList()) {
            System.out.println(node);
        }

        return new Result(dist, nodes.size());
    }
}
