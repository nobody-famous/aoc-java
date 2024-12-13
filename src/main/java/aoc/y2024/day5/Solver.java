package aoc.y2024.day5;

import java.util.List;

import aoc.utils.Problem;

public abstract class Solver extends Problem<Integer> {
    public Solver(String fileName, int exp) {
        super(fileName, exp);
    }

    abstract List<List<Integer>> findUpdates(PageComparator cmp, List<List<Integer>> updates);

    @Override
    public Integer run(List<String> lines) {
        var rules = new Parser().parse(lines);
        var validUpdates = findUpdates(new PageComparator(rules), rules.getUpdates());
        var answer = 0;

        for (var update : validUpdates) {
            var mid = update.size() / 2;

            answer += update.get(mid);
        }

        return answer;
    }

    protected boolean isInOrder(PageComparator cmp, List<Integer> update) {
        for (var cur = 0; cur < update.size(); cur += 1) {
            var curPage = update.get(cur);

            for (var next = cur + 1; next < update.size(); next += 1) {
                var nextPage = update.get(next);

                if (cmp.compare(curPage, nextPage) > 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
