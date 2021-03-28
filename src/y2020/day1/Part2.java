package y2020.day1;

public class Part2 extends Solver {
    protected int[] solve(Integer[] input, int target) {
        for (var i = 0; i < input.length; i += 1) {
            var first = input[i];

            for (var j = i; j < input.length; j += 1) {
                var second = input[j];

                for (var k = j; k < input.length; k += 1) {
                    var third = input[k];

                    if (first + second + third == target) {
                        return new int[] { first, second, third };
                    }
                }
            }
        }

        return null;
    }

    public static void main(String[] args) throws Exception {
        var solver = new Part2();
        var answer = solver.run("src/y2020/day1/input.txt");

        System.out.println(answer);
    }
}
