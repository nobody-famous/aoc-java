package aoc.y2019.day23;

import java.util.ArrayList;
import java.util.List;

public class Network {
    private List<Computer> computers = new ArrayList<>();
    private Long lastY;

    public Network(long[] prog, int numComputers) {
        for (var id = 0; id < numComputers; id += 1) {
            computers.add(new Computer(prog, id));
        }
    }

    public Long getLastY() {
        return lastY;
    }

    public void send(Packet packet) {
        if (packet.addr() < 0 || packet.addr() >= computers.size()) {
            lastY = packet.y();
            return;
        }

        computers.get(packet.addr()).receive(packet);
    }

    private void startAll() {
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

    private Packet processPackets(List<Packet> pkts) {
        for (var pkt : pkts) {
            var addr = pkt.addr();

            if (addr >= computers.size()) {
                return pkt;
            }

            computers.get(addr).receive(pkt);
        }

        return null;
    }

    public Packet run() {
        startAll();

        Packet stopPacket = null;

        while (stopPacket == null) {
            var pkts = nextRound();

            if (pkts.size() > 0) {
                stopPacket = processPackets(pkts);
            }
        }

        return stopPacket;
    }
}
