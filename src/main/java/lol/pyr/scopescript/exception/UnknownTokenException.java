package lol.pyr.scopescript.exception;

public class UnknownTokenException extends RuntimeException {
    public UnknownTokenException(String input) {
        super(input);
    }
}
