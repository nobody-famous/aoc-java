package aoc.y2024.day13;

import java.util.List;

import aoc.utils.AocProblem;

public class Part1 implements AocProblem<Integer> {
    @Override
    public Integer solve(List<String> lines) {
        var data = new Parser().parse(lines);

        // ax*ap + bx*bp = px
        // ay*ap + by*bp = py
        System.out.println("DATA " + data);

        throw new RuntimeException("not done yet");
    }
}
