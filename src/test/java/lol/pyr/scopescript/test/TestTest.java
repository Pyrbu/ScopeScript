package lol.pyr.scopescript.test;

import lol.pyr.scopescript.tokenizer.Token;
import lol.pyr.scopescript.tokenizer.Tokenizer;
import org.junit.jupiter.api.Test;

public class TestTest {
    @Test
    public void test() {
        Tokenizer tokenizer = new Tokenizer("scope my_scope = (int a1, int b2, int c3) {}");
        for (Token token : tokenizer.getTokens()) System.out.println(token.getType().name() + ": " + token.getSequence());
    }
}
