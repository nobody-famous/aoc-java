package aoc;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import aoc.runner.Solver;
import aoc.runner.Year;

public class Runner {
    private static List<Year> years = List.of(
            new Year("2018", List.of(
                    new Solver<Integer>(new aoc.y2018.day1.Part1(), "2018/day1.txt", 437),
                    new Solver<Integer>(new aoc.y2018.day1.Part2(), "2018/day1.txt", 655),
                    new Solver<Integer>(new aoc.y2018.day2.Part1(), "2018/day2.txt", 6225),
                    new Solver<String>(new aoc.y2018.day2.Part2(), "2018/day2.txt", "revtaubfniyhsgxdoajwkqilp"),
                    new Solver<Integer>(new aoc.y2018.day3.Part1(), "2018/day3.txt", 118858),
                    new Solver<Integer>(new aoc.y2018.day3.Part2(), "2018/day3.txt", 1100),
                    new Solver<Integer>(new aoc.y2018.day4.Part1(), "2018/day4.txt", 39698),
                    new Solver<Integer>(new aoc.y2018.day4.Part2(), "2018/day4.txt", 14920),
                    new Solver<Long>(new aoc.y2018.day9.Part1(), "2018/day9.txt", 382055L),
                    new Solver<Long>(new aoc.y2018.day9.Part2(), "2018/day9.txt", 3133277384L))),

            new Year("2019", List.of(
                    new Solver<Integer>(new aoc.y2019.day1.Part1(), "2019/day1.txt", 3279287),
                    new Solver<Integer>(new aoc.y2019.day1.Part2(), "2019/day1.txt", 4916076),
                    new Solver<Long>(new aoc.y2019.day2.Part1(), "2019/day2.txt", 3101844L),
                    new Solver<Long>(new aoc.y2019.day2.Part2(), "2019/day2.txt", 8478L),
                    new Solver<Integer>(new aoc.y2019.day3.Part1(), "2019/day3.txt", 529),
                    new Solver<Integer>(new aoc.y2019.day3.Part2(), "2019/day3.txt", 20386),
                    new Solver<Integer>(new aoc.y2019.day4.Part1(), "2019/day4.txt", 511),
                    new Solver<Integer>(new aoc.y2019.day4.Part2(), "2019/day4.txt", 316),
                    new Solver<Long>(new aoc.y2019.day5.Part1(), "2019/day5.txt", 13294380L),
                    new Solver<Long>(new aoc.y2019.day5.Part2(), "2019/day5.txt", 11460760L),
                    new Solver<Integer>(new aoc.y2019.day6.Part1(), "2019/day6.txt", 162816),
                    new Solver<Integer>(new aoc.y2019.day6.Part2(), "2019/day6.txt", 304),
                    new Solver<Long>(new aoc.y2019.day7.Part1(), "2019/day7.txt", 21760L),
                    new Solver<Long>(new aoc.y2019.day7.Part2(), "2019/day7.txt", 69816958L),
                    new Solver<Integer>(new aoc.y2019.day8.Part1(), "2019/day8.txt", 2356),
                    new Solver<String>(new aoc.y2019.day8.Part2(), "2019/day8.txt", "PZEKB"),
                    new Solver<Long>(new aoc.y2019.day9.Part1(), "2019/day9.txt", 2870072642L),
                    new Solver<Long>(new aoc.y2019.day9.Part2(), "2019/day9.txt", 58534L),
                    new Solver<Integer>(new aoc.y2019.day10.Part1(), "2019/day10.txt", 347),
                    new Solver<Integer>(new aoc.y2019.day10.Part2(), "2019/day10.txt", 829),
                    new Solver<Integer>(new aoc.y2019.day11.Part1(), "2019/day11.txt", 1885),
                    new Solver<String>(new aoc.y2019.day11.Part2(), "2019/day11.txt", "BFEAGHAF"),
                    new Solver<Long>(new aoc.y2019.day12.Part1(), "2019/day12.txt", 7077L),
                    new Solver<Long>(new aoc.y2019.day12.Part2(), "2019/day12.txt", 402951477454512L),
                    new Solver<Integer>(new aoc.y2019.day13.Part1(), "2019/day13.txt", 251),
                    new Solver<Integer>(new aoc.y2019.day13.Part2(), "2019/day13.txt", 12779),
                    new Solver<Long>(new aoc.y2019.day14.Part1(), "2019/day14.txt", 136771L),
                    new Solver<Long>(new aoc.y2019.day14.Part2(), "2019/day14.txt", 8193614L),
                    new Solver<Integer>(new aoc.y2019.day15.Part1(), "2019/day15.txt", 254),
                    new Solver<Integer>(new aoc.y2019.day15.Part2(), "2019/day15.txt", 268),
                    new Solver<Integer>(new aoc.y2019.day16.Part1(), "2019/day16.txt", 68764632),
                    new Solver<Integer>(new aoc.y2019.day16.Part2(), "2019/day16.txt", 52825021),
                    new Solver<Integer>(new aoc.y2019.day17.Part1(), "2019/day17.txt", 8928),
                    new Solver<Integer>(new aoc.y2019.day17.Part2(), "2019/day17.txt", 880360),
                    new Solver<Integer>(new aoc.y2019.day18.Part1(), "2019/day18.txt", 3048),
                    new Solver<Integer>(new aoc.y2019.day18.Part2(), "2019/day18_2.txt", 1732),
                    new Solver<Integer>(new aoc.y2019.day19.Part1(), "2019/day19.txt", 234),
                    new Solver<Integer>(new aoc.y2019.day19.Part2(), "2019/day19.txt", 9290812),
                    new Solver<Integer>(new aoc.y2019.day20.Part1(), "2019/day20.txt", 526),
                    new Solver<Integer>(new aoc.y2019.day20.Part2(), "2019/day20.txt", 6292),
                    new Solver<Integer>(new aoc.y2019.day21.Part1(), "2019/day21.txt", 19359316),
                    new Solver<Integer>(new aoc.y2019.day21.Part2(), "2019/day21.txt", 1141281622),
                    new Solver<Long>(new aoc.y2019.day22.Part1(), "2019/day22.txt", 4703L),
                    new Solver<Long>(new aoc.y2019.day22.Part2(), "2019/day22.txt", 55627600867625L),
                    new Solver<Integer>(new aoc.y2019.day23.Part1(), "2019/day23.txt", 27061),
                    new Solver<Integer>(new aoc.y2019.day23.Part2(), "2019/day23.txt", 19406),
                    new Solver<Integer>(new aoc.y2019.day24.Part1(), "2019/day24.txt", 24662545),
                    new Solver<Integer>(new aoc.y2019.day24.Part2(), "2019/day24.txt", 2063),
                    new Solver<Integer>(new aoc.y2019.day25.Part1(), "2019/day25.txt", 100667393))),

            new Year("2020", List.of(
                    new Solver<Integer>(new aoc.y2020.day1.Part1(), "2020/day1.txt", 972576),
                    new Solver<Integer>(new aoc.y2020.day1.Part2(), "2020/day1.txt", 199300880),
                    new Solver<Integer>(new aoc.y2020.day2.Part1(), "2020/day2.txt", 564),
                    new Solver<Integer>(new aoc.y2020.day2.Part2(), "2020/day2.txt", 325),
                    new Solver<Long>(new aoc.y2020.day3.Part1(), "2020/day3.txt", 145L),
                    new Solver<Long>(new aoc.y2020.day3.Part2(), "2020/day3.txt", 3424528800L),
                    new Solver<Integer>(new aoc.y2020.day4.Part1(), "2020/day4.txt", 213),
                    new Solver<Integer>(new aoc.y2020.day4.Part2(), "2020/day4.txt", 147),
                    new Solver<Integer>(new aoc.y2020.day5.Part1(), "2020/day5.txt", 994),
                    new Solver<Integer>(new aoc.y2020.day5.Part2(), "2020/day5.txt", 741),
                    new Solver<Integer>(new aoc.y2020.day6.Part1(), "2020/day6.txt", 6587),
                    new Solver<Integer>(new aoc.y2020.day6.Part2(), "2020/day6.txt", 3235),
                    new Solver<Integer>(new aoc.y2020.day7.Part1(), "2020/day7.txt", 370),
                    new Solver<Integer>(new aoc.y2020.day7.Part2(), "2020/day7.txt", 29547),
                    new Solver<Integer>(new aoc.y2020.day8.Part1(), "2020/day8.txt", 1859),
                    new Solver<Integer>(new aoc.y2020.day8.Part2(), "2020/day8.txt", 1235),
                    new Solver<Integer>(new aoc.y2020.day9.Part1(), "2020/day9.txt", 556543474),
                    new Solver<Integer>(new aoc.y2020.day9.Part2(), "2020/day9.txt", 76096372),
                    new Solver<Long>(new aoc.y2020.day10.Part1(), "2020/day10.txt", 2574L),
                    new Solver<Long>(new aoc.y2020.day10.Part2(), "2020/day10.txt", 2644613988352L),
                    new Solver<Integer>(new aoc.y2020.day11.Part1(), "2020/day11.txt", 2166),
                    new Solver<Integer>(new aoc.y2020.day11.Part2(), "2020/day11.txt", 1955),
                    new Solver<Integer>(new aoc.y2020.day12.Part1(), "2020/day12.txt", 1177),
                    new Solver<Integer>(new aoc.y2020.day12.Part2(), "2020/day12.txt", 46530),
                    new Solver<Long>(new aoc.y2020.day13.Part1(), "2020/day13.txt", 1895L),
                    new Solver<Long>(new aoc.y2020.day13.Part2(), "2020/day13.txt", 840493039281088L),
                    new Solver<Long>(new aoc.y2020.day14.Part1(), "2020/day14.txt", 9967721333886L),
                    new Solver<Long>(new aoc.y2020.day14.Part2(), "2020/day14.txt", 4355897790573L),
                    new Solver<Integer>(new aoc.y2020.day15.Part1(), "2020/day15.txt", 1238),
                    new Solver<Integer>(new aoc.y2020.day15.Part2(), "2020/day15.txt", 3745954),
                    new Solver<Long>(new aoc.y2020.day16.Part1(), "2020/day16.txt", 21071L),
                    new Solver<Long>(new aoc.y2020.day16.Part2(), "2020/day16.txt", 3429967441937L),
                    new Solver<Integer>(new aoc.y2020.day17.Part1(), "2020/day17.txt", 448),
                    new Solver<Integer>(new aoc.y2020.day17.Part2(), "2020/day17.txt", 2400),
                    new Solver<Long>(new aoc.y2020.day18.Part1(), "2020/day18.txt", 24650385570008L),
                    new Solver<Long>(new aoc.y2020.day18.Part2(), "2020/day18.txt", 158183007916215L),
                    new Solver<Integer>(new aoc.y2020.day19.Part1(), "2020/day19.txt", 162),
                    new Solver<Integer>(new aoc.y2020.day19.Part2(), "2020/day19.txt", 267),
                    new Solver<Long>(new aoc.y2020.day20.Part1(), "2020/day20.txt", 13224049461431L),
                    new Solver<Long>(new aoc.y2020.day20.Part2(), "2020/day20.txt", 2231L),
                    new Solver<Integer>(new aoc.y2020.day21.Part1(), "2020/day21.txt", 2412),
                    new Solver<String>(new aoc.y2020.day21.Part2(), "2020/day21.txt", "mfp,mgvfmvp,nhdjth,hcdchl,dvkbjh,dcvrf,bcjz,mhnrqp"),
                    new Solver<Integer>(new aoc.y2020.day22.Part1(), "2020/day22.txt", 33694),
                    new Solver<Integer>(new aoc.y2020.day22.Part2(), "2020/day22.txt", 31835),
                    new Solver<Long>(new aoc.y2020.day23.Part1(), "2020/day23.txt", 82934675L),
                    new Solver<Long>(new aoc.y2020.day23.Part2(), "2020/day23.txt", 474600314018L),
                    new Solver<Integer>(new aoc.y2020.day24.Part1(), "2020/day24.txt", 317),
                    new Solver<Integer>(new aoc.y2020.day24.Part2(), "2020/day24.txt", 3804),
                    new Solver<Long>(new aoc.y2020.day25.Part1(), "2020/day25.txt", 19414467L))),

            new Year("2024", List.of(
                    new Solver<Integer>(new aoc.y2024.day1.Part1(), "2024/day1.txt", 2057374),
                    new Solver<Integer>(new aoc.y2024.day1.Part2(), "2024/day1.txt", 23177084),
                    new Solver<Integer>(new aoc.y2024.day2.Part1(), "2024/day2.txt", 334),
                    new Solver<Integer>(new aoc.y2024.day2.Part2(), "2024/day2.txt", 400),
                    new Solver<Integer>(new aoc.y2024.day3.Part1(), "2024/day3.txt", 170778545),
                    new Solver<Integer>(new aoc.y2024.day3.Part2(), "2024/day3.txt", 82868252),
                    new Solver<Integer>(new aoc.y2024.day4.Part1(), "2024/day4.txt", 2578),
                    new Solver<Integer>(new aoc.y2024.day4.Part2(), "2024/day4.txt", 1972),
                    new Solver<Integer>(new aoc.y2024.day5.Part1(), "2024/day5.txt", 4905),
                    new Solver<Integer>(new aoc.y2024.day5.Part2(), "2024/day5.txt", 6204),
                    new Solver<Integer>(new aoc.y2024.day6.Part1(), "2024/day6.txt", 4776),
                    new Solver<Integer>(new aoc.y2024.day6.Part2(), "2024/day6.txt", 1586),
                    new Solver<Long>(new aoc.y2024.day7.Part1(), "2024/day7.txt", 663613490587L),
                    new Solver<Long>(new aoc.y2024.day7.Part2(), "2024/day7.txt", 110365987435001L),
                    new Solver<Integer>(new aoc.y2024.day8.Part1(), "2024/day8.txt", 341),
                    new Solver<Integer>(new aoc.y2024.day8.Part2(), "2024/day8.txt", 1134),
                    new Solver<Integer>(new aoc.y2024.day10.Part1(), "2024/day10.txt", 550),
                    new Solver<Integer>(new aoc.y2024.day10.Part2(), "2024/day10.txt", 1255),
                    new Solver<Long>(new aoc.y2024.day11.Part1(), "2024/day11.txt", 183435L),
                    new Solver<Long>(new aoc.y2024.day11.Part2(), "2024/day11.txt", 218279375708592L),
                    new Solver<Integer>(new aoc.y2024.day12.Part1(), "2024/day12.txt", 1304764),
                    new Solver<Integer>(new aoc.y2024.day12.Part2(), "2024/day12.txt", 811148),
                    new Solver<Long>(new aoc.y2024.day13.Part1(), "2024/day13.txt", 40069L),
                    new Solver<Long>(new aoc.y2024.day13.Part2(), "2024/day13.txt", 71493195288102L),
                    new Solver<Integer>(new aoc.y2024.day15.Part1(), "2024/day15.txt", 1499739),
                    new Solver<Integer>(new aoc.y2024.day15.Part2(), "2024/day15.txt", 1522215),
                    new Solver<Integer>(new aoc.y2024.day16.Part1(), "2024/day16.txt", 98416),
                    new Solver<Integer>(new aoc.y2024.day16.Part2(), "2024/day16.txt", 471),
                    new Solver<String>(new aoc.y2024.day17.Part1(), "2024/day17.txt", "7,0,7,3,4,1,3,0,1"))));

    private static void run(String label, Path inputsBaseDir, List<Solver<?>> solvers) throws Exception {
        var total = 0L;

        System.out.println("---------------");
        System.out.println(label);
        System.out.println("---------------");
        for (var solver : solvers) {
            var start = System.currentTimeMillis();
            var msg = solver.run(inputsBaseDir);

            var diff = System.currentTimeMillis() - start;

            System.out.println(msg + " " + solver + " " + diff + " ms");

            total += diff;
        }

        System.out.println("Total: " + total + " ms");
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            throw new Exception("Wrong number of arguments: " + args.length + ". Need to give input files base directory");
        }

        var inputFilesDir = Paths.get(args[0]);

        for (var year : years) {
            if (year.label() == "2024") {
                run(year.label(), inputFilesDir, year.problems());
            }
        }
    }
}
