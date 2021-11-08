package aoc.y2020.day14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Part2 extends Solver {
    public Part2(Op[] prog, long expected) {
        super(prog, expected);
    }

    private void appendChar(List<StringBuilder> builders, char ch) {
        for (var builder : builders) {
            builder.append(ch);
        }
    }

    private List<StringBuilder> copyBuilders(List<StringBuilder> builders) {
        var copy = new ArrayList<StringBuilder>();

        for (var builder : builders) {
            copy.add(new StringBuilder(builder.toString()));
        }

        return copy;
    }

    public List<Long> permutations(String mask) {
        var permsBuilder = new ArrayList<StringBuilder>();

        permsBuilder.add(new StringBuilder());

        for (var ch : mask.toCharArray()) {
            if (ch == '0' || ch == '1') {
                appendChar(permsBuilder, ch);
            } else if (ch == 'X') {
                var copy = copyBuilders(permsBuilder);
                appendChar(copy, '0');
                appendChar(permsBuilder, '1');
                permsBuilder.addAll(copy);
            }
        }

        var perms = new ArrayList<Long>();
        for (var builder : permsBuilder) {
            perms.add(Long.parseLong(builder.toString(), 2));
        }

        return perms;
    }

    public String updateMask(String orig, String update) {
        var mask = orig.toCharArray();
        var origNdx = orig.length() - update.length();

        for (var ndx = 0; ndx < update.length(); ndx += 1) {
            var ch = update.charAt(ndx);
            var origCh = orig.charAt(origNdx);

            if (origCh == '0') {
                mask[origNdx] = ch;
            } else if (origCh == '1' || origCh == 'X') {
                mask[origNdx] = origCh;
            }

            origNdx += 1;
        }

        return new String(mask);
    }

    public Long run() {
        var mem = new HashMap<Long, Long>();
        Mask curMask = null;

        for (var op : prog) {
            if (op.getType() == Op.Type.MEMORY) {
                var memOp = (Memory) op;
                var update = updateMask(curMask.getOriginalMask(), Long.toBinaryString(memOp.getAddr()));
                var perms = permutations(update);

                for (var perm : perms) {
                    mem.put(perm, memOp.getValue());
                }
            } else if (op.getType() == Op.Type.MASK) {
                curMask = (Mask) op;
            }
        }

        var answer = sumValues(mem.values());

        return answer;
    }
}
