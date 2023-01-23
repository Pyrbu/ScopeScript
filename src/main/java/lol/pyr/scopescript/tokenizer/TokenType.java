package lol.pyr.scopescript.tokenizer;

import lombok.Getter;

import java.util.regex.Pattern;

public enum TokenType {
    // general syntax
    DELIMITER(","),
    IDENTIFIER("[a-zA-Z_][a-zA-Z0-9_]*"),
    START_BLOCK("\\{"),
    END_BLOCK("\\}"),
    START_CLAUSE("\\("),
    END_CLAUSE("\\)"),
    ASSIGNMENT("="),

    // arithmetic operations
    ADDITION("\\+"),
    SUBTRACTION("\\-"),
    MULTIPLICATION("\\*"),
    DIVISION("\\\\"),
    EXPONENTIATION("\\^"),

    // numbers
    REAL("[0-9]+.[0-9]*"),
    INTEGER("[0-9]+"),

    // boolean operators
    OR("[oO][rR]|\\|\\|"),
    AND("[aA][nN][dD]|&&"),
    EQUALS("[iI][sS]|=="),
    NOT("[nN][oO][tT]|!"),
    NOT_EQUALS("!=");

    @Getter
    private final Pattern pattern;

    TokenType(String regex) {
        this.pattern = Pattern.compile("^(" + regex + ")");
    }
}