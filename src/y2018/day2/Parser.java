package y2018.day2;

import java.util.List;

public class Parser extends utils.Parser<List<String>> {
    public Parser(String fileName) {
        super(fileName);
    }

    @Override
    public List<String> parse() {
        try {
            return readLines();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
