package y2020.day14;

import java.util.HashMap;

public class Part1 extends Solver {
    public Part1(Op[] prog, long expected) {
        super(prog, expected);
    }

    public Long run() {
        var mem = new HashMap<Long, Long>();
        Mask curMask = null;

        for (var op : prog) {
            if (op.getType() == Op.Type.MASK) {
                curMask = (Mask) op;
            } else if (op.getType() == Op.Type.MEMORY) {
                var memOp = (Memory) op;
                var addr = memOp.getAddr();
                var value = curMask.apply(memOp.getValue());

                mem.put(addr, value);
            }
        }

        var answer = sumValues(mem.values());

        return answer;
    }
}
