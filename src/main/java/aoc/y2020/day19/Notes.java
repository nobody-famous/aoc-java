package aoc.y2020.day19;

import java.util.List;

public class Notes {
    private List<Rule> rules;
    private String[] msgs;

    public Notes(List<Rule> rules, String[] msgs) {
        this.rules = rules;
        this.msgs = msgs;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public String[] getMsgs() {
        return msgs;
    }
}
