package y2019.day8;

import java.util.List;

import utils.Problem;

public class Part1 extends Problem<Integer> {
    private Parser parser;

    public Part1(String fileName, int exp) {
        super(exp);

        parser = new Parser(fileName, 25, 6);
    }

    private Image.Layer findFewestZeroes(List<Image.Layer> layers) {
        Image.Layer layer = null;

        for (var candidate : layers) {
            if (layer == null || candidate.getCount(0) < layer.getCount(0)) {
                layer = candidate;
            }
        }

        return layer;
    }

    public Integer run() {
        var img = parser.parse();
        var layers = img.getLayers();
        var layer = findFewestZeroes(layers);

        return layer.getCount(1) * layer.getCount(2);
    }
}
