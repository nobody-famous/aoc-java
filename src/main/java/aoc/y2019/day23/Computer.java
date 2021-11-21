package aoc.y2019.day23;

import java.util.LinkedList;
import java.util.Queue;

import aoc.y2019.intcode.Machine;

public class Computer implements Machine.IO {
    private Machine mach;
    private Long id;
    private Long sendId;
    private Long packetId;
    private Long packetX;
    private Long nextInput;
    private Packet nextPacket;
    private Queue<Packet> messages = new LinkedList<>();

    public Computer(long[] prog, long id) {
        this.mach = new Machine(prog, this);
        this.id = id;
        this.sendId = id;
    }

    public long getId() {
        return id;
    }

    public Packet runToIO() {
        if (sendId != null) {
            initId();
            return null;
        }

        if (!messages.isEmpty()) {
            sendPacket(messages.remove());
            return null;
        }

        nextInput = -1L;
        nextPacket = null;

        while (nextInput != null && nextPacket == null) {
            mach.exec();
        }

        return nextPacket;
    }

    private void sendPacket(Packet pkt) {
        sendInput(pkt.x());
        sendInput(pkt.y());
    }

    private void initId() {
        sendInput(sendId);
        sendId = null;
    }

    private void sendInput(long value) {
        nextInput = value;

        while (nextInput != null) {
            mach.exec();
        }
    }

    public void receive(Packet pkt) {
        messages.add(pkt);
    }

    @Override
    public long input() {
        if (nextInput == null) {
            throw new RuntimeException(id + " No input");
        }

        var value = nextInput.longValue();

        nextInput = null;

        return value;
    }

    private void resetPacketData() {
        packetId = null;
        packetX = null;
    }

    @Override
    public void output(long value) {
        if (packetId == null) {
            packetId = value;
        } else if (packetX == null) {
            packetX = value;
        } else {
            nextPacket = new Packet(packetId.intValue(), packetX, value);
            resetPacketData();
        }
    }
}
