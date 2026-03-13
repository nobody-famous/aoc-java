package aoc.y2020.day18;

import java.util.Stack;

public class Expression {
    private final String expr;
    private int ndx;
    private Stack<Token> stack;
    private final boolean usePrecedence;

    public Expression(String expr, boolean usePrecedence) {
        this.expr = expr;
        this.usePrecedence = usePrecedence;
    }

    public long eval() {
        stack = new Stack<>();

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

        collapse();

        var token = stack.peek();

        return token.isNumber() ? ((Number) token).value() : 0;
    }

    private long combine(long firstValue) {
        var top = stack.pop();
        var secondToken = stack.pop();
        var secondValue = ((Number) secondToken).value();

        if (top.isAdd()) {
            return firstValue + secondValue;
        } else if (top.isMultiply()) {
            return firstValue * secondValue;
        }

        throw new RuntimeException("combine Invalid Op");
    }

    private void number() {
        var num = parseNumber();

        if (stack.isEmpty() || stack.peek().isOpenParen()) {
            stack.push(new Number(num));
            return;
        }

        var top = stack.peek();

        if (!usePrecedence || top.isAdd()) {
            var value = combine(num);
            stack.push(new Number(value));
        } else {
            stack.push(new Number(num));
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
        var value = num.value();

        var opToken = stack.peek();
        while (!stack.empty()) {
            assert opToken != null;

            if (!(opToken.isAdd() || opToken.isMultiply())) break;
            stack.pop();

            numToken = stack.pop();
            if (!numToken.isNumber()) {
                throw new RuntimeException("collapse NOT NUMBER " + numToken);
            }

            num = (Number) numToken;
            if (opToken.isAdd()) {
                value += num.value();
            } else if (opToken.isMultiply()) {
                value *= num.value();
            }

            opToken = stack.empty() ? null : stack.peek();
        }

        stack.push(new Number(value));
    }

    private void closeParen() {
        consume();

        if (usePrecedence) {
            collapse();
        }

        var numToken = stack.pop();
        var paren = stack.pop();

        if (!numToken.isNumber() || !paren.isOpenParen()) {
            throw new RuntimeException("closeParen INVALID TOKENS");
        }

        var firstValue = ((Number) numToken).value();
        while (stack.size() > 1 && stack.peek().isAdd()) {
            firstValue = combine(firstValue);
        }

        stack.push(new Number(firstValue));

        if (!usePrecedence) {
            collapse();
        }
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

    private void consume() {
        if (done()) {
            return;
        }

        ndx += 1;
    }
}
