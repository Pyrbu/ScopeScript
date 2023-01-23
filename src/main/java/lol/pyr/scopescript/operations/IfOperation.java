package lol.pyr.scopescript.operations;

import lol.pyr.scopescript.Scope;
import lol.pyr.scopescript.api.Executable;
import lol.pyr.scopescript.api.Expression;
import lol.pyr.scopescript.api.VariableScope;
import lol.pyr.scopescript.exception.UnexpectedTypeException;

import java.util.function.Function;

public class IfOperation extends Scope implements VariableScope, Executable {
    private final Expression conditionExpression;
    private final Executable[] elseOperations;

    public IfOperation(VariableScope parent, Expression conditionExpression, Function<VariableScope, Executable[]> elseOperationsProvider, Function<VariableScope, Executable[]> operationsProvider) {
        super(parent, operationsProvider);
        this.conditionExpression = conditionExpression;
        this.elseOperations = elseOperationsProvider == null ? null : elseOperationsProvider.apply(this);
    }

    @Override
    public void execute() throws Throwable {
        Object variable = conditionExpression.compute(this);
        if (!(variable instanceof Boolean)) throw new UnexpectedTypeException();
        if ((Boolean) variable) execute();
        else if (elseOperations != null) for (Executable op : elseOperations) op.execute();
    }
}
