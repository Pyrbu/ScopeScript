package lol.pyr.scopescript.api;

import lol.pyr.scopescript.Variable;
import lol.pyr.scopescript.exception.UnknownVariableException;

public interface VariableScope {
    Variable getVariable(String identifier) throws UnknownVariableException;
    void setVariable(String identifier, Variable member);
    boolean setVariableIfExists(String identifier, Variable member);
}
