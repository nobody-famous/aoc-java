package aoc.y2019.day1;

import java.util.ArrayList;
import java.util.List;

public class Parser extends aoc.utils.Parser<List<Integer>> {
    public List<Integer> parse(List<String> lines) {
        try {
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
