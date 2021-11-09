package aoc.y2019.day17;

import java.util.ArrayList;
import java.util.List;

public class PathSplitter {
    private List<Movement> path;

    public PathSplitter(List<Movement> path) {
        this.path = path;
    }

    public PathParts split() {
        var opts = buildOptions(path);

        return traverse(opts, 0, new PathParts(null, null, null, null));
    }

    private PathParts updateParts(PathParts curParts, String opt) {
        var main = curParts.main();
        var A = curParts.A();
        var B = curParts.B();
        var C = curParts.C();

        if (A == null) {
            return new PathParts("A", opt, null, null);
        } else if (opt.equals(A)) {
            return new PathParts(main + ",A", A, B, C);
        }

        if (B == null) {
            return new PathParts(main + ",B", A, opt, null);
        } else if (opt.equals(B)) {
            return new PathParts(main + ",B", A, B, C);
        }

        if (C == null) {
            return new PathParts(main + ",C", A, B, opt);
        } else if (opt.equals(C)) {
            return new PathParts(main + ",C", A, B, C);
        }

        return null;
    }

    private PathParts traverse(List<List<String>> options, int optNdx, PathParts curParts) {
        if (optNdx == options.size()) {
            return curParts;
        }

        var curOpts = options.get(optNdx);

        for (var ndx = 0; ndx < curOpts.size(); ndx += 1) {
            var opt = curOpts.get(ndx);
            var parts = updateParts(curParts, opt);

            if (parts == null) {
                continue;
            }

            parts = traverse(options, optNdx + ndx + 1, parts);
            if (parts != null) {
                return parts;
            }
        }

        return null;
    }

    private String movementToOpt(Movement move) {
        return "" + move.turn() + "," + move.distance();
    }

    private List<String> buildOptions(List<Movement> path, int ndx) {
        var options = new ArrayList<String>();
        var str = new StringBuilder();

        str.append(movementToOpt(path.get(ndx)));
        options.add(str.toString());
        ndx += 1;
        while (ndx < path.size() && str.length() < 20) {
            str.append(",").append(movementToOpt(path.get(ndx)));
            ndx += 1;

            if (str.length() < 20) {
                options.add(str.toString());
            }
        }

        return options;
    }

    private List<List<String>> buildOptions(List<Movement> path) {
        var options = new ArrayList<List<String>>();

        for (var ndx = 0; ndx < path.size(); ndx += 1) {
            options.add(buildOptions(path, ndx));
        }

        return options;
    }
}
