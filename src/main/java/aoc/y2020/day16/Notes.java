package aoc.y2020.day16;

import java.util.List;

public record Notes(List<Field> fields, Ticket mine, List<Ticket> nearby) {
}
