package y2020.day12;

public class Part2 extends Solver {
    private int wpX;
    private int wpY;

    protected void north(int value) {
        wpY += value;
    }

    protected void south(int value) {
        wpY -= value;
    }

    protected void east(int value) {
        wpX += value;
    }

    protected void west(int value) {
        wpX -= value;
    }

    private void rotate(int count) {
        if (count == 1) {
            var tmp = wpX;

            wpX = wpY;
            wpY = -tmp;
        } else if (count == 2) {
            wpX = -wpX;
            wpY = -wpY;
        } else if (count == 3) {
            var tmp = wpX;

            wpX = -wpY;
            wpY = tmp;
        }
    }

    protected void left(int value) {
        var turns = value / 90;

        rotate(4 - turns);
    }

    protected void right(int value) {
        var turns = value / 90;

        rotate(turns);
    }

    protected void forward(int value) {
        x += wpX * value;
        y += wpY * value;
    }

    public long solve(Instruction[] instrs) {
        wpX = 10;
        wpY = 1;

        return super.solve(instrs);
    }

    public static void main(String[] args) {
        var solver = new Part2();
        var answer = solver.solve(Input.puzzle);

        System.out.println(answer);
    }
}
