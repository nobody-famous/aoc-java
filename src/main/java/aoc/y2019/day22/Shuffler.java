package aoc.y2019.day22;

import java.util.ArrayList;
import java.util.List;

public class Shuffler {
    private List<Technique> techniques = new ArrayList<>();

    public void addStep(Technique tech) {
        this.techniques.add(tech);
    }

    public long apply(long size, long index) {
        for (var tech : techniques) {
            index = tech.apply(size, index);
        }

        return index;
    }
}
