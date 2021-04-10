package y2020.day19;

import utils.Problem;

public class Part1 implements Problem {
    private Notes input;

    public Part1(Notes input) {
        this.input = input;
    }

    public long solve() {
        var answer = 0L;

        for (var msg : input.getMsgs()) {
            var m = new Matcher(input.getRules(), msg);

            if (m.match()) {
                answer += 1;
            }
        }

        System.out.println(answer);
        return answer;
    }
}
