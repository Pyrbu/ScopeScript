package lol.pyr.scopescript.test.util;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SystemOutUtil {
    private static boolean hijacked = false;

    private static PrintStream originalOut;
    private static PrintStream originalErr;

    private final static ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final static ByteArrayOutputStream err = new ByteArrayOutputStream();

    public static void hijack() {
        resetBuffers();
        if (hijacked) return;
        hijacked = true;
        originalOut = System.out;
        originalErr = System.err;
        System.setOut(new PrintStream(out));
        System.setErr(new PrintStream(err));
    }

    public static void unHijack() {
        if (!hijacked) return;
        hijacked = false;
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    public static String getCapturedOut() {
        return out.toString();
    }

    public static String getCapturedErr() {
        return err.toString();
    }

    public static void resetBuffers() {
        out.reset();
        err.reset();
    }
}
