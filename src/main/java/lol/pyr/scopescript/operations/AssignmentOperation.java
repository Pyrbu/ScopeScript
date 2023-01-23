package lol.pyr.scopescript.operations;

import lol.pyr.scopescript.api.Executable;
import lol.pyr.scopescript.api.Expression;
import lol.pyr.scopescript.api.VariableScope;

public class AssignmentOperation implements Executable {
    private final VariableScope parent;

    private final String identifier;
    private final Expression expression;

    public AssignmentOperation(VariableScope parent, String identifier, Expression expression) {
        this.parent = parent;
        this.identifier = identifier;
        this.expression = expression;
    }

    @Override
    public void execute() throws Throwable {
        parent.setVariable(identifier, expression.compute(parent));
    }
}
