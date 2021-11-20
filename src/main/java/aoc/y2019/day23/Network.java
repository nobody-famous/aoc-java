package aoc.y2019.day23;

import java.util.ArrayList;
import java.util.List;

public class Network implements Computer.Listener, Runnable {
    private List<Computer> computers = new ArrayList<>();

    private int count = 0;

    public Network(long[] prog, int numComputers) {
        for (var id = 0; id < numComputers; id += 1) {
            computers.add(new Computer(prog, id, this));
        }
    }

    private void halt() {
        for (var comp : computers) {
            comp.powerOff();
        }
    }

    @Override
    synchronized public void send(Packet packet) {
        // System.out.println("SEND " + packet);

        if (packet.addr() < 0 || packet.addr() >= computers.size()) {
            System.out.println("INVALID ADDR " + packet.addr());
            halt();
            return;
        }

        computers.get(packet.addr()).receive(packet.x(), packet.y());

        count += 1;

        if (count > 400) {
            halt();
        }
    }

    @Override
    public void run() {
        var threads = new ArrayList<Thread>();

        for (var comp : computers) {
            threads.add(new Thread(comp));
        }

        for (var thread : threads) {
            thread.start();
        }

        for (var thread : threads) {
            try {
                thread.join();
            } catch (Exception ex) {
            }
        }
    }
}
