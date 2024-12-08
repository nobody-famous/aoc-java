package aoc.y2024.day6;

import java.util.HashMap;

import aoc.utils.geometry.Point;

public record Grid(HashMap<Point, Character> map, Point start) {
}
