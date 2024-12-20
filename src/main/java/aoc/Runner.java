package aoc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import aoc.utils.AocProblem;

public class Runner {
    public interface Solver<T extends AocProblem> {
        void solve(T prob, List<String> lines) throws Exception;
    }

    private record Year(String label, List<AocProblem> problems) {
    }

    private static List<Year> years = List.of(
            new Year("2018", List.of(
                    new aoc.y2018.day1.Part1("input/2018/day1/puzzle.txt", 437),
                    new aoc.y2018.day1.Part2("input/2018/day1/puzzle.txt", 655),
                    new aoc.y2018.day2.Part1("input/2018/day2/puzzle.txt", 6225),
                    new aoc.y2018.day2.Part2("input/2018/day2/puzzle.txt", "revtaubfniyhsgxdoajwkqilp"),
                    new aoc.y2018.day3.Part1("input/2018/day3/puzzle.txt", 118858),
                    new aoc.y2018.day3.Part2("input/2018/day3/puzzle.txt", 1100),
                    new aoc.y2018.day4.Part1("input/2018/day4/puzzle.txt", 39698),
                    new aoc.y2018.day4.Part2("input/2018/day4/puzzle.txt", 14920),
                    new aoc.y2018.day9.Part1("input/2018/day9/puzzle.txt", 382055L),
                    new aoc.y2018.day9.Part2("input/2018/day9/puzzle.txt", 3133277384L))),

            new Year("2019", List.of(
                    new aoc.y2019.day1.Part1("input/2019/day1/puzzle.txt", 3279287),
                    new aoc.y2019.day1.Part2("input/2019/day1/puzzle.txt", 4916076),
                    new aoc.y2019.day2.Part1("input/2019/day2/puzzle.txt", 3101844),
                    new aoc.y2019.day2.Part2("input/2019/day2/puzzle.txt", 8478),
                    new aoc.y2019.day3.Part1("input/2019/day3/puzzle.txt", 529),
                    new aoc.y2019.day3.Part2("input/2019/day3/puzzle.txt", 20386),
                    new aoc.y2019.day4.Part1("input/2019/day4/puzzle.txt", 511),
                    new aoc.y2019.day4.Part2("input/2019/day4/puzzle.txt", 316),
                    new aoc.y2019.day5.Part1("input/2019/day5/puzzle.txt", 13294380),
                    new aoc.y2019.day5.Part2("input/2019/day5/puzzle.txt", 11460760),
                    new aoc.y2019.day6.Part1("input/2019/day6/puzzle.txt", 162816),
                    new aoc.y2019.day6.Part2("input/2019/day6/puzzle.txt", 304),
                    new aoc.y2019.day7.Part1("input/2019/day7/puzzle.txt", 21760),
                    new aoc.y2019.day7.Part2("input/2019/day7/puzzle.txt", 69816958),
                    new aoc.y2019.day8.Part1("input/2019/day8/puzzle.txt", 2356),
                    new aoc.y2019.day8.Part2("input/2019/day8/puzzle.txt", "PZEKB"),
                    new aoc.y2019.day9.Part1("input/2019/day9/puzzle.txt", 2870072642L),
                    new aoc.y2019.day9.Part2("input/2019/day9/puzzle.txt", 58534L),
                    new aoc.y2019.day10.Part1("input/2019/day10/puzzle.txt", 347),
                    new aoc.y2019.day10.Part2("input/2019/day10/puzzle.txt", 829),
                    new aoc.y2019.day11.Part1("input/2019/day11/puzzle.txt", 1885),
                    new aoc.y2019.day11.Part2("input/2019/day11/puzzle.txt", "BFEAGHAF"),
                    new aoc.y2019.day12.Part1("input/2019/day12/puzzle.txt", 7077),
                    new aoc.y2019.day12.Part2("input/2019/day12/puzzle.txt", 402951477454512L),
                    new aoc.y2019.day13.Part1("input/2019/day13/puzzle.txt", 251),
                    new aoc.y2019.day13.Part2("input/2019/day13/puzzle.txt", 12779),
                    new aoc.y2019.day14.Part1("input/2019/day14/puzzle.txt", 136771),
                    new aoc.y2019.day14.Part2("input/2019/day14/puzzle.txt", 8193614),
                    new aoc.y2019.day15.Part1("input/2019/day15/puzzle.txt", 254),
                    new aoc.y2019.day15.Part2("input/2019/day15/puzzle.txt", 268),
                    new aoc.y2019.day16.Part1("input/2019/day16/puzzle.txt", 68764632),
                    new aoc.y2019.day16.Part2("input/2019/day16/puzzle.txt", 52825021),
                    new aoc.y2019.day17.Part1("input/2019/day17/puzzle.txt", 8928),
                    new aoc.y2019.day17.Part2("input/2019/day17/puzzle.txt", 880360),
                    new aoc.y2019.day18.Part1("input/2019/day18/puzzle.txt", 3048),
                    new aoc.y2019.day18.Part2("input/2019/day18/puzzle2.txt", 1732),
                    new aoc.y2019.day19.Part1("input/2019/day19/puzzle.txt", 234),
                    new aoc.y2019.day19.Part2("input/2019/day19/puzzle.txt", 9290812),
                    new aoc.y2019.day20.Part1("input/2019/day20/puzzle.txt", 526),
                    new aoc.y2019.day20.Part2("input/2019/day20/puzzle.txt", 6292),
                    new aoc.y2019.day21.Part1("input/2019/day21/puzzle.txt", 19359316),
                    new aoc.y2019.day21.Part2("input/2019/day21/puzzle.txt", 1141281622),
                    new aoc.y2019.day22.Part1("input/2019/day22/puzzle.txt", 4703),
                    new aoc.y2019.day22.Part2("input/2019/day22/puzzle.txt", 55627600867625L),
                    new aoc.y2019.day23.Part1("input/2019/day23/puzzle.txt", 27061),
                    new aoc.y2019.day23.Part2("input/2019/day23/puzzle.txt", 19406),
                    new aoc.y2019.day24.Part1("input/2019/day24/puzzle.txt", 24662545),
                    new aoc.y2019.day24.Part2("input/2019/day24/puzzle.txt", 2063),
                    new aoc.y2019.day25.Part1("input/2019/day25/puzzle.txt", 100667393))),

            new Year("2020", List.of(
                    new aoc.y2020.day1.Part1(aoc.y2020.day1.Input.puzzle, 972576),
                    new aoc.y2020.day1.Part2(aoc.y2020.day1.Input.puzzle, 199300880),
                    new aoc.y2020.day2.Part1(aoc.y2020.day2.Input.puzzle, 564),
                    new aoc.y2020.day2.Part2(aoc.y2020.day2.Input.puzzle, 325),
                    new aoc.y2020.day3.Part1(aoc.y2020.day3.Input.puzzle, 145),
                    new aoc.y2020.day3.Part2(aoc.y2020.day3.Input.puzzle, 3424528800L),
                    new aoc.y2020.day4.Part1(aoc.y2020.day4.Input.puzzle, 213),
                    new aoc.y2020.day4.Part2(aoc.y2020.day4.Input.puzzle, 147),
                    new aoc.y2020.day5.Part1(aoc.y2020.day5.Input.puzzle, 994),
                    new aoc.y2020.day5.Part2(aoc.y2020.day5.Input.puzzle, 741),
                    new aoc.y2020.day6.Part1(aoc.y2020.day6.Input.puzzle, 6587),
                    new aoc.y2020.day6.Part2(aoc.y2020.day6.Input.puzzle, 3235),
                    new aoc.y2020.day7.Part1(aoc.y2020.day7.Input.puzzle, 370),
                    new aoc.y2020.day7.Part2(aoc.y2020.day7.Input.puzzle, 29547),
                    new aoc.y2020.day8.Part1(aoc.y2020.day8.Input.puzzle, 1859),
                    new aoc.y2020.day8.Part2(aoc.y2020.day8.Input.puzzle, 1235),
                    new aoc.y2020.day9.Part1(aoc.y2020.day9.Input.puzzle, 556543474),
                    new aoc.y2020.day9.Part2(aoc.y2020.day9.Input.puzzle, 76096372),
                    new aoc.y2020.day10.Part1(aoc.y2020.day10.Input.puzzle, 2574),
                    new aoc.y2020.day10.Part2(aoc.y2020.day10.Input.puzzle, 2644613988352L),
                    new aoc.y2020.day11.Part1(aoc.y2020.day11.Input.puzzle, 2166),
                    new aoc.y2020.day11.Part2(aoc.y2020.day11.Input.puzzle, 1955),
                    new aoc.y2020.day12.Part1(aoc.y2020.day12.Input.puzzle, 1177),
                    new aoc.y2020.day12.Part2(aoc.y2020.day12.Input.puzzle, 46530),
                    new aoc.y2020.day13.Part1(aoc.y2020.day13.Input.puzzle, 1895),
                    new aoc.y2020.day13.Part2(aoc.y2020.day13.Input.puzzle, 840493039281088L),
                    new aoc.y2020.day14.Part1(aoc.y2020.day14.Input.puzzle, 9967721333886L),
                    new aoc.y2020.day14.Part2(aoc.y2020.day14.Input.puzzle, 4355897790573L),
                    new aoc.y2020.day15.Part1(aoc.y2020.day15.Input.puzzle, 1238),
                    new aoc.y2020.day15.Part2(aoc.y2020.day15.Input.puzzle, 3745954),
                    new aoc.y2020.day16.Part1(aoc.y2020.day16.Input.puzzle, 21071),
                    new aoc.y2020.day16.Part2(aoc.y2020.day16.Input.puzzle, 3429967441937L),
                    new aoc.y2020.day17.Part1(aoc.y2020.day17.Input.puzzle, 448),
                    new aoc.y2020.day17.Part2(aoc.y2020.day17.Input.puzzle, 2400),
                    new aoc.y2020.day18.Part1(aoc.y2020.day18.Input.puzzle, 24650385570008L),
                    new aoc.y2020.day18.Part2(aoc.y2020.day18.Input.puzzle, 158183007916215L),
                    new aoc.y2020.day19.Part1(aoc.y2020.day19.Input.puzzle, 162),
                    new aoc.y2020.day19.Part2(aoc.y2020.day19.Input.puzzle, 267),
                    new aoc.y2020.day20.Part1(aoc.y2020.day20.Input.puzzle, 13224049461431L),
                    new aoc.y2020.day20.Part2(aoc.y2020.day20.Input.puzzle, 2231),
                    new aoc.y2020.day21.Part1(aoc.y2020.day21.Input.puzzle, 2412),
                    new aoc.y2020.day21.Part2(aoc.y2020.day21.Input.puzzle, "mfp,mgvfmvp,nhdjth,hcdchl,dvkbjh,dcvrf,bcjz,mhnrqp"),
                    new aoc.y2020.day22.Part1(aoc.y2020.day22.Input.puzzle, 33694),
                    new aoc.y2020.day22.Part2(aoc.y2020.day22.Input.puzzle, 31835),
                    new aoc.y2020.day23.Part1(aoc.y2020.day23.Input.puzzle, 82934675),
                    new aoc.y2020.day23.Part2(aoc.y2020.day23.Input.puzzle, 474600314018L),
                    new aoc.y2020.day24.Part1(aoc.y2020.day24.Input.puzzle, 317),
                    new aoc.y2020.day24.Part2(aoc.y2020.day24.Input.puzzle, 3804),
                    new aoc.y2020.day25.Part1(aoc.y2020.day25.Input.puzzle, 19414467))),

            new Year("2024", List.of(
                    new aoc.y2024.day1.Part1("input/2024/day1.txt", 2057374),
                    new aoc.y2024.day1.Part2("input/2024/day1.txt", 23177084),
                    new aoc.y2024.day2.Part1("input/2024/day2.txt", 334),
                    new aoc.y2024.day2.Part2("input/2024/day2.txt", 400),
                    new aoc.y2024.day3.Part1("input/2024/day3.txt", 170778545),
                    new aoc.y2024.day3.Part2("input/2024/day3.txt", 82868252),
                    new aoc.y2024.day4.Part1("input/2024/day4.txt", 2578),
                    new aoc.y2024.day4.Part2("input/2024/day4.txt", 1972),
                    new aoc.y2024.day5.Part1("input/2024/day5.txt", 4905),
                    new aoc.y2024.day5.Part2("input/2024/day5.txt", 6204),
                    new aoc.y2024.day6.Part1("input/2024/day6.txt", 4776),
                    new aoc.y2024.day6.Part2("input/2024/day6.txt", 1586),
                    new aoc.y2024.day8.Part1("input/2024/day8.txt", 341),
                    new aoc.y2024.day8.Part2("input/2024/day8.txt", 1134))));

    private static <T extends AocProblem> void runAll(String label, List<T> all) throws Exception {
        var total = 0L;

        System.out.println("---------------");
        System.out.println(label);
        System.out.println("---------------");
        for (var problem : all) {
            var start = System.currentTimeMillis();
            var lines = readLines(problem.getFileName());
            var ok = true;
            var msg = "";

            try {
                problem.solve(lines);
            } catch (Exception ex) {
                ok = false;
                msg = ex.getMessage();
            }

            var diff = System.currentTimeMillis() - start;

            var result = ok ? "[OK]" : "[Failed: " + msg + "]";
            System.out.println(result + " " + problem + " " + diff + " ms");

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
            if (year.label == "2024") {
                runAll(year.label, year.problems);
            }
        }
    }
}
