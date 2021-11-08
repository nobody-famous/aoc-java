package aoc.y2020.day4;

import aoc.utils.Problem;

public class Part1 extends Problem<Long> {
    private String[][][] input;

    public Part1(String[][][] input, long expected) {
        super(expected);
        this.input = input;
    }

    private boolean validate(String[][] entries) {
        boolean byr = false;
        boolean iyr = false;
        boolean eyr = false;
        boolean hgt = false;
        boolean hcl = false;
        boolean ecl = false;
        boolean pid = false;

        for (var entry : entries) {
            var key = entry[0];

            if (key.toLowerCase() == "byr") {
                byr = true;
            } else if (key.toLowerCase() == "iyr") {
                iyr = true;
            } else if (key.toLowerCase() == "eyr") {
                eyr = true;
            } else if (key.toLowerCase() == "hgt") {
                hgt = true;
            } else if (key.toLowerCase() == "hcl") {
                hcl = true;
            } else if (key.toLowerCase() == "ecl") {
                ecl = true;
            } else if (key.toLowerCase() == "pid") {
                pid = true;
            }
        }

        return byr && iyr && eyr && hgt && hcl && ecl && pid;
    }

    public Long run() {
        long valid = 0;

        for (var entries : input) {
            if (validate(entries)) {
                valid += 1;
            }
        }

        return valid;
    }
}
