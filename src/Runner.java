import utils.Problem;

public class Runner {
    public static Problem[] allDays = new Problem[] { new y2020.day1.Part1(y2020.day1.Input.puzzle),
            new y2020.day1.Part2(y2020.day1.Input.puzzle), new y2020.day2.Part1(y2020.day2.Input.puzzle),
            new y2020.day2.Part2(y2020.day2.Input.puzzle), new y2020.day3.Part1(y2020.day3.Input.puzzle),
            new y2020.day3.Part2(y2020.day3.Input.puzzle), new y2020.day4.Part1(y2020.day4.Input.puzzle),
            new y2020.day4.Part2(y2020.day4.Input.puzzle), new y2020.day5.Part1(y2020.day5.Input.puzzle),
            new y2020.day5.Part2(y2020.day5.Input.puzzle), new y2020.day6.Part1(y2020.day6.Input.puzzle),
            new y2020.day6.Part2(y2020.day6.Input.puzzle), new y2020.day7.Part1(y2020.day7.Input.puzzle),
            new y2020.day7.Part2(y2020.day7.Input.puzzle), new y2020.day8.Part1(y2020.day8.Input.puzzle),
            new y2020.day8.Part2(y2020.day8.Input.puzzle), new y2020.day9.Part1(y2020.day9.Input.puzzle),
            new y2020.day9.Part2(y2020.day9.Input.puzzle), new y2020.day10.Part1(y2020.day10.Input.puzzle),
            new y2020.day10.Part2(y2020.day10.Input.puzzle), new y2020.day11.Part1(y2020.day11.Input.puzzle),
            new y2020.day11.Part2(y2020.day11.Input.puzzle), new y2020.day12.Part1(y2020.day12.Input.puzzle),
            new y2020.day12.Part2(y2020.day12.Input.puzzle), new y2020.day13.Part1(y2020.day13.Input.puzzle),
            new y2020.day13.Part2(y2020.day13.Input.puzzle), new y2020.day14.Part1(y2020.day14.Input.puzzle),
            new y2020.day14.Part2(y2020.day14.Input.puzzle), new y2020.day15.Part1(y2020.day15.Input.puzzle),
            new y2020.day15.Part2(y2020.day15.Input.puzzle), new y2020.day16.Part1(y2020.day16.Input.puzzle),
            new y2020.day16.Part2(y2020.day16.Input.puzzle), new y2020.day17.Part1(y2020.day17.Input.puzzle),
            new y2020.day17.Part2(y2020.day17.Input.puzzle), new y2020.day18.Part1(y2020.day18.Input.puzzle),
            new y2020.day18.Part2(y2020.day18.Input.puzzle), new y2020.day19.Part1(y2020.day19.Input.puzzle),
            new y2020.day19.Part2(y2020.day19.Input.puzzle), new y2020.day20.Part1(y2020.day20.Input.puzzle),
            new y2020.day20.Part2(y2020.day20.Input.puzzle), new y2020.day21.Part1(y2020.day21.Input.puzzle),
            new y2020.day21.Part2(y2020.day21.Input.puzzle), new y2020.day22.Part1(y2020.day22.Input.puzzle),
            new y2020.day22.Part2(y2020.day22.Input.puzzle), new y2020.day23.Part1(y2020.day23.Input.puzzle),
            new y2020.day23.Part2(y2020.day23.Input.puzzle), new y2020.day24.Part1(y2020.day24.Input.puzzle),
            new y2020.day24.Part2(y2020.day24.Input.puzzle) };

    public void runAll(Problem[] all) {
        var total = 0L;

        for (var problem : all) {
            var start = System.currentTimeMillis();

            var answer = problem.solve();

            var diff = System.currentTimeMillis() - start;

            System.out.println(diff + " " + problem + " " + answer);
            total += diff;
        }

        System.out.println("Total: " + total + " ms");
    }

    public static void main(String[] args) {
        var runner = new Runner();
        runner.runAll(allDays);

        // runner.runAll(new Problem[] { new y2020.day24.Part2(y2020.day24.Input.puzzle) });
    }
}
