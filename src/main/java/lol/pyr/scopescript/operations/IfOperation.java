package lol.pyr.scopescript.operations;

import lol.pyr.scopescript.ScopeImpl;
import lol.pyr.scopescript.Variable;
import lol.pyr.scopescript.api.Executable;
import lol.pyr.scopescript.api.VariableScope;
import lol.pyr.scopescript.api.VariableProvider;
import lol.pyr.scopescript.exception.UnexpectedTypeException;
import lol.pyr.scopescript.types.BooleanType;

public class IfOperation extends ScopeImpl implements VariableScope, Executable {
    private final VariableProvider conditionProvider;
    private final Executable elseOperation;

    public IfOperation(VariableScope parent, VariableProvider conditionProvider, Executable elseOperation, Executable... operations) {
        super(parent, operations);
        this.conditionProvider = conditionProvider;
        this.elseOperation = elseOperation;
    }

    @Override
    public void execute(VariableScope parent) throws Throwable {
        Variable variable = conditionProvider.get(this);
        if (!(variable.getType() instanceof BooleanType)) throw new UnexpectedTypeException();
        if ((Boolean) variable.getValue()) execute(this);
        else elseOperation.execute(parent);
    }
}
