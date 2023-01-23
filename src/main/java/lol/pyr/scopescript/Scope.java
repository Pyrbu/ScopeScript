package lol.pyr.scopescript;

import lol.pyr.scopescript.api.Executable;
import lol.pyr.scopescript.api.VariableScope;
import lol.pyr.scopescript.exception.UnknownVariableException;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Scope implements VariableScope, Executable {
    protected final VariableScope parent;
    private final Map<String, Object> variableMap = new HashMap<>();
    private final Executable[] operations;

    public Scope(VariableScope parent, Function<VariableScope, Executable[]> operationsProvider) {
        this.parent = parent;
        this.operations = operationsProvider.apply(this);
    }

    public Object getVariable(String identifier) throws UnknownVariableException {
        if (!variableMap.containsKey(identifier)) {
            if (parent == null) throw new UnknownVariableException();
            return parent.getVariable(identifier);
        }
        return variableMap.get(identifier);
    }

    public void setVariable(String identifier, Object member) {
        if (!setVariableIfExists(identifier, member)) variableMap.put(identifier, member);
    }

    public boolean setVariableIfExists(String identifier, Object member) {
        if (!variableMap.containsKey(identifier)) {
            if (parent != null) return parent.setVariableIfExists(identifier, member);
            return false;
        }
        variableMap.put(identifier, member);
        return true;
    }

    @Override
    public void execute() throws Throwable {
        for (Executable op : operations) op.execute();
    }
}
