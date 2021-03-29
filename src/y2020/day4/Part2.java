package y2020.day4;

public class Part2 {
    private boolean inRange(String value, int low, int high) {
        var intValue = Integer.parseInt(value);

        return intValue >= low && intValue <= high;
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

    public long solve(String[][][] input) {
        long valid = 0;

        for (var entries : input) {
            if (validate(entries)) {
                valid += 1;
            }
        }

        return valid;
    }

    public static void main(String[] args) {
        var solver = new Part2();
        var answer = solver.solve(Input.sample);

        System.out.println(answer);
    }
}
