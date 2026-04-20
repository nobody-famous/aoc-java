package aoc.runner;

import java.util.List;

public record Year(String label, List<Solver<?>> problems) {
}
