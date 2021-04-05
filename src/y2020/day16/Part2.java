package y2020.day16;

import java.util.ArrayList;
import java.util.List;

public class Part2 extends Solver {
    private boolean isValidTicket(Ticket ticket, List<Field> fields) {
        for (var value : ticket.getValues()) {
            if (!isValid(value, fields)) {
                return false;
            }
        }

        return true;
    }

    private List<Ticket> getValidTickets(Notes input) {
        var tickets = new ArrayList<Ticket>();

        for (var ticket : input.getNearby()) {
            if (isValidTicket(ticket, input.getFields())) {
                tickets.add(ticket);
            }
        }

        return tickets;
    }

    public long solve(Notes input) {
        var tickets = getValidTickets(input);

        System.out.println(tickets);

        return 0L;
    }

    public static void main(String[] args) {
        var solver = new Part2();
        var answer = solver.solve(Input.sample);

        System.out.println(answer);
    }
}
