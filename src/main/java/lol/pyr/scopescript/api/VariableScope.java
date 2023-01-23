package lol.pyr.scopescript.api;

import lol.pyr.scopescript.exception.UnknownVariableException;

public interface VariableScope {
    Object getVariable(String identifier) throws UnknownVariableException;
    void setVariable(String identifier, Object member);
    boolean setVariableIfExists(String identifier, Object member);
}
