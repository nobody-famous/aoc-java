package y2019.day3;

import java.util.ArrayList;
import java.util.List;

import utils.geometry.Line;

public class Wire {
    public List<Line> lines;

    public Wire() {
        lines = new ArrayList<Line>();
    }

    public void addLine(Line line) {
        lines.add(line);
    }
}
