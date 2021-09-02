package y2019.day11;

import java.util.HashMap;
import java.util.Map;

import utils.geometry.Point;
import y2019.intcode.Machine;

public class Robot implements Machine.IO {
    public static final int COLOR_BLACK = 0;
    public static final int COLOR_WHITE = 1;

    public static final int DIR_UP = 1;
    public static final int DIR_DOWN = 2;
    public static final int DIR_LEFT = 3;
    public static final int DIR_RIGHT = 4;

    private Machine mach;
    private Map<Point, Integer> panels;
    private Point curLoc;
    private boolean outputColor;
    private int dir;

    public Robot(long[] prog, int color) {
        mach = new Machine(prog, this);
        panels = new HashMap<>();
        outputColor = true;
        dir = DIR_UP;
        curLoc = new Point(0, 0);

        panels.put(curLoc, color);
    }

    public void run() {
        while (!mach.isHalted()) {
            mach.exec();
        }
    }

    public Map<Point,Integer> getPanels() {
        return panels;
    }

    public long input() {
        var color = panels.containsKey(curLoc) ? panels.get(curLoc) : COLOR_BLACK;

        return color;
    }

    public void output(long value) {
        if (outputColor) {
            panels.put(curLoc, (int) value);
            outputColor = false;
        } else {
            handleTurn((int) value);
            outputColor = true;
        }
    }

    private void handleTurn(int turn) {
        dir = switch (dir) {
            case DIR_UP -> turn == 0 ? DIR_LEFT : DIR_RIGHT;
            case DIR_DOWN -> turn == 0 ? DIR_RIGHT : DIR_LEFT;
            case DIR_LEFT -> turn == 0 ? DIR_DOWN : DIR_UP;
            case DIR_RIGHT -> turn == 0 ? DIR_UP : DIR_DOWN;
            default -> throw new RuntimeException("Unhandled dir " + dir);
        };

        curLoc = switch (dir) {
            case DIR_UP -> new Point(curLoc.x, curLoc.y - 1);
            case DIR_DOWN -> new Point(curLoc.x, curLoc.y + 1);
            case DIR_LEFT -> new Point(curLoc.x - 1, curLoc.y);
            case DIR_RIGHT -> new Point(curLoc.x + 1, curLoc.y);
            default -> throw new RuntimeException("Unhandled move dir " + dir);
        };
    }
}
