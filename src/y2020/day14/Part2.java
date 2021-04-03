package y2020.day14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Part2 extends Solver {
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

    public List<Mask> permutations(String mask) {
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

        var perms = new ArrayList<Mask>();
        for (var builder : permsBuilder) {
            perms.add(new Mask(builder.toString()));
        }

        return perms;
    }

    private void updateMem(Map<Long, Long> mem, List<Mask> masks, long addr, long value) {
        for (var mask : masks) {
            var target = mask.apply(addr);
            mem.put(target, value);
        }
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

    public long solve(Op[] prog) {
        var mem = new HashMap<Long, Long>();
        List<Mask> curMasks = null;

        for (var op : prog) {
            if (op.getType() == Op.Type.MEMORY) {
                var memOp = (Memory) op;
                updateMem(mem, curMasks, memOp.getAddr(), memOp.getValue());
            } else if (op.getType() == Op.Type.MASK) {
                var maskOp = (Mask) op;
                curMasks = permutations(maskOp.getOriginalMask());
            }
        }

        System.out.println(sumValues(mem.values()));
        return 0L;
    }

    public static void main(String[] args) {
        var solver = new Part2();
        // var answer = solver.solve(Input.sample2);

        // System.out.println(answer);

        System.out.println(solver.updateMask("00000000000000000000000000000000X0XX", Integer.toBinaryString(26)));
    }
}
