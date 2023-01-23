package lol.pyr.scopescript.tokenizer;

import lombok.Getter;

public class Token {
    @Getter
    private final String sequence;
    @Getter private final TokenType type;

    public Token(String sequence, TokenType type) {
        this.sequence = sequence;
        this.type = type;
    }
}