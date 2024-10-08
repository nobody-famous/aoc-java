package aoc.y2019.day3;

import java.util.ArrayList;
import java.util.List;

import aoc.utils.geometry.Line;
import aoc.utils.geometry.Point;

public class Parser extends aoc.utils.Parser<Wire[]> {
    private List<Point> toDeltas(String[] parts) {
        var deltas = new ArrayList<Point>();

        for (var part : parts) {
            var dir = part.charAt(0);
            var dist = Integer.parseInt(part.substring(1));

            var pt = switch (dir) {
                case 'R' -> new Point(dist, 0);
                case 'L' -> new Point(-dist, 0);
                case 'U' -> new Point(0, dist);
                case 'D' -> new Point(0, -dist);
                default -> throw new RuntimeException("Unhandled direction: " + dir);
            };

            deltas.add(pt);
        }

        return deltas;
    }

    private Wire toWire(List<Point> deltas) {
        var wire = new Wire();
        var prev = new Point(0, 0);

        for (var delta : deltas) {
            var newPt = new Point(prev.x + delta.x, prev.y + delta.y);

            wire.addLine(new Line(prev, newPt));

            prev = newPt;
        }

        return wire;
    }

    private Wire parseLine(String line) {
        var parts = line.split(",");
        var deltas = toDeltas(parts);

        return toWire(deltas);
    }

    @Override
    public Wire[] parse(List<String> lines) {
        try {
            var wires = new Wire[2];

            wires[0] = parseLine(lines.get(0));
            wires[1] = parseLine(lines.get(1));

            return wires;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
