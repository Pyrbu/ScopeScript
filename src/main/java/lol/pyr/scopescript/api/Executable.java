package lol.pyr.scopescript.api;

public interface Executable {
    void execute(VariableScope parent) throws Throwable;
}
