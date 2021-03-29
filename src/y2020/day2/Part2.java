package y2020.day2;

public class Part2 extends Solver {
    protected boolean validate(DBEntry entry) {
        var policy = entry.getPolicy();
        var low = policy.getLow();
        var high = policy.getHigh();
        var pw = entry.getPassword();
        var count = 0;

        count += pw.charAt(low - 1) == policy.getLetter() ? 1 : 0;
        count += pw.charAt(high - 1) == policy.getLetter() ? 1 : 0;

        return count == 1;
    }

    public static void main(String[] args) {
        var solver = new Part2();
        var answer = solver.run(Input.puzzle);

        System.out.println(answer);
    }
}
