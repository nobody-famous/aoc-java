package y2020.day10;

public class Part2 extends Solver {
    public long solve(int[] input) {
        var adapters = addAdapters(input);

        return 0;
    }

    public static void main(String[] args) {
        var solver = new Part2();
        var answer = solver.solve(Input.sample1);

        System.out.println(answer);
    }
}

/*
(0), 1, 4, 5, 6, 7, 10, 11, 12, 15, 16, 19, (22)
0 -> 1
1 -> 4
4 -> 5, 6, 7
5 -> 6, 7
6 -> 7
7 -> 10
10 -> 11, 12
11 -> 12
12 -> 15
15 -> 16
16 -> 19
19 -> 22
*/