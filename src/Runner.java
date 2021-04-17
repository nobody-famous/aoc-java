import utils.Problem;

public class Runner {
    public static Problem[] allDays = new Problem[] { new y2020.day1.Part1(y2020.day1.Input.puzzle, 972576),
            new y2020.day1.Part2(y2020.day1.Input.puzzle, 199300880),
            new y2020.day2.Part1(y2020.day2.Input.puzzle, 564), new y2020.day2.Part2(y2020.day2.Input.puzzle, 325),
            new y2020.day3.Part1(y2020.day3.Input.puzzle, 145),
            new y2020.day3.Part2(y2020.day3.Input.puzzle, 3424528800L),
            new y2020.day4.Part1(y2020.day4.Input.puzzle, 213), new y2020.day4.Part2(y2020.day4.Input.puzzle, 147),
            new y2020.day5.Part1(y2020.day5.Input.puzzle, 994), new y2020.day5.Part2(y2020.day5.Input.puzzle, 741),
            new y2020.day6.Part1(y2020.day6.Input.puzzle, 6587), new y2020.day6.Part2(y2020.day6.Input.puzzle, 3235),
            new y2020.day7.Part1(y2020.day7.Input.puzzle, 370), new y2020.day7.Part2(y2020.day7.Input.puzzle, 29547),
            new y2020.day8.Part1(y2020.day8.Input.puzzle, 1859), new y2020.day8.Part2(y2020.day8.Input.puzzle, 1235),
            new y2020.day9.Part1(y2020.day9.Input.puzzle, 556543474),
            new y2020.day9.Part2(y2020.day9.Input.puzzle, 76096372),
            new y2020.day10.Part1(y2020.day10.Input.puzzle, 2574),
            new y2020.day10.Part2(y2020.day10.Input.puzzle, 2644613988352L),
            new y2020.day11.Part1(y2020.day11.Input.puzzle, 2166),
            new y2020.day11.Part2(y2020.day11.Input.puzzle, 1955),
            new y2020.day12.Part1(y2020.day12.Input.puzzle, 1177),
            new y2020.day12.Part2(y2020.day12.Input.puzzle, 46530),
            new y2020.day13.Part1(y2020.day13.Input.puzzle, 1895),
            new y2020.day13.Part2(y2020.day13.Input.puzzle, 840493039281088L),
            new y2020.day14.Part1(y2020.day14.Input.puzzle, 9967721333886L),
            new y2020.day14.Part2(y2020.day14.Input.puzzle, 4355897790573L),
            new y2020.day15.Part1(y2020.day15.Input.puzzle, 1238),
            new y2020.day15.Part2(y2020.day15.Input.puzzle, 3745954),
            new y2020.day16.Part1(y2020.day16.Input.puzzle, 21071),
            new y2020.day16.Part2(y2020.day16.Input.puzzle, 3429967441937L),
            new y2020.day17.Part1(y2020.day17.Input.puzzle, 448), new y2020.day17.Part2(y2020.day17.Input.puzzle, 2400),
            new y2020.day18.Part1(y2020.day18.Input.puzzle, 24650385570008L),
            new y2020.day18.Part2(y2020.day18.Input.puzzle, 158183007916215L),
            new y2020.day19.Part1(y2020.day19.Input.puzzle, 162), new y2020.day19.Part2(y2020.day19.Input.puzzle, 267),
            new y2020.day20.Part1(y2020.day20.Input.puzzle, 13224049461431L),
            new y2020.day20.Part2(y2020.day20.Input.puzzle, 2231),
            new y2020.day21.Part1(y2020.day21.Input.puzzle, 2412),
            new y2020.day21.Part2(y2020.day21.Input.puzzle, "mfp,mgvfmvp,nhdjth,hcdchl,dvkbjh,dcvrf,bcjz,mhnrqp"),
            new y2020.day22.Part1(y2020.day22.Input.puzzle, 33694),
            new y2020.day22.Part2(y2020.day22.Input.puzzle, 31835),
            new y2020.day23.Part1(y2020.day23.Input.puzzle, 82934675),
            new y2020.day23.Part2(y2020.day23.Input.puzzle, 474600314018L),
            new y2020.day24.Part1(y2020.day24.Input.puzzle, 317), new y2020.day24.Part2(y2020.day24.Input.puzzle, 3804),
            new y2020.day25.Part1(y2020.day25.Input.puzzle, 19414467) };

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
        runner.runAll(allDays);

        // runner.runAll(new Problem[] { new y2020.day24.Part2(y2020.day24.Input.puzzle) });
    }
}
