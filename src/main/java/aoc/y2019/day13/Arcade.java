package aoc.y2019.day13;

import java.util.HashMap;
import java.util.Map;

import aoc.utils.geometry.Point;
import aoc.y2019.intcode.Machine;

public class Arcade implements Machine.IO {
    public static final int EMPTY = 0;
    public static final int WALL = 1;
    public static final int TILE = 2;
    public static final int PADDLE = 3;
    public static final int BALL = 4;

    private static final int READ_X = 0;
    private static final int READ_Y = 1;
    private static final int READ_TILE = 2;
    private static final int READ_SCORE = 3;

    private Machine mach;
    private Map<Point, Integer> screen = new HashMap<>();
    private int readState = READ_X;
    private int xPos = 0;
    private int yPos = 0;

    private int ballX = 0;
    private int paddleX = 0;
    private int score = 0;

    public Arcade(long[] prog) {
        mach = new Machine(prog, this);
    }

    public void addQuarters(int count) {
        mach.set(0, count);
    }

    public int getScore() {
        return score;
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
        if (ballX < paddleX) {
            return -1;
        } else if (ballX > paddleX) {
            return 1;
        } else {
            return 0;
        }
    }

    public void output(long value) {
        switch (readState) {
            case READ_X:
                xPos = (int) value;
                readState = READ_Y;
                break;
            case READ_Y:
                yPos = (int) value;
                readState = xPos == -1 && yPos == 0 ? READ_SCORE : READ_TILE;
                break;
            case READ_TILE:
                readState = READ_X;
                updateTile((int) value);
                screen.put(new Point(xPos, yPos), (int) value);
                break;
            case READ_SCORE:
                readState = READ_X;
                score = (int) value;
                break;
        }
    }

    private void updateTile(int tile) {
        switch (tile) {
            case BALL:
                ballX = xPos;
                break;
            case PADDLE:
                paddleX = xPos;
                break;
            default:
                break;
        }
    }
}
