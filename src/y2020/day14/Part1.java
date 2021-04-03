package y2020.day14;

import java.util.Collection;
import java.util.HashMap;

public class Part1 {
    private long sumValues(Collection<Long> values) {
        var sum = 0L;

        for (var value : values) {
            sum += value;
        }

        return sum;
    }

    public long solve(Op[] prog) {
        var mem = new HashMap<Integer, Long>();
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

        return sumValues(mem.values());
    }

    public static void main(String[] args) {
        var solver = new Part1();
        var answer = solver.solve(Input.puzzle);

        System.out.println(answer);
    }
}
