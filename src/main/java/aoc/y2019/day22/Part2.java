package aoc.y2019.day22;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

import aoc.utils.Problem;

public class Part2 extends Problem<Long> {
    private Parser parser = new Parser();

    public Part2(String fileName, long exp) {
        super(fileName, exp);
    }

    @Override
    public Long run(List<String> lines) {
        var shuffler = parser.parse(lines);
        var size = BigInteger.valueOf(119315717514047L);
        var iters = BigInteger.valueOf(101741582076661L);
        var steps = shuffler.getTechniques();
        var startPos = BigInteger.valueOf(2020L);

        var pos = startPos;
        var a = BigInteger.ONE;
        var b = BigInteger.ZERO;

        Collections.reverse(steps);

        var oldPos = pos;
        a = BigInteger.ONE;
        b = BigInteger.ZERO;

        for (var step : steps) {
            if (pos.compareTo(BigInteger.ZERO) < 0 || pos.compareTo(size) >= 0) {
                throw new RuntimeException("Invalid pos " + pos);
            }

            if (step instanceof DealStack) {
                pos = size.subtract(BigInteger.ONE).subtract(pos);
                a = a.negate();
                b = b.negate().add(size).subtract(BigInteger.ONE);
            } else if (step instanceof CutCards) {
                var cut = (CutCards) step;
                var n = BigInteger.valueOf(cut.getNumCards());

                if (n.compareTo(BigInteger.ZERO) < 0) {
                    n = size.subtract(n.abs());
                }

                pos = (pos.add(n)).mod(size);
                b = b.add(n);
            } else if (step instanceof DealIncrement) {
                var deal = (DealIncrement) step;
                var n = BigInteger.valueOf(deal.getIncrement());
                var ninv = n.modInverse(size);

                a = a.multiply(ninv);
                b = b.multiply(ninv);
                pos = (ninv.multiply(pos)).mod(size);
            }
        }

        a = a.mod(size);
        b = b.mod(size);

        if (pos.compareTo((a.multiply(oldPos).add(b)).mod(size)) != 0) {
            throw new RuntimeException("Check failed");
        }

        var pow = a.modPow(iters, size);
        var inv = a.subtract(BigInteger.ONE).modInverse(size);
        var f = startPos.multiply(pow);
        var g = pow.subtract(BigInteger.ONE).multiply(b).multiply(inv);
        var ans = f.add(g).mod(size);

        return ans.longValue();
    }
}
