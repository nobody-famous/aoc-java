package y2020.day16;

import java.util.ArrayList;
import java.util.List;

public class Part1 extends Solver {
    private long sumValues(List<Long> values) {
        var sum = 0L;

        for (var value : values) {
            sum += value;
        }

        return sum;
    }

    public long solve(Notes input) {
        var invalid = new ArrayList<Long>();

        for (var ticket : input.getNearby()) {
            for (var value : ticket.getValues()) {
                if (!isValid(value, input.getFields())) {
                    invalid.add(value);
                }
            }
        }

        return sumValues(invalid);
    }

    public static void main(String[] args) {
        var solver = new Part1();
        var answer = solver.solve(Input.puzzle);

        System.out.println(answer);
    }
}
