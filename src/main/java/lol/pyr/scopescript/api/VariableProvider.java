package lol.pyr.scopescript.api;

import lol.pyr.scopescript.Variable;

public interface VariableProvider {
    Variable get(VariableScope scope);
}
