package aoc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import aoc.utils.AocProblem;

public class Runner {
    private record Solver<T>(AocProblem<T> problem, String file, T expected) {
        @Override
        public final String toString() {
            return problem.getClass().getCanonicalName();
        }
    }

    private record Year(String label, List<Solver<?>> problems) {
    }

    private static List<Year> years = List.of(
            new Year("2018", List.of(
                    new Solver<Integer>(new aoc.y2018.day1.Part1(), "input/2018/day1/puzzle.txt", 437),
                    new Solver<Integer>(new aoc.y2018.day1.Part2(), "input/2018/day1/puzzle.txt", 655),
                    new Solver<Integer>(new aoc.y2018.day2.Part1(), "input/2018/day2/puzzle.txt", 6225),
                    new Solver<String>(new aoc.y2018.day2.Part2(), "input/2018/day2/puzzle.txt", "revtaubfniyhsgxdoajwkqilp"),
                    new Solver<Integer>(new aoc.y2018.day3.Part1(), "input/2018/day3/puzzle.txt", 118858),
                    new Solver<Integer>(new aoc.y2018.day3.Part2(), "input/2018/day3/puzzle.txt", 1100),
                    new Solver<Integer>(new aoc.y2018.day4.Part1(), "input/2018/day4/puzzle.txt", 39698),
                    new Solver<Integer>(new aoc.y2018.day4.Part2(), "input/2018/day4/puzzle.txt", 14920),
                    new Solver<Long>(new aoc.y2018.day9.Part1(), "input/2018/day9/puzzle.txt", 382055L),
                    new Solver<Long>(new aoc.y2018.day9.Part2(), "input/2018/day9/puzzle.txt", 3133277384L))),

            new Year("2019", List.of(
                    new Solver<Integer>(new aoc.y2019.day1.Part1(), "input/2019/day1/puzzle.txt", 3279287),
                    new Solver<Integer>(new aoc.y2019.day1.Part2(), "input/2019/day1/puzzle.txt", 4916076),
                    new Solver<Long>(new aoc.y2019.day2.Part1(), "input/2019/day2/puzzle.txt", 3101844L),
                    new Solver<Long>(new aoc.y2019.day2.Part2(), "input/2019/day2/puzzle.txt", 8478L),
                    new Solver<Integer>(new aoc.y2019.day3.Part1(), "input/2019/day3/puzzle.txt", 529),
                    new Solver<Integer>(new aoc.y2019.day3.Part2(), "input/2019/day3/puzzle.txt", 20386),
                    new Solver<Integer>(new aoc.y2019.day4.Part1(), "input/2019/day4/puzzle.txt", 511),
                    new Solver<Integer>(new aoc.y2019.day4.Part2(), "input/2019/day4/puzzle.txt", 316),
                    new Solver<Long>(new aoc.y2019.day5.Part1(), "input/2019/day5/puzzle.txt", 13294380L),
                    new Solver<Long>(new aoc.y2019.day5.Part2(), "input/2019/day5/puzzle.txt", 11460760L),
                    new Solver<Integer>(new aoc.y2019.day6.Part1(), "input/2019/day6/puzzle.txt", 162816),
                    new Solver<Integer>(new aoc.y2019.day6.Part2(), "input/2019/day6/puzzle.txt", 304),
                    new Solver<Long>(new aoc.y2019.day7.Part1(), "input/2019/day7/puzzle.txt", 21760L),
                    new Solver<Long>(new aoc.y2019.day7.Part2(), "input/2019/day7/puzzle.txt", 69816958L),
                    new Solver<Integer>(new aoc.y2019.day8.Part1(), "input/2019/day8/puzzle.txt", 2356),
                    new Solver<String>(new aoc.y2019.day8.Part2(), "input/2019/day8/puzzle.txt", "PZEKB"),
                    new Solver<Long>(new aoc.y2019.day9.Part1(), "input/2019/day9/puzzle.txt", 2870072642L),
                    new Solver<Long>(new aoc.y2019.day9.Part2(), "input/2019/day9/puzzle.txt", 58534L),
                    new Solver<Integer>(new aoc.y2019.day10.Part1(), "input/2019/day10/puzzle.txt", 347),
                    new Solver<Integer>(new aoc.y2019.day10.Part2(), "input/2019/day10/puzzle.txt", 829),
                    new Solver<Integer>(new aoc.y2019.day11.Part1(), "input/2019/day11/puzzle.txt", 1885),
                    new Solver<String>(new aoc.y2019.day11.Part2(), "input/2019/day11/puzzle.txt", "BFEAGHAF"),
                    new Solver<Long>(new aoc.y2019.day12.Part1(), "input/2019/day12/puzzle.txt", 7077L),
                    new Solver<Long>(new aoc.y2019.day12.Part2(), "input/2019/day12/puzzle.txt", 402951477454512L),
                    new Solver<Integer>(new aoc.y2019.day13.Part1(), "input/2019/day13/puzzle.txt", 251),
                    new Solver<Integer>(new aoc.y2019.day13.Part2(), "input/2019/day13/puzzle.txt", 12779),
                    new Solver<Long>(new aoc.y2019.day14.Part1(), "input/2019/day14/puzzle.txt", 136771L),
                    new Solver<Long>(new aoc.y2019.day14.Part2(), "input/2019/day14/puzzle.txt", 8193614L),
                    new Solver<Integer>(new aoc.y2019.day15.Part1(), "input/2019/day15/puzzle.txt", 254),
                    new Solver<Integer>(new aoc.y2019.day15.Part2(), "input/2019/day15/puzzle.txt", 268),
                    new Solver<Integer>(new aoc.y2019.day16.Part1(), "input/2019/day16/puzzle.txt", 68764632),
                    new Solver<Integer>(new aoc.y2019.day16.Part2(), "input/2019/day16/puzzle.txt", 52825021),
                    new Solver<Integer>(new aoc.y2019.day17.Part1(), "input/2019/day17/puzzle.txt", 8928),
                    new Solver<Integer>(new aoc.y2019.day17.Part2(), "input/2019/day17/puzzle.txt", 880360),
                    new Solver<Integer>(new aoc.y2019.day18.Part1(), "input/2019/day18/puzzle.txt", 3048),
                    new Solver<Integer>(new aoc.y2019.day18.Part2(), "input/2019/day18/puzzle2.txt", 1732),
                    new Solver<Integer>(new aoc.y2019.day19.Part1(), "input/2019/day19/puzzle.txt", 234),
                    new Solver<Integer>(new aoc.y2019.day19.Part2(), "input/2019/day19/puzzle.txt", 9290812),
                    new Solver<Integer>(new aoc.y2019.day20.Part1(), "input/2019/day20/puzzle.txt", 526),
                    new Solver<Integer>(new aoc.y2019.day20.Part2(), "input/2019/day20/puzzle.txt", 6292),
                    new Solver<Integer>(new aoc.y2019.day21.Part1(), "input/2019/day21/puzzle.txt", 19359316),
                    new Solver<Integer>(new aoc.y2019.day21.Part2(), "input/2019/day21/puzzle.txt", 1141281622),
                    new Solver<Long>(new aoc.y2019.day22.Part1(), "input/2019/day22/puzzle.txt", 4703L),
                    new Solver<Long>(new aoc.y2019.day22.Part2(), "input/2019/day22/puzzle.txt", 55627600867625L),
                    new Solver<Integer>(new aoc.y2019.day23.Part1(), "input/2019/day23/puzzle.txt", 27061),
                    new Solver<Integer>(new aoc.y2019.day23.Part2(), "input/2019/day23/puzzle.txt", 19406),
                    new Solver<Integer>(new aoc.y2019.day24.Part1(), "input/2019/day24/puzzle.txt", 24662545),
                    new Solver<Integer>(new aoc.y2019.day24.Part2(), "input/2019/day24/puzzle.txt", 2063),
                    new Solver<Integer>(new aoc.y2019.day25.Part1(), "input/2019/day25/puzzle.txt", 100667393))),

            new Year("2020", List.of(
                    new Solver<Integer>(new aoc.y2020.day1.Part1(), "input/2020/day1.txt", 972576),
                    new Solver<Integer>(new aoc.y2020.day1.Part2(), "input/2020/day1.txt", 199300880),
                    new Solver<Integer>(new aoc.y2020.day2.Part1(), "input/2020/day2.txt", 564),
                    new Solver<Integer>(new aoc.y2020.day2.Part2(), "input/2020/day2.txt", 325),
                    new Solver<Long>(new aoc.y2020.day3.Part1(), "input/2020/day3.txt", 145L),
                    new Solver<Long>(new aoc.y2020.day3.Part2(), "input/2020/day3.txt", 3424528800L),
                    new Solver<Integer>(new aoc.y2020.day4.Part1(), "input/2020/day4.txt", 213),
                    new Solver<Integer>(new aoc.y2020.day4.Part2(), "input/2020/day4.txt", 147),
                    new Solver<Integer>(new aoc.y2020.day5.Part1(), "input/2020/day5.txt", 994),
                    new Solver<Integer>(new aoc.y2020.day5.Part2(), "input/2020/day5.txt", 741),
                    new Solver<Integer>(new aoc.y2020.day6.Part1(), "input/2020/day6.txt", 6587),
                    new Solver<Integer>(new aoc.y2020.day6.Part2(), "input/2020/day6.txt", 3235),
                    new Solver<Integer>(new aoc.y2020.day7.Part1(), "input/2020/day7.txt", 370),
                    new Solver<Integer>(new aoc.y2020.day7.Part2(), "input/2020/day7.txt", 29547),
                    new Solver<Integer>(new aoc.y2020.day8.Part1(), "input/2020/day8.txt", 1859),
                    new Solver<Integer>(new aoc.y2020.day8.Part2(), "input/2020/day8.txt", 1235),
                    new Solver<Integer>(new aoc.y2020.day9.Part1(), "input/2020/day9.txt", 556543474),
                    new Solver<Integer>(new aoc.y2020.day9.Part2(), "input/2020/day9.txt", 76096372)
            //         new aoc.y2020.day10.Part1(aoc.y2020.day10.Input.puzzle, 2574),
            //         new aoc.y2020.day10.Part2(aoc.y2020.day10.Input.puzzle, 2644613988352L),
            //         new aoc.y2020.day11.Part1(aoc.y2020.day11.Input.puzzle, 2166),
            //         new aoc.y2020.day11.Part2(aoc.y2020.day11.Input.puzzle, 1955),
            //         new aoc.y2020.day12.Part1(aoc.y2020.day12.Input.puzzle, 1177),
            //         new aoc.y2020.day12.Part2(aoc.y2020.day12.Input.puzzle, 46530),
            //         new aoc.y2020.day13.Part1(aoc.y2020.day13.Input.puzzle, 1895),
            //         new aoc.y2020.day13.Part2(aoc.y2020.day13.Input.puzzle, 840493039281088L),
            //         new aoc.y2020.day14.Part1(aoc.y2020.day14.Input.puzzle, 9967721333886L),
            //         new aoc.y2020.day14.Part2(aoc.y2020.day14.Input.puzzle, 4355897790573L),
            //         new aoc.y2020.day15.Part1(aoc.y2020.day15.Input.puzzle, 1238),
            //         new aoc.y2020.day15.Part2(aoc.y2020.day15.Input.puzzle, 3745954),
            //         new aoc.y2020.day16.Part1(aoc.y2020.day16.Input.puzzle, 21071),
            //         new aoc.y2020.day16.Part2(aoc.y2020.day16.Input.puzzle, 3429967441937L),
            //         new aoc.y2020.day17.Part1(aoc.y2020.day17.Input.puzzle, 448),
            //         new aoc.y2020.day17.Part2(aoc.y2020.day17.Input.puzzle, 2400),
            //         new aoc.y2020.day18.Part1(aoc.y2020.day18.Input.puzzle, 24650385570008L),
            //         new aoc.y2020.day18.Part2(aoc.y2020.day18.Input.puzzle, 158183007916215L),
            //         new aoc.y2020.day19.Part1(aoc.y2020.day19.Input.puzzle, 162),
            //         new aoc.y2020.day19.Part2(aoc.y2020.day19.Input.puzzle, 267),
            //         new aoc.y2020.day20.Part1(aoc.y2020.day20.Input.puzzle, 13224049461431L),
            //         new aoc.y2020.day20.Part2(aoc.y2020.day20.Input.puzzle, 2231),
            //         new aoc.y2020.day21.Part1(aoc.y2020.day21.Input.puzzle, 2412),
            //         new aoc.y2020.day21.Part2(aoc.y2020.day21.Input.puzzle, "mfp,mgvfmvp,nhdjth,hcdchl,dvkbjh,dcvrf,bcjz,mhnrqp"),
            //         new aoc.y2020.day22.Part1(aoc.y2020.day22.Input.puzzle, 33694),
            //         new aoc.y2020.day22.Part2(aoc.y2020.day22.Input.puzzle, 31835),
            //         new aoc.y2020.day23.Part1(aoc.y2020.day23.Input.puzzle, 82934675),
            //         new aoc.y2020.day23.Part2(aoc.y2020.day23.Input.puzzle, 474600314018L),
            //         new aoc.y2020.day24.Part1(aoc.y2020.day24.Input.puzzle, 317),
            //         new aoc.y2020.day24.Part2(aoc.y2020.day24.Input.puzzle, 3804),
            //         new aoc.y2020.day25.Part1(aoc.y2020.day25.Input.puzzle, 19414467)
            )),

            new Year("2024", List.of(
                    new Solver<Integer>(new aoc.y2024.day1.Part1(), "input/2024/day1.txt", 2057374),
                    new Solver<Integer>(new aoc.y2024.day1.Part2(), "input/2024/day1.txt", 23177084),
                    new Solver<Integer>(new aoc.y2024.day2.Part1(), "input/2024/day2.txt", 334),
                    new Solver<Integer>(new aoc.y2024.day2.Part2(), "input/2024/day2.txt", 400),
                    new Solver<Integer>(new aoc.y2024.day3.Part1(), "input/2024/day3.txt", 170778545),
                    new Solver<Integer>(new aoc.y2024.day3.Part2(), "input/2024/day3.txt", 82868252),
                    new Solver<Integer>(new aoc.y2024.day4.Part1(), "input/2024/day4.txt", 2578),
                    new Solver<Integer>(new aoc.y2024.day4.Part2(), "input/2024/day4.txt", 1972),
                    new Solver<Integer>(new aoc.y2024.day5.Part1(), "input/2024/day5.txt", 4905),
                    new Solver<Integer>(new aoc.y2024.day5.Part2(), "input/2024/day5.txt", 6204),
                    new Solver<Integer>(new aoc.y2024.day6.Part1(), "input/2024/day6.txt", 4776),
                    new Solver<Integer>(new aoc.y2024.day6.Part2(), "input/2024/day6.txt", 1586),
                    new Solver<Long>(new aoc.y2024.day7.Part1(), "input/2024/day7.txt", 663613490587L),
                    new Solver<Long>(new aoc.y2024.day7.Part2(), "input/2024/day7.txt", 110365987435001L),
                    new Solver<Integer>(new aoc.y2024.day8.Part1(), "input/2024/day8.txt", 341),
                    new Solver<Integer>(new aoc.y2024.day8.Part2(), "input/2024/day8.txt", 1134),
                    new Solver<Integer>(new aoc.y2024.day10.Part1(), "input/2024/day10.txt", 550),
                    new Solver<Integer>(new aoc.y2024.day10.Part2(), "input/2024/day10.txt", 1255))));

