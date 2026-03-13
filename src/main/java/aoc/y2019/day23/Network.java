package aoc.y2019.day23;

import java.util.ArrayList;
import java.util.List;

public class Network {
    private final List<Computer> computers = new ArrayList<>();

    public Network(long[] prog, int numComputers) {
        for (var id = 0; id < numComputers; id += 1) {
            computers.add(new Computer(prog, id));
        }
    }

    public void start() {
        for (var comp : computers) {
            comp.runToIO();
        }
    }

    private List<Packet> nextRound() {
        var packets = new ArrayList<Packet>();

        for (var comp : computers) {
            var pkt = comp.runToIO();

            if (pkt != null) {
                packets.add(pkt);
            }
        }
        return packets;
    }

    private Packet processPackets(List<Packet> packets) {
        for (var pkt : packets) {
            var address = pkt.address();

            if (address >= computers.size()) {
                return pkt;
            }

            computers.get(address).receive(pkt);
        }

        return null;
    }

    public void sendNat(Packet pkt) {
        computers.getFirst().receive(pkt);
    }

    public Packet run() {
        Packet stopPacket = null;
        var count = 0;

        while (count < 10 && stopPacket == null) {
            var packets = nextRound();

            if (!packets.isEmpty()) {
                stopPacket = processPackets(packets);
            } else {
                count += 1;
            }
        }

        return stopPacket;
    }
}
