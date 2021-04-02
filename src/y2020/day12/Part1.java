package y2020.day12;

public class Part1 extends Solver {
    protected void north(int value) {
        y += value;
    }

    protected void south(int value) {
        y -= value;
    }

    protected void east(int value) {
        x += value;
    }

    protected void west(int value) {
        x -= value;
    }

    protected void left(int value) {
        var turns = value / 90;

        dir = (dir + (4 - turns)) % 4;
    }

    protected void right(int value) {
        var turns = value / 90;

        dir = (dir + turns) % 4;
    }

    protected void forward(int value) {
        switch (dir) {
        case 0:
            y += value;
            break;
        case 1:
            x += value;
            break;
        case 2:
            y -= value;
            break;
        case 3:
            x -= value;
            break;
        }
    }

    public static void main(String[] args) {
        var solver = new Part1();
        var answer = solver.solve(Input.puzzle);

        System.out.println(answer);
    }
}
