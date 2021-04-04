package y2020.day15;

import java.util.HashMap;

public class Solver {
    public long solve(long[] input, long numRounds) {
        var seen = new HashMap<Long, Long>();
        var current = 0L;
        var turn = 1L;

        for (var item : input) {
            seen.put(item, turn);
            turn += 1;
        }

        current = 0L;
        var start = System.currentTimeMillis();
        while (turn < numRounds) {
            var firstTime = !seen.containsKey(current);
            var next = firstTime ? 0 : turn - seen.get(current);

            seen.put(current, turn);
            current = next;

            turn += 1;
        }

        System.out.println("Took " + (System.currentTimeMillis() - start) + "ms");
        return current;
    }

    public static void main(String[] args) {
        var solver = new Solver();
        var answer = solver.solve(Input.puzzle, 30000000);

        System.out.println(answer);
    }
}
