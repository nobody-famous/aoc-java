package aoc.y2019.day12;

import java.util.ArrayList;
import java.util.List;

public class Loop {
    private boolean foundLoop;
    private List<Integer> items;

    public Loop() {
        this.foundLoop = false;
        this.items = new ArrayList<>();
    }

    public boolean hasLoop() {
        return foundLoop;
    }

    public int loopSize() {
        return items.size();
    }

    public void insert(int item) {
        if (hasLoop()) {
            return;
        }

        items.add(item);
        checkLoop();
    }

    private void checkLoop() {
        if (items.size() < 2) {
            return;
        }

        for (int forward = 0, backward = items.size() - 1; forward < backward; forward += 1, backward -= 1) {
            if (!items.get(forward).equals(items.get(backward))) {
                return;
            }
        }

        foundLoop = true;
    }
}
