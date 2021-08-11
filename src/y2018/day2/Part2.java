package y2018.day2;

import java.util.List;

import utils.Problem;

public class Part2 extends Problem<String> {
    private Parser parser;

    public Part2(String fileName, String exp) {
        super(exp);

        parser = new Parser(fileName);
    }

    private int countDiffs(String str1, String str2) {
        var diffs = 0;

        for (var ndx = 0; ndx < str1.length(); ndx += 1) {
            if (str1.charAt(ndx) != str2.charAt(ndx)) {
                diffs += 1;
            }
        }

        return diffs;
    }

    private String[] findDiffByOne(List<String> input, int ndx) {
        var toMatch = input.get(ndx);

        for (var ndx2 = ndx + 1; ndx2 < input.size(); ndx2 += 1) {
            if (countDiffs(toMatch, input.get(ndx2)) == 1) {
                return new String[] { toMatch, input.get(ndx2) };
            }
        }

        return null;
    }

    private String[] findDiffByOne(List<String> input) {
        for (var ndx = 0; ndx < input.size() - 1; ndx += 1) {
            var matches = findDiffByOne(input, ndx);

            if (matches != null) {
                return matches;
            }
        }

        return null;
    }

    private String removeDiffs(String[] matches) {
        var ndx = 0;

        while (matches[0].charAt(ndx) == matches[1].charAt(ndx)) {
            ndx += 1;
        }

        return matches[0].substring(0, ndx) + matches[0].substring(ndx + 1);
    }

    @Override
    public String run() {
        var input = parser.parse();
        var matches = findDiffByOne(input);
        var answer = removeDiffs(matches);

        return answer;
    }
}
