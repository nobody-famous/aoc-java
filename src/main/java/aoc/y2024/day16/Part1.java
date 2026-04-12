package aoc.y2024.day16;

import java.util.ArrayList;
import java.util.List;

import aoc.utils.AocProblem;
import aoc.utils.Grid;

public class Part1 implements AocProblem<Integer> {
    private enum Direction {
        NORTH, SOUTH, EAST, WEST
    }

    private record EndPoints(Grid.Loc start, Grid.Loc end) {
    }

    private record PathNode(Grid.Loc loc, Direction dir, int distance) {
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

    private List<PathNode> getNeighbors(Grid grid, PathNode node) {
        return switch (node.dir()) {
        case NORTH -> {
            var nodes = new ArrayList<PathNode>();
            var nextLoc = new Grid.Loc(node.loc().row() - 1, node.loc().col());

            if (grid.get(nextLoc) == '.') {
                nodes.add(new PathNode(nextLoc, Direction.NORTH, node.distance() + 1));
            }

            nodes.add(new PathNode(node.loc(), Direction.EAST, node.distance() + 1000));
            nodes.add(new PathNode(node.loc(), Direction.WEST, node.distance() + 1000));

            yield nodes;
        }
        case SOUTH -> {
            var nodes = new ArrayList<PathNode>();
            var nextLoc = new Grid.Loc(node.loc().row() + 1, node.loc().col());

            if (grid.get(nextLoc) == '.') {
                nodes.add(new PathNode(nextLoc, Direction.SOUTH, node.distance() + 1));
            }

            nodes.add(new PathNode(node.loc(), Direction.EAST, node.distance() + 1000));
            nodes.add(new PathNode(node.loc(), Direction.WEST, node.distance() + 1000));

            yield nodes;
        }
        case EAST -> {
            var nodes = new ArrayList<PathNode>();
            var nextLoc = new Grid.Loc(node.loc().row(), node.loc().col() + 1);

            if (grid.get(nextLoc) == '.') {
                nodes.add(new PathNode(nextLoc, Direction.EAST, node.distance() + 1));
            }

            nodes.add(new PathNode(node.loc(), Direction.NORTH, node.distance() + 1000));
            nodes.add(new PathNode(node.loc(), Direction.SOUTH, node.distance() + 1000));

            yield nodes;
        }
        case WEST -> {
            var nodes = new ArrayList<PathNode>();
            var nextLoc = new Grid.Loc(node.loc().row(), node.loc().col() - 1);

            if (grid.get(nextLoc) == '.') {
                nodes.add(new PathNode(nextLoc, Direction.WEST, node.distance() + 1));
            }

            nodes.add(new PathNode(node.loc(), Direction.NORTH, node.distance() + 1000));
            nodes.add(new PathNode(node.loc(), Direction.SOUTH, node.distance() + 1000));

            yield nodes;
        }
        };
    }

    private void shortestPath(Grid grid, EndPoints endPoints) {
        var startNode = new PathNode(endPoints.start, Direction.EAST, 0);
        var neighbors = getNeighbors(grid, startNode);

        System.out.println("***** NEIGHBORS " + neighbors);
    }

    @Override
    public Integer solve(List<String> lines) {
        var grid = Grid.parse(lines);
        var endPoints = findEndPoints(grid);

        grid.set(endPoints.start, '.');
        grid.set(endPoints.end, '.');

        System.out.println("***** END POINTS " + endPoints);

        shortestPath(grid, endPoints);

        return 0;
    }
}
