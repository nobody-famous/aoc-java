package y2020.day5;

public class Part1 {
    public int solve(int[] input) {
        int highest = 0;

        for (var n : input) {
            if (n > highest) {
                highest = n;
            }
        }

        return highest;
    }

    public static void main(String[] args) {
        var solver = new Part1();
        var answer = solver.solve(Input.puzzle);

        System.out.println(answer);
    }
}
