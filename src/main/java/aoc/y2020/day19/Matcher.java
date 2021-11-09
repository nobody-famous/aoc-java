package aoc.y2020.day19;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Matcher {
    private List<Rule> rules;
    private String msg;
    private int ndx;
    private boolean done;

    public Matcher(List<Rule> rules, String msg) {
        this.rules = rules;
        this.msg = msg;
    }

    private boolean matchChar(CharRule rule) {
        if (msg.charAt(ndx) == rule.getChar()) {
            ndx += 1;
            return true;
        }

        return false;
    }

    private boolean matchAnd(AndRule rule, Deque<Rule> rest) {
        var startNdx = ndx;
        var copy = new ArrayDeque<Rule>();

        for (var subRule : rule.getRules()) {
            copy.add(rules.get(subRule));
        }

        copy.addAll(rest);

        if (match(copy)) {
            return true;
        }

        ndx = startNdx;

        return false;
    }

    private boolean matchOr(OrRule rule, Deque<Rule> rest) {
        var startNdx = ndx;
        var left = rule.getLeft();
        var right = rule.getRight();

        var copy = new ArrayDeque<Rule>();

        copy.add(left);
        copy.addAll(rest);

        if (match(copy)) {
            return true;
        }

        copy = new ArrayDeque<Rule>();
        copy.add(right);
        copy.addAll(rest);

        if (match(copy)) {
            return true;
        }

        ndx = startNdx;
        return false;
    }

    private boolean match(Deque<Rule> rules) {
        while (!done && !rules.isEmpty()) {
            var rule = rules.removeFirst();

            if (ndx >= msg.length()) {
                return false;
            }

            if (rule.isChar()) {
                if (!matchChar((CharRule) rule)) {
                    return false;
                }
            } else if (rule.isAnd()) {
                if (!matchAnd((AndRule) rule, rules)) {
                    return false;
                }
            } else if (rule.isOr()) {
                if (!matchOr((OrRule) rule, rules)) {
                    return false;
                }
            }
        }

        done = true;

        return true;
    }

    private boolean match(int ruleNdx) {
        var rule = rules.get(ruleNdx);
        var rules = new ArrayDeque<Rule>();

        rules.add(rule);

        return match(rules);
    }

    public boolean match() {
        done = false;
        return match(0) && ndx >= msg.length();
    }
}
