package lol.pyr.scopescript.tokenizer;

import lol.pyr.scopescript.exception.UnknownTokenException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;

public class Tokenizer {
    private String input;
    private final List<Token> tokens = new ArrayList<>();

    public Tokenizer(String input) {
        this.input = input;
        while (this.input.length() != 0) tokens.add(cosnume());
    }

    public List<Token> getTokens() {
        return Collections.unmodifiableList(tokens);
    }

    private Token cosnume() {
        for (TokenType type : TokenType.values()) {
            Matcher matcher = type.getPattern().matcher(input.strip());
            if (matcher.find()) {
                input = matcher.replaceFirst("");
                return new Token(matcher.group().trim(), type);
            }
        }
        throw new UnknownTokenException(input);
    }
}