    private static String runSolver(Solver<?> solver) throws Exception {
        try {
            var lines = readLines(solver.file);
            var result = solver.problem.solve(lines);

            return (solver.expected.equals(result))
                    ? "[OK]"
                    : "[Failed: Expected " + solver.expected + ", got " + result + "]";
        } catch (Exception ex) {
            return "[Failed: " + ex.getMessage() + "]";
        }
    }

    private static void runAll(String label, List<Solver<?>> all) throws Exception {
        var total = 0L;

        System.out.println("---------------");
        System.out.println(label);
        System.out.println("---------------");
        for (var solver : all) {
            var start = System.currentTimeMillis();
            var msg = runSolver(solver);

            var diff = System.currentTimeMillis() - start;

            System.out.println(msg + " " + solver + " " + diff + " ms");

            total += diff;
        }

        System.out.println("Total: " + total + " ms");
    }

    private static List<String> readLines(String fileName) throws Exception {
        if (fileName == null || fileName.isEmpty()) {
            return new ArrayList<>();
        }

        try (var reader = new BufferedReader(new FileReader(fileName))) {
            var lines = new ArrayList<String>();
            var line = reader.readLine();

            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }

            return lines;
        }
    }

    public static void main(String[] args) throws Exception {
        for (var year : years) {
            if (year.label == "2020") {
                runAll(year.label, year.problems);
            }
        }
    }
}
