package y2019.day13;

import java.util.HashMap;
import java.util.Map;

import utils.geometry.Point;
import y2019.intcode.Machine;

public class Arcade implements Machine.IO {
    public static final int EMPTY = 0;
    public static final int WALL = 1;
    public static final int TILE = 2;
    public static final int PADDLE = 3;
    public static final int BALL = 4;

    private static final int READ_X = 0;
    private static final int READ_Y = 1;
    private static final int READ_TILE = 2;

    private Machine mach;
    private Map<Point, Integer> screen = new HashMap<>();
    private int readState = READ_X;
    private int xPos = 0;
    private int yPos = 0;

    public Arcade(long[] prog) {
        mach = new Machine(prog, this);
    }

    public Map<Point, Integer> getScreen() {
        return screen;
    }

    public void run() {
        while (!mach.isHalted()) {
            mach.exec();
        }
    }

    public long input() {
        throw new RuntimeException("INPUT");
    }

    public void output(long value) {
        switch (readState) {
            case READ_X:
                xPos = (int) value;
                readState = READ_Y;
                break;
            case READ_Y:
                yPos = (int) value;
                readState = READ_TILE;
                break;
            case READ_TILE:
                readState = READ_X;
                screen.put(new Point(xPos, yPos), (int) value);
                break;
        }
    }
}
