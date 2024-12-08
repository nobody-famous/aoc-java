package aoc.y2024.day6;

import java.util.HashMap;
import java.util.HashSet;

import aoc.utils.geometry.Point;

public record Grid(HashMap<Point, Character> map, HashSet<Point> walls, Point start) {
}
