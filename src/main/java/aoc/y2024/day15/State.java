package aoc.y2024.day15;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class State {
    public Cell robot = new Cell(0, 0);
    public Set<Cell> boxes = new HashSet<>();
    public Set<Cell> walls = new HashSet<>();
    public List<Character> moves = new ArrayList<>();

    @Override
    public String toString() {
        return "[robot:" + robot + ", boxes:" + boxes + ", walls:" + walls + ", moves:" + moves + "]";
    }
}
