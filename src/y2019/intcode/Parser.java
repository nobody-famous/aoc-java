package y2019.intcode;

public class Parser extends utils.Parser<int[]> {
    public Parser(String fileName) {
        super(fileName);
    }

    public int[] parse() {
        try {
            var lines = readLines();
            var line = lines.get(0);
            var parts = line.split(",");
            var prog = new int[parts.length];

            for (var ndx = 0; ndx < parts.length; ndx += 1) {
                prog[ndx] = Integer.parseInt(parts[ndx]);
            }

            return prog;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
