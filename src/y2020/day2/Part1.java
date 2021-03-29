package y2020.day2;

public class Part1 extends Solver {
    private int countLetter(char letter, String pw) {
        int count = 0;

        for (var ch : pw.toCharArray()) {
            if (ch == letter) {
                count += 1;
            }
        }

        return count;
    }

    protected boolean validate(DBEntry entry) {
        var policy = entry.getPolicy();
        var count = countLetter(policy.getLetter(), entry.getPassword());

        return count >= policy.getLow() && count <= policy.getHigh();
    }

    public static void main(String[] args) {
        var solver = new Part1();
        var answer = solver.run(Input.puzzle);

        System.out.println(answer);
    }
}
