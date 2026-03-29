package aoc.y2024.day15;

import java.util.Objects;

public class Cell {
    public int row;
    public int col;
    public int width;

    public Cell(int row, int col) {
        this(row, col, 1);
    }

    public Cell(int row, int col, int width) {
        this.row = row;
        this.col = col;
        this.width = width;
    }

    public boolean includes(int row, int col) {
        return row == this.row
                && col >= this.col && col <= this.col + width - 1;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Cell them) && them.row == row && them.col == col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

    @Override
    public String toString() {
        return "[" + row + "," + col + "x" + width + "]";
    }
}
