package y2020.day1;

public abstract class Solver {
    protected abstract int[] solve(Integer[] input, int target);

    protected long product(int[] entries) {
        if (entries.length == 0) {
            return 0;
        }

        var answer = 1;

        for (var entry : entries) {
            answer *= entry;
        }

        return answer;
    }

    public long run(String fileName) throws Exception {
        var input = Parser.parse(fileName);
        var target = 2020;

        if (input.size() == 0) {
            throw new Exception("No input");
        }

        var ints = input.toArray(new Integer[input.size()]);
        var entries = solve(ints, target);

        if (entries == null) {
            throw new Exception("No solution found");
        }

        return product(entries);
    }
}
