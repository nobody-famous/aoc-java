package y2020.day22;

public interface Input {
    Player[] sample = new Player[] { new Player(1, new int[] { 9, 2, 6, 3, 1, }),
            new Player(2, new int[] { 5, 8, 4, 7, 10, }) };

    Player[] puzzle = new Player[] {
            new Player(1,
                    new int[] { 28, 13, 25, 16, 38, 3, 14, 6, 29, 2, 47, 20, 35, 43, 30, 39, 21, 42, 50, 48, 23, 11, 34,
                            24, 41, }),
            new Player(2, new int[] { 27, 37, 9, 10, 17, 31, 19, 33, 40, 12, 32, 1, 18, 36, 49, 46, 26, 4, 45, 8, 15, 5,
                    44, 22, 7, }) };
}
