import utils.Problem;

public class Runner {
    public static Problem[] allDays = new Problem[] { new y2020.day16.Part1(y2020.day16.Input.puzzle),
            new y2020.day16.Part2(y2020.day16.Input.puzzle), };

    public void runAll(Problem[] all) {
        var total = 0L;

        for (var problem : all) {
            var start = System.currentTimeMillis();

            problem.solve();

            var diff = System.currentTimeMillis() - start;

            System.out.println(diff + " " + problem);
            total += diff;
        }

        System.out.println("Total: " + total + " ms");
    }

    public static void main(String[] args) {
        var runner = new Runner();
        // runner.runAll(allDays);

        runner.runAll(new Problem[] { new y2020.day17.Part1(y2020.day17.Input.puzzle) });
    }
}
