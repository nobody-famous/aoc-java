package y2020.day19;

import java.util.List;

public class Matcher {
    private List<Rule> rules;
    private String msg;
    private int ndx;

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

    private boolean matchAnd(AndRule rule) {
        var startNdx = ndx;

        for (var subRule : rule.getRules()) {
            if (!match(subRule)) {
                ndx = startNdx;
                return false;
            }
        }

        return true;
    }

    private boolean matchOr(OrRule rule) {
        var startNdx = ndx;
        var left = rule.getLeft();
        var right = rule.getRight();

        if (match(left)) {
            return true;
        }

        if (match(right)) {
            return true;
        }

        ndx = startNdx;
        return false;
    }

    private boolean match(Rule rule) {
        if (rule.isChar()) {
            return matchChar((CharRule) rule);
        } else if (rule.isAnd()) {
            return matchAnd((AndRule) rule);
        } else if (rule.isOr()) {
            return matchOr((OrRule) rule);
        }

        return false;
    }

    private boolean match(int ruleNdx) {
        var rule = rules.get(ruleNdx);

        return match(rule);
    }

    public boolean match() {
        return match(0) && ndx >= msg.length();
    }
}
