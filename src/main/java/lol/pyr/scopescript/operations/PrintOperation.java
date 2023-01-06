package lol.pyr.scopescript.operations;

import lol.pyr.scopescript.Variable;
import lol.pyr.scopescript.api.Executable;
import lol.pyr.scopescript.api.VariableProvider;
import lol.pyr.scopescript.api.VariableScope;

public class PrintOperation implements Executable {
    private final VariableProvider messageProvider;

    public PrintOperation(VariableProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    @Override
    public void execute(VariableScope parent) throws Throwable {
        Variable variable = messageProvider.get(parent);
        System.out.println(variable.getValue());
    }
}
