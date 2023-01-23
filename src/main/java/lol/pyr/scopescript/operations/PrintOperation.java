package lol.pyr.scopescript.operations;

import lol.pyr.scopescript.api.Executable;
import lol.pyr.scopescript.api.Expression;
import lol.pyr.scopescript.api.VariableScope;

public class PrintOperation implements Executable {
    private final VariableScope parent;
    private final Expression messageExpression;

    public PrintOperation(VariableScope parent, Expression messageExpression) {
        this.parent = parent;
        this.messageExpression = messageExpression;
    }

    @Override
    public void execute() {
        System.out.println(messageExpression.compute(parent));
    }
}
