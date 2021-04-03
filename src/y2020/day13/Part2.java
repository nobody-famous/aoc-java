package y2020.day13;

import java.util.ArrayList;
import java.util.List;

public class Part2 {
    private long value;
    private long step;

    private List<Bus> notesToBuses(Notes input) {
        var buses = new ArrayList<Bus>();
        var offset = 0;

        for (var id : input.getIds()) {
            if (id != null) {
                buses.add(new Bus(id, offset));
            }

            offset += 1;
        }

        return buses;
    }

    private long sumIds(List<Bus> buses, int count) {
        var sum = 1L;

        for (var ndx = 0; ndx < count; ndx += 1) {
            var bus = buses.get(ndx);
            sum *= bus.getId();
        }

        return sum;
    }

    private boolean allMatch(List<Bus> buses, int count) {
        for (var ndx = 1; ndx < count; ndx += 1) {
            var bus = buses.get(ndx);
            var target = value + bus.getOffset();

            if (target % bus.getId() != 0) {
                return false;
            }
        }

        return true;
    }

    private void findNextStep(List<Bus> buses, int count) {
        while (true) {
            value += step;

            if (allMatch(buses, count)) {
                step = sumIds(buses, count);
                return;
            }
        }
    }

    public long solve(Notes input) {
        var buses = notesToBuses(input);

        value = buses.get(0).getId();
        step = value;

        for (var busCount = 2; busCount <= buses.size(); busCount += 1) {
            findNextStep(buses, busCount);
        }

        return value;
    }

    public static void main(String[] args) {
        var solver = new Part2();
        var answer = solver.solve(Input.puzzle);

        System.out.println(answer);
    }
}
