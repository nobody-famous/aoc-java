package aoc.y2019.day8;

public class Parser extends aoc.utils.Parser<Image> {
    private int width;
    private int height;

    public Parser(String fileName, int width, int height) {
        super(fileName);

        this.width = width;
        this.height = height;
    }

    public int parseLayer(Image.Layer layer, String line, int ndx) {
        for (var row = 0; row < height; row += 1) {
            for (var col = 0; col < width; col += 1) {
                var ch = line.charAt(ndx);

                layer.set(row, col, ch - '0');
                ndx += 1;
            }
        }

        return ndx;
    }

    public Image parseImage(String line) {
        var img = new Image(width, height);
        var ndx = 0;

        while (ndx < line.length()) {
            var layer = img.newLayer();

            ndx = parseLayer(layer, line, ndx);
        }

        return img;
    }

    public Image parse() {
        try {
            var lines = readLines();

            return parseImage(lines.get(0));
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
