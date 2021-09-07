package y2019.day14;

import java.util.ArrayList;
import java.util.List;

public class Parser extends utils.Parser<List<Reaction>> {
    public Parser(String fileName) {
        super(fileName);
    }

    private Chemical parseChemical(String chem) {
        var parts = chem.split(" ");
        var amount = Integer.parseInt(parts[0]);
        var name = parts[1];

        return new Chemical(amount, name);
    }

    private Reaction parseLine(String line) {
        var parts = line.split(" => ");
        var inputs = parts[0].split(",");
        var outChem = parseChemical(parts[1]);
        var inChems = new ArrayList<Chemical>();

        for (var input : inputs) {
            inChems.add(parseChemical(input.trim()));
        }

        return new Reaction(inChems, outChem);
    }

    public List<Reaction> parse() {
        try {
            var lines = readLines();
            var reactions = new ArrayList<Reaction>();

            for (var line : lines) {
                reactions.add(parseLine(line));
            }

            return reactions;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
