package aoc.y2019.day18;

import java.util.HashMap;
import java.util.HashSet;

import aoc.utils.geometry.Point;

public class Grid {
    public HashSet<Point> spaces = new HashSet<>();
    public HashSet<Point> entrances = new HashSet<>();
    public HashMap<Point, Character> keys = new HashMap<>();
    public HashMap<Point, Character> doors = new HashMap<>();
    public HashMap<Character, Integer> masks = new HashMap<>();
    public int allMasks = 0;

    public Grid() {
        var mask = 1;

        for (var ch = 'a'; ch <= 'z'; ch += 1) {
            var upper = Character.toUpperCase(ch);

            masks.put(ch, mask);
            masks.put(upper, mask);

            mask = mask << 1;
        }
    }
}
