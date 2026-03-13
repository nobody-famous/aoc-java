package aoc.y2020.day4;

import aoc.y2020.Y2020Problem;

public class Part1 extends Y2020Problem<Long> {
    private final String[][][] input;

    public Part1(String[][][] input, long expected) {
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

            switch (key.toLowerCase()) {
                case "byr" -> byr = true;
                case "iyr" -> iyr = true;
                case "eyr" -> eyr = true;
                case "hgt" -> hgt = true;
                case "hcl" -> hcl = true;
                case "ecl" -> ecl = true;
                case "pid" -> pid = true;
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
