package y2020.day15;

import java.util.HashMap;

public class Solver {
    public long solve(int[] input, int numRounds) {
        var seen = new int[numRounds];
        var turn = 1;

        for (var item : input) {
            seen[item] = turn;
            turn += 1;
        }

        var current = 0;
        while (turn < numRounds) {
            var firstTime = seen[current] == 0;
            var next = firstTime ? 0 : turn - seen[current];

            seen[current] = turn;
            current = next;

            turn += 1;
        }

        return current;
    }

    public static void main(String[] args) {
        var solver = new Solver();
        var answer = solver.solve(Input.puzzle, 30000000);

        System.out.println(answer);
    }
}
