package y2020.day13;

public class Part1 {
    public long solve(Notes input) {
        var min = Long.MAX_VALUE;
        var busID = 0;

        for (var id : input.getIds()) {
            if (id == null) {
                continue;
            }

            var diff = id - (input.getTimestamp() % id);

            if (diff < min) {
                min = diff;
                busID = id;
            }
        }

        return busID * min;
    }

    public static void main(String[] args) {
        var solver = new Part1();
        var answer = solver.solve(Input.puzzle);

        System.out.println(answer);
    }
}
