package aoc.y2019.day17;

import java.util.ArrayList;
import java.util.List;

import aoc.utils.Problem;
import aoc.utils.geometry.Point;
import aoc.y2019.intcode.Parser;

public class Part2 extends Problem<Integer> {
    private final Parser parser = new Parser();

    public Part2(String fileName, int exp) {
        super(fileName, exp);
    }

    private boolean hasMove(Grid grid) {
        var pt = grid.getRobot();
        var scaffold = grid.getScaffold();

        return switch (grid.getRobotDir()) {
            case '^', 'v' -> scaffold.contains(new Point(pt.x + 1, pt.y))
                    || scaffold.contains(new Point(pt.x - 1, pt.y));
            case '>', '<' -> scaffold.contains(new Point(pt.x, pt.y + 1))
                    || scaffold.contains(new Point(pt.x, pt.y - 1));
            default -> false;
        };
    }

    private int moveRobot(Grid grid, Point robot) {
        var scaffold = grid.getScaffold();
        var moves = 0;
        var delta = switch (grid.getRobotDir()) {
            case '^' -> new Point(0, -1);
            case 'v' -> new Point(0, 1);
            case '>' -> new Point(1, 0);
            case '<' -> new Point(-1, 0);
            default -> throw new RuntimeException("Unhandled direction: " + grid.getRobotDir());
        };

        var next = new Point(robot.x + delta.x, robot.y + delta.y);
        while (scaffold.contains(next)) {
            moves += 1;

            robot.x = next.x;
            robot.y = next.y;

            next = new Point(robot.x + delta.x, robot.y + delta.y);
        }

        return moves;
    }

    private Movement getMove(Grid grid) {
        var robot = grid.getRobot();
        var turn = getTurn(grid, robot);
        var newDir = switch (grid.getRobotDir()) {
            case '^' -> turn == 'R' ? '>' : '<';
            case 'v' -> turn == 'R' ? '<' : '>';
            case '>' -> turn == 'R' ? 'v' : '^';
            case '<' -> turn == 'R' ? '^' : 'v';
            default -> throw new RuntimeException("Unhandled direction: " + grid.getRobotDir());
        };

        grid.setRobotDir(newDir);

        var moves = moveRobot(grid, robot);

        return new Movement(turn, moves);
    }

    private static char getTurn(Grid grid, Point robot) {
        var scaffold = grid.getScaffold();
        return switch (grid.getRobotDir()) {
            case '^' -> scaffold.contains(new Point(robot.x + 1, robot.y)) ? 'R' : 'L';
            case 'v' -> scaffold.contains(new Point(robot.x - 1, robot.y)) ? 'R' : 'L';
            case '>' -> scaffold.contains(new Point(robot.x, robot.y + 1)) ? 'R' : 'L';
            case '<' -> scaffold.contains(new Point(robot.x, robot.y - 1)) ? 'R' : 'L';
            default -> throw new RuntimeException("Unhandled direction: " + grid.getRobotDir());
        };
    }

    private List<Movement> buildPath(Grid grid) {
        var moves = new ArrayList<Movement>();

        while (hasMove(grid)) {
            moves.add(getMove(grid));
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

    @Override
    public Integer run(List<String> lines) {
        var prog = parser.parse(lines);
        var ctrl = new Controller(prog);

        ctrl.wakeRobot();

        var output = ctrl.readCamera();
        var grid = Grid.fromCamera(output);
        var path = buildPath(grid);
        var splitter = new PathSplitter(path);
        var parts = splitter.split();

        sendParts(ctrl, parts);
        answerPrompt(ctrl);

        ctrl.readLine();
        ctrl.readCamera();

        return (int) ctrl.readValue();
    }
}
