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
            var nextSignal = amp.runToOutput(signal);

            if (nextSignal != null) {
                signal = nextSignal;
            }
        }

        return signal;
    }

    public int runFeedback(int signal) {
        while (!amps[amps.length - 1].isDone()) {
            signal = run(signal);
        }

        return signal;
    }
}
