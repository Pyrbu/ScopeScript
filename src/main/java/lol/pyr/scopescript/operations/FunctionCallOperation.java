package lol.pyr.scopescript.operations;

import lol.pyr.scopescript.Function;
import lol.pyr.scopescript.Variable;
import lol.pyr.scopescript.api.Operation;
import lol.pyr.scopescript.api.Scope;
import lol.pyr.scopescript.api.VariableProvider;
import lol.pyr.scopescript.exception.IncorrectArgumentAmountException;
import lol.pyr.scopescript.exception.IncorrectArgumentTypeException;

public class FunctionCallOperation implements Operation {
    private final Function function;
    private final VariableProvider[] providers;

    public FunctionCallOperation(Function function, VariableProvider... providers) {
        this.function = function;
        this.providers = providers;
    }

    @Override
    public void execute(Scope scope) throws IncorrectArgumentTypeException, IncorrectArgumentAmountException {
        int amount = function.getInputAmount();
        Variable[] vars = new Variable[amount];
        for (int i = 0; i < amount; i++) vars[i] = providers[i].get(scope);
        function.call(vars);
    }
}
