package y2020.day18;

import java.util.Stack;

public class Expression {
    private String expr;
    private int ndx;
    private Stack<Token> stack;

    public Expression(String expr) {
        this.expr = expr;
    }

    public long eval() {
        stack = new Stack<Token>();

        while (!done()) {
            skipWS();

            var ch = peek();

            if (Character.isDigit(ch)) {
                number();
            } else if (ch == '(') {
                stack.push(new OpenParen());
                consume();
            } else if (ch == ')') {
                closeParen();
            } else if (ch == '+') {
                stack.push(new Add());
                consume();
            } else if (ch == '*') {
                stack.push(new Multiply());
                consume();
            }
        }

        var token = stack.peek();

        return token.isNumber() ? ((Number) token).getValue() : 0;
    }

    private void number() {
        var num = parseNumber();

        if (stack.size() == 0 || stack.peek().isOpenParen()) {
            stack.push(new Number(num));
            return;
        }

        var token = stack.pop();
        var nextToken = stack.pop();

        if (!nextToken.isNumber()) {
            throw new RuntimeException("Popped invalid value " + nextToken);
        }

        var value = (Number) nextToken;

        if (token.isAdd()) {
            stack.push(new Number(num + value.getValue()));
        } else if (token.isMultiply()) {
            stack.push(new Number(num * value.getValue()));
        }
    }

    private long parseNumber() {
        var ch = peek();
        if (!Character.isDigit(ch)) {
            throw new RuntimeException("Invalid number " + ndx + " " + expr);
        }

        var n = 0L;

        while (Character.isDigit(ch)) {
            consume();

            n *= 10;
            n += ch - '0';

            ch = peek();
        }

        return n;
    }

    private void collapse() {
        if (stack.size() <= 1) {
            return;
        }

        var numToken = stack.pop();
        if (!numToken.isNumber()) {
            throw new RuntimeException("collapse NOT NUMBER");
        }

        var num = (Number) numToken;
        var value = num.getValue();

        var opToken = stack.peek();
        while (!stack.empty() && (opToken.isAdd() || opToken.isMultiply())) {
            stack.pop();

            numToken = stack.pop();
            if (!numToken.isNumber()) {
                throw new RuntimeException("collapse NOT NUMBER " + numToken);
            }

            num = (Number) numToken;
            if (opToken.isAdd()) {
                value += num.getValue();
            } else if (opToken.isMultiply()) {
                value *= num.getValue();
            }

            opToken = stack.empty() ? null : stack.peek();
        }

        stack.push(new Number(value));
    }

    private void closeParen() {
        consume();

        var numToken = stack.pop();
        var paren = stack.pop();

        if (!numToken.isNumber() || !paren.isOpenParen()) {
            throw new RuntimeException("closeParen INVALID TOKENS");
        }

        stack.push(numToken);
        collapse();
    }

    private void skipWS() {
        while (!done() && peek() == ' ') {
            consume();
        }
    }

    private boolean done() {
        return ndx >= expr.length();
    }

    private char peek() {
        return done() ? '\0' : expr.charAt(ndx);
    }

    private char consume() {
        if (done()) {
            return '\0';
        }

        var ch = peek();

        ndx += 1;

        return ch;
    }
}
