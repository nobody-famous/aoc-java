package aoc.y2019.day23;

import java.util.LinkedList;
import java.util.Queue;

import aoc.y2019.intcode.Machine;

public class Computer implements Machine.IO, Runnable {
    private Machine mach;
    private Listener listener;
    private long id;
    private Long packetId;
    private Long packetX;
    private boolean poweredOn;
    private Queue<Long> messages = new LinkedList<>();

    public interface Listener {
        void send(Packet packet);
    }

    public Computer(long[] prog, long id, Listener listener) {
        this.mach = new Machine(prog, this);
        this.id = id;
        this.listener = listener;
        this.poweredOn = false;
    }

    @Override
    public void run() {
        messages.add(id);
        poweredOn = true;

        while (poweredOn && !mach.isHalted()) {
            mach.exec();
        }
    }

    public void powerOff() {
        poweredOn = false;
    }

    synchronized public void receive(long x, long y) {
        messages.add(y);
        messages.add(x);
    }

    @Override
    synchronized public long input() {
        var value = messages.isEmpty() ? -1L : messages.remove();

        return value;
    }

    private void resetPacketData() {
        packetId = null;
        packetX = null;
    }

    @Override
    synchronized public void output(long value) {
        if (packetId == null) {
            packetId = value;
        } else if (packetX == null) {
            packetX = value;
        } else {
            listener.send(new Packet(packetId.intValue(), packetX, value));
            resetPacketData();
        }
    }
}
