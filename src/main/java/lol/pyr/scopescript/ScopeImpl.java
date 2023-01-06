package lol.pyr.scopescript;

import lol.pyr.scopescript.api.Scope;
import lol.pyr.scopescript.exception.UnknownVariableException;

import java.util.HashMap;
import java.util.Map;

public class ScopeImpl implements Scope {
    private final ScopeImpl parent;
    private final Map<String, Variable> memberMap = new HashMap<>();

    public ScopeImpl(ScopeImpl parent) {
        this.parent = parent;
    }

    public ScopeImpl() {
        this.parent = null;
    }

    public Variable getVariable(String identifier) throws UnknownVariableException {
        if (!memberMap.containsKey(identifier)) {
            if (parent == null) throw new UnknownVariableException();
            return parent.getVariable(identifier);
        }
        return memberMap.get(identifier);
    }

    public void setVariable(String identifier, Variable member) {
        if (!setVariableIfExists(identifier, member)) memberMap.put(identifier, member);
    }

    private boolean setVariableIfExists(String identifier, Variable member) {
        if (!memberMap.containsKey(identifier)) {
            if (parent != null) return parent.setVariableIfExists(identifier, member);
            return false;
        }
        setVariable(identifier, member);
        return true;
    }
}
