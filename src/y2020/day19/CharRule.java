package y2020.day19;

public class CharRule implements Rule {
    private char ch;

    public CharRule(char ch) {
        this.ch = ch;
    }

    public boolean isChar() {
        return true;
    }

    public char getChar() {
        return ch;
    }

    public String toString() {
        return "CharRule(" + ch + ")";
    }
}
