package y2019.day1;

import java.util.ArrayList;
import java.util.List;

public class Parser extends utils.Parser<List<Integer>> {
    public Parser(String fileName) {
        super(fileName);
    }

    public List<Integer> parse() {
        try {
            var lines = readLines();
            var nums = new ArrayList<Integer>();

            for (var line : lines) {
                nums.add(Integer.parseInt(line));
            }

            return nums;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
