package y2020.day13;

public class Part2 {
    public long solve(Notes input) {
        var firstStep = 7;
        var secondStep = 13;
        var thirdStep = 59;
        var fourthStep = 31;
        var fifthStep = 19;

        var first = firstStep;
        var second = secondStep;
        var third = thirdStep;
        var fourth = fourthStep;
        var fifth = fifthStep;

        for (var loop = 0; loop < 10000000; loop += 1) {
            if (second == (first + 1) && third == (first + 4) && fourth == (first + 6) && fifth == (first + 7)) {
                System.out.println(first + " " + second);
            }

            first += firstStep;

            if (first > second) {
                second += secondStep;
            }
            if (second > third) {
                third += thirdStep;
            }
            if (third > fourth) {
                fourth += fourthStep;
            }
            if (fourth > fifth) {
                fifth += fifthStep;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        var solver = new Part2();
        var answer = solver.solve(Input.sample);

        System.out.println(answer);
    }
}

// When first and second line up,
//   step = first times second
//   new second = first x second
//   new first = next number
