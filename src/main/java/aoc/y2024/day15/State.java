package aoc.y2024.day15;

import java.util.ArrayList;
import java.util.List;

import aoc.utils.Grid;

public class State {
    public Grid.Loc robot = new Grid.Loc(0, 0);
    public char[][] grid = new char[][]{};
    public List<Character> moves = new ArrayList<>();

    @Override
    public String toString() {
        return "[grid:" + grid.length + "x" + grid[0].length + ", moves:" + moves + "]";
    }
}
