package aoc.y2019.day8;

import java.util.List;

import aoc.utils.Problem;

public class Part1 extends Problem<Integer> {
    private Parser parser = new Parser(25, 6);

    public Part1(String fileName, int exp) {
        super(fileName, exp);
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

    @Override
    public Integer run(List<String> lines) {
        var img = parser.parse(lines);
        var layers = img.getLayers();
        var layer = findFewestZeroes(layers);

        return layer.getCount(1) * layer.getCount(2);
    }
}
