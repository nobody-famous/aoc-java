package aoc.y2024.day17;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class ReverseComputer {
    private record State(List<Integer> program, long a, long b, long c, int pc, int nextInput) {
    }

    private List<Integer> input;

    public ReverseComputer(List<Integer> input) {
        this.input = input;
    }

    public List<Long> run(List<Integer> program) {
        var values = new ArrayList<Long>();
        var states = new ArrayDeque<State>(List.of(new State(program, 0, 0, 0, program.size() - 2, 0)));
        var count = 0;

        System.out.println("CHECKING " + bst(new State(program, 0xff, 0x3, 0, 0, 0), 0));
        while (!states.isEmpty()) {
            count = Utils.checkCount(count, Utils.MAX_LOOPS);

            var state = states.pop();

            // System.out.println("STATE " + stbsate);
            if (state.pc() < 0) {
                values.add(state.a());
            } else {
                states.addAll(exec(state));
            }
        }

        return values;
    }

    private List<State> exec(State state) {
        var nextStates = new ArrayList<State>();
        var opcode = state.program.get(state.pc());
        var operand = state.program.get(state.pc() + 1);

        switch (opcode) {
        case Computer.CMD_ADV:
            nextStates.addAll(adv(state, operand));
            break;
        case Computer.CMD_BXL:
            nextStates.add(decrementPC(new State(state.program(), state.a(), state.b() ^ operand, state.c(), state.pc(), state.nextInput())));
            break;
        case Computer.CMD_BST:
            nextStates.addAll(bst(state, operand));
            break;
        case Computer.CMD_JNZ:
            nextStates.add(decrementPC(state));
            break;
        case Computer.CMD_BXC:
            nextStates.add(decrementPC(new State(state.program(), state.a(), state.b() ^ state.c(), state.c(), state.pc(), state.nextInput())));
            break;
        case Computer.CMD_OUT:
            nextStates.addAll(out(state, operand));
            break;
        case Computer.CMD_BDV:
            nextStates.addAll(bdv(state, operand));
            break;
        case Computer.CMD_CDV:
            nextStates.addAll(cdv(state, operand));
            break;
        default:
            throw new RuntimeException("Unhandled opcode: " + opcode);
        }

        return nextStates;
    }

    private List<State> bst(State state, int op) {
        var nextStates = new ArrayList<State>();
        var aValue = (state.a() >> 3) << 3;

        aValue += state.b() & 0x7;

        nextStates.add(decrementPC(new State(state.program(), aValue, state.b(), state.c(), state.pc(), state.nextInput())));

        return nextStates;
    }

    private List<State> adv(State state, int op) {
        var nextStates = new ArrayList<State>();
        var shift = 1 << combo(state, op);
        var base = state.a() * shift;

        for (var add = 0; add < shift; add++) {
            nextStates.add(decrementPC(new State(state.program(), base + add, state.b(), state.c(), state.pc(), state.nextInput())));
        }

        return nextStates;
    }

    private List<State> bdv(State state, int op) {
        var nextStates = new ArrayList<State>();
        var shift = 1 << combo(state, op);
        var base = state.b() * shift;

        for (var add = 0; add < shift; add++) {
            nextStates.add(decrementPC(new State(state.program(), base + add, state.b(), state.c(), state.pc(), state.nextInput())));
        }

        return nextStates;
    }

    private List<State> cdv(State state, int op) {
        var nextStates = new ArrayList<State>();
        var shift = 1 << combo(state, op);
        var base = state.c() * shift;

        for (var add = 0; add < shift; add++) {
            nextStates.add(decrementPC(new State(state.program(), base + add, state.b(), state.c(), state.pc(), state.nextInput())));
        }

        return nextStates;
    }

    private List<State> out(State state, int operand) {
        if (state.nextInput() >= input.size()) {
            return List.of();
        }

        var target = this.input.get(state.nextInput());
        var value = combo(state, operand);

        if (value % 8 != target) {
            return List.of();
        }

        return List.of(decrementPC(new State(state.program(), state.a(), state.b(), state.c(), state.pc(), state.nextInput() + 1)));
    }

    private State decrementPC(State state) {
        var newPC = (state.pc == 0 && state.nextInput() < input.size())
                ? state.program().size() - 2
                : state.pc - 2;

        return new State(state.program(), state.a(), state.b(), state.c(), newPC, state.nextInput());
    }

    private long combo(State state, int op) {
        return switch (op) {
        case 0, 1, 2, 3 -> op;
        case 4 -> state.a;
        case 5 -> state.b;
        case 6 -> state.c;
        default -> throw new RuntimeException("Invalid combo op: " + op);
        };
    }
}
