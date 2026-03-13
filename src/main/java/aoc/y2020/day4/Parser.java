package aoc.y2020.day4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser implements aoc.utils.Parser<List<Map<String, String>>> {
    @Override
    public List<Map<String, String>> parse(List<String> lines) {
        var passports = new ArrayList<Map<String, String>>();
        var passport = new HashMap<String, String>();

        for (var line : lines) {
            if (line.trim().length() == 0) {
                if (passport.size() > 0) {
                    passports.add(passport);
                    passport = new HashMap<String, String>();
                }

                continue;
            }

            var pairs = line.split(" +");

            for (var pair : pairs) {
                var kv = pair.split(":");
                passport.put(kv[0].trim(), kv[1].trim());
            }
        }

        if (passport.size() > 0) {
            passports.add(passport);
        }

        return passports;
    }
}
