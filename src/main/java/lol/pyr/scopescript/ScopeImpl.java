package lol.pyr.scopescript;

import lol.pyr.scopescript.api.Executable;
import lol.pyr.scopescript.api.VariableScope;
import lol.pyr.scopescript.exception.UnknownVariableException;

import java.util.HashMap;
import java.util.Map;

public class ScopeImpl implements VariableScope, Executable {
    private final VariableScope parent;
    private final Map<String, Variable> memberMap = new HashMap<>();
    private final Executable[] operations;

    public ScopeImpl(VariableScope parent, Executable... operations) {
        this.parent = parent;
        this.operations = operations;
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

    public boolean setVariableIfExists(String identifier, Variable member) {
        if (!memberMap.containsKey(identifier)) {
            if (parent != null) return parent.setVariableIfExists(identifier, member);
            return false;
        }
        memberMap.put(identifier, member);
        return true;
    }

    @Override
    public void execute(VariableScope parent) throws Throwable {
        for (Executable op : operations) op.execute(this);
    }
}
