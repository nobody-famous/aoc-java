package y2019.intcode;

import java.util.ArrayList;
import java.util.List;

public class Parser extends utils.Parser<List<Integer>> {
    public Parser(String fileName) {
        super(fileName);
    }

    public List<Integer> parse() {
        try {
            var lines = readLines();
            var line = lines.get(0);
            var parts = line.split(",");
            var prog = new ArrayList<Integer>();

            for (var part : parts) {
                prog.add(Integer.parseInt(part));
            }

            return prog;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
