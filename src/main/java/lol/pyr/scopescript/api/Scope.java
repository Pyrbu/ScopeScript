package lol.pyr.scopescript.api;

import lol.pyr.scopescript.Variable;
import lol.pyr.scopescript.exception.UnknownVariableException;

public interface Scope {
    Variable getVariable(String identifier) throws UnknownVariableException;
    void setVariable(String identifier, Variable member);
}
