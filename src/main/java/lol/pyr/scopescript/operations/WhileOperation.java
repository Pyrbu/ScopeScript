package lol.pyr.scopescript.operations;

import lol.pyr.scopescript.Scope;
import lol.pyr.scopescript.api.Executable;
import lol.pyr.scopescript.api.Expression;
import lol.pyr.scopescript.api.VariableScope;
import lol.pyr.scopescript.exception.UnexpectedTypeException;

import java.util.function.Function;

public class WhileOperation extends Scope implements Executable, VariableScope {
    private final Expression expression;

    public WhileOperation(VariableScope parent, Expression expression, Function<VariableScope, Executable[]> operationsProvider) {
        super(parent, operationsProvider);
        this.expression = expression;
    }

    @Override
    public void execute() throws Throwable {
        while (evaluateExpression(parent)) super.execute();
    }

    private boolean evaluateExpression(VariableScope scope) {
        Object value = expression.compute(scope);
        if (value instanceof Boolean bool) return bool;
        throw new UnexpectedTypeException();
    }
}
