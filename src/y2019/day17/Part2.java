package y2019.day17;

import java.util.ArrayList;
import java.util.List;

import utils.Problem;
import utils.geometry.Point;
import y2019.intcode.Parser;

public class Part2 extends Problem<Integer> {
    private Parser parser;

    public Part2(String fileName, int exp) {
        super(exp);

        parser = new Parser(fileName);
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
        var scaffold = grid.getScaffold();
        var turn = switch (grid.getRobotDir()) {
            case '^' -> scaffold.contains(new Point(robot.x + 1, robot.y)) ? 'R' : 'L';
            case 'v' -> scaffold.contains(new Point(robot.x - 1, robot.y)) ? 'R' : 'L';
            case '>' -> scaffold.contains(new Point(robot.x, robot.y + 1)) ? 'R' : 'L';
            case '<' -> scaffold.contains(new Point(robot.x, robot.y - 1)) ? 'R' : 'L';
            default -> throw new RuntimeException("Unhandled direction: " + grid.getRobotDir());
        };
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

    private List<Movement> buildPath(Grid grid) {
        var moves = new ArrayList<Movement>();

        while (hasMove(grid)) {
            moves.add(getMove(grid));
        }

        return moves;
    }

    public Integer run() {
        var prog = parser.parse();
        var ctrl = new Controller(prog);

        ctrl.wakeRobot();

        var output = ctrl.readCamera();
        for (var line : output) {
            System.out.println(line);
        }
        var grid = Grid.fromCamera(output);
        var path = buildPath(grid);

        System.out.println(path);
        var line = ctrl.readLine();

        System.out.println(line);

        return 0;
    }
}
