package aoc.y2023.day3;

import java.util.List;

public class Parser {
    public interface NumberListener {
        void foundNumber(int y, int startX, int endX, int number) throws Exception;
    }

    public interface SymbolListener {
        void foundSymbol(int y, int x, char symbol) throws Exception;
    }

    private NumberListener numberListener;
    private SymbolListener symbolListener;
    private int startNumber = -1;
    private int currentValue = 0;
    private int y = -1;

    public Parser(NumberListener numberListener, SymbolListener symbolListener) {
        if (numberListener == null || symbolListener == null) {
            throw new RuntimeException("Listeners cannot be null");
        }

        this.numberListener = numberListener;
        this.symbolListener = symbolListener;
    }

    public void parseLines(List<String> lines) throws Exception {
        for (y = 0; y < lines.size(); y++) {
            parseLine(lines.get(y));
        }
    }

    private void parseLine(String line) throws Exception {
        for (var x = 0; x < line.length(); x++) {
            var ch = line.charAt(x);

            if (Character.isDigit(ch)) {
                foundDigit(x, ch);
            } else {
                foundNonDigit(x, ch);
            }
        }
    }

    private void foundDigit(int x, char ch) {
        if (startNumber == -1) {
            startNumber = x;
        }
        currentValue = currentValue * 10 + (ch - '0');
    }

    private void foundNonDigit(int x, char ch) throws Exception {
        if (startNumber != -1) {
            numberListener.foundNumber(y, startNumber, x - 1, currentValue);
            startNumber = -1;
            currentValue = 0;
        }

        if (ch != '.') {
            symbolListener.foundSymbol(y, x, ch);
        }
    }
}
