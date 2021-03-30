package y2020.day5;

public class Part2 {
    public int solve(int[] input) {
        var min = Integer.MAX_VALUE;
        var max = Integer.MIN_VALUE;
        var sum = 0;

        for (var n : input) {
            if (n < min) {
                min = n;
            }

            if (n > max) {
                max = n;
            }

            sum += n;
        }

        var rangeSum = 0;
        for (var i = min; i <= max; i += 1) {
            rangeSum += i;
        }

        return rangeSum - sum;
    }

    public static void main(String[] args) {
        var solver = new Part2();
        var answer = solver.solve(Input.puzzle);

        System.out.println(answer);
    }
}
