package y2019.day7;

public class Circuit {
    private Amp[] amps;

    public Circuit(int[] prog, int size) {
        amps = new Amp[size];

        for (var ndx = 0; ndx < size; ndx += 1) {
            amps[ndx] = new Amp(prog);
        }
    }

    public void init(int[] phases) {
        for (var ndx = 0; ndx < amps.length; ndx += 1) {
            amps[ndx].init(phases[ndx]);
        }
    }

    public int run(int signal) {
        for (var amp : amps) {
            signal = amp.runToOutput(signal);
        }

        return signal;
    }
}
