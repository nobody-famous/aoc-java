package y2020.day14;

public class Mask implements Op {
    private String orig;
    private long onesMask;
    private long zeroesMask;

    public Mask(String m) {
        orig = m;

        for (var ndx = 0; ndx < m.length(); ndx += 1) {
            var ch = m.charAt(ndx);

            if (ch == '1') {
                onesMask += 1;
                zeroesMask += 1;
            } else if (ch == 'X') {
                zeroesMask += 1;
            }

            if (ndx < m.length() - 1) {
                onesMask <<= 1;
                zeroesMask <<= 1;
            }
        }
    }

    public String getOriginalMask() {
        return orig;
    }

    public long apply(long value) {
        var res = value;

        res &= zeroesMask;
        res |= onesMask;

        return res;
    }

    public Type getType() {
        return Type.MASK;
    }
}
