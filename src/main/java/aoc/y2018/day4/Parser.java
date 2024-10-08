package aoc.y2018.day4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser extends aoc.utils.Parser<List<GuardRecord>> {
    private Matcher beginShift;
    private Matcher fallAsleep;
    private Matcher wakesUp;

    public Parser() {
        var dateStr = "\\[(\\d\\d\\d\\d)-(\\d\\d)-(\\d\\d) (\\d\\d):(\\d\\d)\\]";
        var beginShiftRegex = Pattern.compile(dateStr + " Guard #(\\d+) begins shift");
        var fallAsleepRegex = Pattern.compile(dateStr + " falls asleep");
        var wakesUpRegex = Pattern.compile(dateStr + " wakes up");

        beginShift = beginShiftRegex.matcher("");
        fallAsleep = fallAsleepRegex.matcher("");
        wakesUp = wakesUpRegex.matcher("");
    }

    @Override
    public List<GuardRecord> parse(List<String> lines) {
        try {
            var records = parseRecords(lines);

            records.sort(new Comparator<GuardRecord>() {
                public int compare(GuardRecord o1, GuardRecord o2) {
                    if (o1.date.year() != o2.date.year()) {
                        return o1.date.year() > o2.date.year() ? 1 : -1;
                    } else if (o1.date.month() != o2.date.month()) {
                        return o1.date.month() > o2.date.month() ? 1 : -1;
                    } else if (o1.date.day() != o2.date.day()) {
                        return o1.date.day() > o2.date.day() ? 1 : -1;
                    } else if (o1.date.hour() != o2.date.hour()) {
                        return o1.date.hour() > o2.date.hour() ? 1 : -1;
                    } else if (o1.date.minute() != o2.date.minute()) {
                        return o1.date.minute() > o2.date.minute() ? 1 : -1;
                    }

                    return 0;
                };
            });

            return records;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private List<GuardRecord> parseRecords(List<String> lines) {
        var records = new ArrayList<GuardRecord>();

        for (var line : lines) {
            beginShift.reset(line);
            fallAsleep.reset(line);
            wakesUp.reset(line);

            if (beginShift.matches()) {
                records.add(toBeginShift());
            } else if (fallAsleep.matches()) {
                records.add(toFallAsleep());
            } else if (wakesUp.matches()) {
                records.add(toWakesUp());
            } else {
                throw new RuntimeException("Failed to match: " + line);
            }
        }

        return records;
    }

    private RecordDate toDate(Matcher match) {
        var year = Integer.parseInt(match.group(1));
        var month = Integer.parseInt(match.group(2));
        var day = Integer.parseInt(match.group(3));
        var hour = Integer.parseInt(match.group(4));
        var minute = Integer.parseInt(match.group(5));

        return new RecordDate(year, month, day, hour, minute);
    }

    private BeginShiftRecord toBeginShift() {
        var date = toDate(beginShift);
        var guard = Integer.parseInt(beginShift.group(6));

        return new BeginShiftRecord(date, guard);
    }

    private FallAsleepRecord toFallAsleep() {
        var date = toDate(fallAsleep);

        return new FallAsleepRecord(date);
    }

    private WakesUpRecord toWakesUp() {
        var date = toDate(wakesUp);

        return new WakesUpRecord(date);
    }
}
