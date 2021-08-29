package y2019.day8;

import java.util.ArrayList;
import java.util.List;

public class Image {
    public class Layer {
        private int[][] data;
        private int[] counts;

        public Layer(int width, int height) {
            data = new int[height][width];
            counts = new int[10];
        }

        public int getCount(int value) {
            return counts[value];
        }

        public void set(int row, int col, int value) {
            data[row][col] = value;
            counts[value] += 1;
        }

        public int get(int row, int col) {
            return data[row][col];
        }
    }

    private int width;
    private int height;
    private List<Layer> layers;

    public Image(int width, int height) {
        this.width = width;
        this.height = height;
        this.layers = new ArrayList<Layer>();
    }

    public List<Layer> getLayers() {
        return layers;
    }

    public Layer newLayer() {
        var layer = new Layer(width, height);

        layers.add(layer);

        return layer;
    }
}
