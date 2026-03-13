package aoc.y2020.day4;

import java.util.List;
import java.util.Map;

import aoc.utils.AocProblem;

public class Part1 implements AocProblem<Integer> {
    private boolean validate(Map<String, String> passport) {
        boolean byr = passport.containsKey("byr");
        boolean iyr = passport.containsKey("iyr");
        boolean eyr = passport.containsKey("eyr");
        boolean hgt = passport.containsKey("hgt");
        boolean hcl = passport.containsKey("hcl");
        boolean ecl = passport.containsKey("ecl");
        boolean pid = passport.containsKey("pid");

        return byr && iyr && eyr && hgt && hcl && ecl && pid;
    }

    @Override
    public Integer solve(List<String> lines) {
        var input = new Parser().parse(lines);
        var valid = 0;

        for (var entries : input) {
            if (validate(entries)) {
                valid += 1;
            }
        }

        return valid;
    }
}
