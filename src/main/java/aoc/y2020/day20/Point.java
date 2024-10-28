package aoc.y2020.day20;

public record Point(int row, int col) {

    public String toString() {
        return "(" + row + "," + col + ")";
    }
}
