package aoc.y2019.day17;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import aoc.utils.Grid;
import aoc.utils.IntProblem;
import aoc.utils.geometry.Point;
import aoc.y2019.intcode.Parser;

public class Part2 extends IntProblem {
    private final Parser parser = new Parser();

    private class Robot {
        Point pt;
        char dir;

        Robot(Point pt, char dir) {
            this.pt = pt;
            this.dir = dir;
        }

        int move(Set<Point> scaffold) {
            var moves = 0;
            var delta = switch (dir) {
            case '^' -> new Point(0, -1);
            case 'v' -> new Point(0, 1);
            case '>' -> new Point(1, 0);
            case '<' -> new Point(-1, 0);
            default -> throw new RuntimeException("Unhandled direction: " + dir);
            };

            var next = new Point(pt.x + delta.x, pt.y + delta.y);
            while (scaffold.contains(next)) {
                moves += 1;

                pt.x = next.x;
                pt.y = next.y;

                next = new Point(pt.x + delta.x, pt.y + delta.y);
            }

            return moves;
        }
    }

    private boolean hasMove(Set<Point> scaffold, Robot robot) {
        return switch (robot.dir) {
        case '^', 'v' -> scaffold.contains(new Point(robot.pt.x + 1, robot.pt.y))
                || scaffold.contains(new Point(robot.pt.x - 1, robot.pt.y));
        case '>', '<' -> scaffold.contains(new Point(robot.pt.x, robot.pt.y + 1))
                || scaffold.contains(new Point(robot.pt.x, robot.pt.y - 1));
        default -> false;
        };
    }

    private Movement getMove(Set<Point> scaffold, Robot robot) {
        var turn = getTurn(scaffold, robot);
        var newDir = switch (robot.dir) {
        case '^' -> turn == 'R' ? '>' : '<';
        case 'v' -> turn == 'R' ? '<' : '>';
        case '>' -> turn == 'R' ? 'v' : '^';
        case '<' -> turn == 'R' ? '^' : 'v';
        default -> throw new RuntimeException("Unhandled direction: " + robot.dir);
        };

        robot.dir = newDir;

        var moves = robot.move(scaffold);

        return new Movement(turn, moves);
    }

    private static char getTurn(Set<Point> scaffold, Robot robot) {
        return switch (robot.dir) {
        case '^' -> scaffold.contains(new Point(robot.pt.x + 1, robot.pt.y)) ? 'R' : 'L';
        case 'v' -> scaffold.contains(new Point(robot.pt.x - 1, robot.pt.y)) ? 'R' : 'L';
        case '>' -> scaffold.contains(new Point(robot.pt.x, robot.pt.y + 1)) ? 'R' : 'L';
        case '<' -> scaffold.contains(new Point(robot.pt.x, robot.pt.y - 1)) ? 'R' : 'L';
        default -> throw new RuntimeException("Unhandled direction: " + robot.dir);
        };
    }

    private List<Movement> buildPath(Grid grid, Robot robot) {
        var scaffold = Utils.buildScaffold(grid);
        var moves = new ArrayList<Movement>();

        while (hasMove(scaffold, robot)) {
            moves.add(getMove(scaffold, robot));
        }

        return moves;
    }

    private void sendParts(Controller ctrl, PathParts parts) {
        var sent = 0;

        while (sent < 4) {
            var line = ctrl.readLine();

            switch (line) {
            case "Main:" -> ctrl.writeLine(parts.main());
            case "Function A:" -> ctrl.writeLine(parts.A());
            case "Function B:" -> ctrl.writeLine(parts.B());
            case "Function C:" -> ctrl.writeLine(parts.C());
            default -> throw new RuntimeException("Unhandled line: " + line);
            }

            sent += 1;
        }
    }

    private void answerPrompt(Controller ctrl) {
        var line = ctrl.readLine();

        if (!line.equals("Continuous video feed?")) {
            throw new RuntimeException("Unhandled line: " + line);
        }

        ctrl.writeLine("n");
    }

    private Robot findRobot(Grid grid) {
        for (var row = 0; row < grid.getRows(); row++) {
            for (var col = 0; col < grid.getCols(); col++) {
                var ch = grid.get(row, col);

                switch (ch) {
                case '^':
                case 'v':
                case '<':
                case '>':
                    return new Robot(new Point(col, row), ch);
                }
            }
        }

        throw new RuntimeException("Did not find robot");
    }

    @Override
    public int solve(List<String> lines) {
        var prog = parser.parse(lines);
        var ctrl = new Controller(prog);

        ctrl.wakeRobot();

        var output = ctrl.readCamera();
        var grid = Grid.parse(output);
        var robot = findRobot(grid);
        var path = buildPath(grid, robot);
        var splitter = new PathSplitter(path);
        var parts = splitter.split();

        sendParts(ctrl, parts);
        answerPrompt(ctrl);

        ctrl.readLine();
        ctrl.readCamera();

        return (int) ctrl.readValue();
    }
}
