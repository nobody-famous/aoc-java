package aoc.y2019.day18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aoc.utils.geometry.Point;

public class DfsWalker {
    private Grid grid;
    private HashMap<Point, HashMap<Point, GraphNode>> graph;
    private HashMap<Character, HashMap<Integer, Integer>> below = new HashMap<>();
    private int pathDist = Integer.MAX_VALUE;

    public DfsWalker(Grid grid, HashMap<Point, HashMap<Point, GraphNode>> graph) {
        this.grid = grid;
        this.graph = graph;
    }

    private boolean haveNeededKey(int needKeys, int foundKeys) {
        return (needKeys & foundKeys) == needKeys;
    }

    private boolean alreadyHaveKey(Point pt, int foundKeys) {
        var key = grid.keys.get(pt);
        var mask = grid.masks.get(key);

        return (mask & foundKeys) == mask;
    }

    private List<GraphNode> getCandidates(Map<Point, GraphNode> nodes, int foundKeys) {
        var candidates = new HashMap<Character, GraphNode>();
        var added = new HashMap<Character, Integer>();

        System.out.println("getCandidates");
        for (var entry : nodes.entrySet()) {
            var pt = entry.getKey();
            var node = entry.getValue();

            if (alreadyHaveKey(pt, foundKeys) || !haveNeededKey(node.needKeys, foundKeys)) {
                continue;
            }

            var keyCh = grid.keys.get(pt);

            if (!added.containsKey(keyCh)) {
                System.out.println("Add " + keyCh);
                added.put(keyCh, 0);
            }

            for (var maskEntry : grid.masks.entrySet()) {
                var ch = maskEntry.getKey();
                var mask = maskEntry.getValue();

                if ((mask & node.hasKeys) != 0 && ch >= 'a' && ch <= 'z') {
                    if (!added.containsKey(ch)) {
                        added.put(ch, 0);
                    }
                    added.put(ch, added.get(ch) + 1);
                }
            }

            candidates.put(keyCh, node);
        }

        System.out.println(added);
        for (var entry : added.entrySet()) {
            var ch = entry.getKey();
            var count = entry.getValue();

            if (count > 1) {
                candidates.remove(ch);
            }
        }

        return new ArrayList<GraphNode>(candidates.values());
    }

    private int walk(Map<Point, GraphNode> robots, int keys, List<Character> path) {
        System.out.println("walk " + path);
        if (keys == grid.allMasks) {
            return 0;
        }

        var candidates = new ArrayList<GraphNode>();
        for (var robotPt : robots.keySet()) {
            var nodes = getCandidates(graph.get(robotPt), keys);

            candidates.addAll(nodes);
        }

        var minDist = Integer.MAX_VALUE;

        System.out.print("  ");
        for (var candidate : candidates) {
            System.out.print(candidate.pt + " ");
        }
        System.out.println();

        for (var candidate : candidates) {
            var keyCh = grid.keys.get(candidate.pt);
            var newKeys = keys | candidate.hasKeys;

            if (!below.containsKey(keyCh)) {
                below.put(keyCh, new HashMap<>());
            }

            if (below.get(keyCh).containsKey(keys)) {
                var dist = below.get(keyCh).get(keys) + candidate.dist;

                if (dist < minDist) {
                    minDist = dist;
                }

                continue;
            }

            var newRobots = new HashMap<Point, GraphNode>(robots);
            newRobots.put(candidate.enter, candidate);

            var newPath = new ArrayList<Character>(path);
            newPath.add(grid.keys.get(candidate.pt));

            var belowDist = walk(newRobots, newKeys, newPath);
            below.get(keyCh).put(keys, belowDist);

            var newDist = belowDist + candidate.dist;
            System.out.println("newDist " + newDist + " " + belowDist + " " + candidate.dist + " " + candidate.pt);
            if (newDist < minDist) {
                minDist = newDist;
            }
        }

        System.out.println("Walk done " + minDist);
        return minDist;
    }

    public int walk() {
        var robots = new HashMap<Point, GraphNode>();

        for (var entrance : grid.entrances) {
            robots.put(entrance, new GraphNode(entrance, entrance, 0, 0, 0));
        }

        var path = new ArrayList<Character>();
        pathDist = walk(robots, 0, path);

        return pathDist;
    }
}
