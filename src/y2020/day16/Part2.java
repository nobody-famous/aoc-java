package y2020.day16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private Map<String, Boolean> initNameMap(List<Field> fields) {
        var candMap = new HashMap<String, Boolean>();

        for (var field : fields) {
            candMap.put(field.getName(), true);
        }

        return candMap;
    }

    private List<Map<String, Boolean>> initCandidates(List<Field> fields) {
        var candidates = new ArrayList<Map<String, Boolean>>();

        for (var loop = 0; loop < fields.size(); loop += 1) {
            candidates.add(initNameMap(fields));
        }

        return candidates;
    }

    private void removeCandidate(List<Map<String, Boolean>> candidates, String name) {
        for (var ndx = 0; ndx < candidates.size(); ndx += 1) {
            var candMap = candidates.get(ndx);

            if (candMap.keySet().size() <= 1) {
                continue;
            }

            candMap.remove(name);

            if (candMap.keySet().size() == 1) {
                var toRemove = candMap.keySet().iterator().next();
                removeCandidate(candidates, toRemove);
            }
        }
    }

    private void updateCandidates(List<Map<String, Boolean>> candidates, List<Field> fields, List<Long> values) {
        for (var valueNdx = 0; valueNdx < values.size(); valueNdx += 1) {
            var value = values.get(valueNdx);

            for (var fieldNdx = 0; fieldNdx < fields.size(); fieldNdx += 1) {
                var field = fields.get(fieldNdx);

                if (!inField(value, field)) {
                    var candidateMap = candidates.get(valueNdx);

                    candidateMap.remove(field.getName());
                    if (candidateMap.size() == 1) {
                        var toRemove = candidateMap.keySet().iterator().next();

                        removeCandidate(candidates, toRemove);
                    }
                }
            }
        }
    }

    private List<String> candidatesToNames(List<Map<String, Boolean>> candidates) {
        var names = new ArrayList<String>();

        for (var candMap : candidates) {
            if (candMap.size() != 1) {
                System.out.println(candidates);
                throw new RuntimeException("Invalid candidates");
            }

            var name = candMap.keySet().iterator().next();

            names.add(name);
        }

        return names;
    }

    private long multiplyValues(List<String> names, Ticket mine) {
        var sum = 1L;

        for (var ndx = 0; ndx < names.size(); ndx += 1) {
            var name = names.get(ndx);

            if (name.startsWith("departure")) {
                sum *= mine.getValues().get(ndx);
            }
        }

        return sum;
    }

    public long solve(Notes input) {
        var tickets = getValidTickets(input);
        var candidates = initCandidates(input.getFields());

        for (var ticket : tickets) {
            updateCandidates(candidates, input.getFields(), ticket.getValues());
        }

        var names = candidatesToNames(candidates);

        return multiplyValues(names, input.getMine());
    }

    public static void main(String[] args) {
        var solver = new Part2();
        var answer = solver.solve(Input.puzzle);

        System.out.println(answer);
    }
}
