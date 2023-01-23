package lol.pyr.scopescript.test.interpreter;

import lol.pyr.scopescript.Scope;
import lol.pyr.scopescript.api.Executable;
import lol.pyr.scopescript.operations.AssignmentOperation;
import lol.pyr.scopescript.operations.PrintOperation;
import lol.pyr.scopescript.operations.WhileOperation;
import lol.pyr.scopescript.test.util.SystemOutUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WhileOperationTest {
    private final static int TEST_AMOUNT = 5;

    @Test
    public void whileOperationTest() throws Throwable {
        SystemOutUtil.hijack();
        new Scope(null, p1 -> new Executable[] {
            new AssignmentOperation(p1, "i", s -> 0),
            new WhileOperation(p1, s -> ((Integer) s.getVariable("i")) < TEST_AMOUNT, p2 -> new Executable[] {
                new PrintOperation(p2, s -> s.getVariable("i")),
                new AssignmentOperation(p2, "i", s -> ((Integer) s.getVariable("i")) + 1)
            })
        }).execute();
        SystemOutUtil.unHijack();
        StringBuilder expected = new StringBuilder();
        int i = 0;
        while (i < TEST_AMOUNT) {
            expected.append(i).append(System.lineSeparator());
            i++;
        }
        Assertions.assertEquals(expected.toString(), SystemOutUtil.getCapturedOut());
    }
}
