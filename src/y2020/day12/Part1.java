package y2020.day12;

public class Part1 {
    private int x;
    private int y;
    private int dir;

    private void north(int value) {
        y += value;
    }

    private void south(int value) {
        y -= value;
    }

    private void east(int value) {
        x += value;
    }

    private void west(int value) {
        x -= value;
    }

    private void left(int value) {
        var turns = value / 90;

        dir = (dir + (4 - turns)) % 4;
    }

    private void right(int value) {
        var turns = value / 90;

        dir = (dir + turns) % 4;
    }

    private void forward(int value) {
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

    private void process(Instruction instr) {
        switch (instr.getAction()) {
        case 'N':
            north(instr.getValue());
            break;
        case 'S':
            south(instr.getValue());
            break;
        case 'E':
            east(instr.getValue());
            break;
        case 'W':
            west(instr.getValue());
            break;
        case 'L':
            left(instr.getValue());
            break;
        case 'R':
            right(instr.getValue());
            break;
        case 'F':
            forward(instr.getValue());
            break;
        }
    }

    private long distance() {
        return Math.abs(x) + Math.abs(y);
    }

    public long solve(Instruction[] instrs) {
        x = 0;
        y = 0;
        dir = 1;

        for (var instr : instrs) {
            process(instr);
        }

        return distance();
    }

    public static void main(String[] args) {
        var solver = new Part1();
        var answer = solver.solve(Input.puzzle);

        System.out.println(answer);
    }
}
