package aoc.y2020.day4;

import aoc.y2020.Y2020Problem;

public class Part2 extends Y2020Problem<Long> {
    private String[][][] input;

    public Part2(String[][][] input, long expected) {
        super(expected);
        this.input = input;
    }

    private boolean inRange(String value, int low, int high) {
        var intValue = Integer.parseInt(value);

        return intValue >= low && intValue <= high;
    }

    private boolean validateHeight(String height) {
        var num = height.substring(0, height.length() - 2);
        var type = height.substring(height.length() - 2);

        if ("cm".equals(type)) {
            return inRange(num, 150, 193);
        } else if ("in".equals(type)) {
            return inRange(num, 59, 76);
        }

        return false;
    }

    private boolean isHex(char ch) {
        return ('0' <= ch && ch <= '9') || ('a' <= ch && ch <= 'f');
    }

    private boolean validateHair(String value) {
        if (value.length() != 7) {
            return false;
        }

        for (var i = 1; i < value.length(); i += 1) {
            var ch = value.charAt(i);

            if (!isHex(ch)) {
                return false;
            }
        }

        return true;
    }

    private boolean valideEyeColor(String value) {
        return ("amb".equals(value) || "blu".equals(value) || "brn".equals(value) || "gry".equals(value)
                || "grn".equals(value) || "hzl".equals(value) || "oth".equals(value));
    }

    private boolean validatePID(String value) {
        if (value.length() != 9) {
            return false;
        }

        for (var ch : value.toCharArray()) {
            if (ch < '0' || ch > '9') {
                return false;
            }
        }

        return true;
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
            var value = entry[1];

            if (key.toLowerCase() == "byr") {
                byr = inRange(value, 1920, 2020);
            } else if (key.toLowerCase() == "iyr") {
                iyr = inRange(value, 2010, 2020);
            } else if (key.toLowerCase() == "eyr") {
                eyr = inRange(value, 2020, 2030);
            } else if (key.toLowerCase() == "hgt") {
                hgt = validateHeight(value);
            } else if (key.toLowerCase() == "hcl") {
                hcl = validateHair(value);
            } else if (key.toLowerCase() == "ecl") {
                ecl = valideEyeColor(value);
            } else if (key.toLowerCase() == "pid") {
                pid = validatePID(value);
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
