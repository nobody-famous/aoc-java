package y2020.day22;

import utils.Problem;

public class Part1 implements Problem {
    private Player[] input;

    public Part1(Player[] input) {
        this.input = input;
    }

    private void playRound(Player player1, Player player2) {
        var card1 = player1.dealCard();
        var card2 = player2.dealCard();

        if (card1 > card2) {
            input[0].addCard(card1);
            input[0].addCard(card2);
        } else {
            input[1].addCard(card2);
            input[1].addCard(card1);
        }
    }

    public long solve() {
        var player1 = input[0];
        var player2 = input[1];
        Player winner;

        while (true) {
            playRound(player1, player2);

            var cards1 = player1.getCards();
            var cards2 = player2.getCards();

            if (cards1.size() == 0 || cards2.size() == 0) {
                winner = cards1.size() == 0 ? player2 : player1;
                break;
            }
        }

        var mult = winner.getCards().size();
        var cards = winner.getCards();
        var answer = 0L;

        for (var card : cards) {
            answer += card * mult;
            mult -= 1;
        }

        System.out.println(answer);
        return answer;
    }
}
