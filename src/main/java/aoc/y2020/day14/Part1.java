package aoc.y2020.day14;

import java.util.HashMap;
import java.util.List;

public class Part1 extends Solver {
    @Override
    public Long solve(List<String> lines) {
        var prog = new Parser().parse(lines);
        var mem = new HashMap<Long, Long>();
        Mask curMask = null;

        for (var op : prog) {
            if (op.getType() == Op.Type.MASK) {
                curMask = (Mask) op;
            } else if (op.getType() == Op.Type.MEMORY) {
                assert curMask != null;

                var memOp = (Memory) op;
                var address = memOp.address();
                var value = curMask.apply(memOp.value());

                mem.put(address, value);
            }
        }

        return sumValues(mem.values());
    }
}
