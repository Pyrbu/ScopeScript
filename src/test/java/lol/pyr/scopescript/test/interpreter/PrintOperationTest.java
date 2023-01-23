package lol.pyr.scopescript.test.interpreter;

import lol.pyr.scopescript.operations.PrintOperation;
import lol.pyr.scopescript.test.util.SystemOutUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrintOperationTest {
    private final static String TEST_STR = "Hello, World!";

    @Test
    public void printOperationTest() throws Throwable {
        SystemOutUtil.hijack();
        new PrintOperation(null, s -> TEST_STR).execute();
        SystemOutUtil.unHijack();
        Assertions.assertEquals(TEST_STR + System.lineSeparator(), SystemOutUtil.getCapturedOut());
    }
}
