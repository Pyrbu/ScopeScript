package lol.pyr.scopescript.test;

import lol.pyr.scopescript.ScopeImpl;
import lol.pyr.scopescript.Variable;
import lol.pyr.scopescript.api.Type;
import lol.pyr.scopescript.exception.UnknownVariableException;
import lol.pyr.scopescript.operations.PrintOperation;
import org.junit.jupiter.api.Test;

public class TestTest {

    @Test
    public void test() throws Throwable {
        ScopeImpl scope = new ScopeImpl(null, new PrintOperation(s -> {
            try {
                Variable var = s.getVariable("message");
                System.out.println(var);
                return var;
            } catch (UnknownVariableException e) {
                throw new RuntimeException(e);
            }
        }));
        scope.setVariable("message", new Variable(new Type() {}, "Hello, World!"));
        scope.execute(null);
    }

}
