package lol.pyr.scopescript;

import lol.pyr.scopescript.api.Type;
import lol.pyr.scopescript.api.VariableScope;

public class Function extends ScopeImpl implements VariableScope, Type {
    private final Type returnType;
    private final Type[] inputTypes;



    public Function(VariableScope parent, Type returnType, Type[] inputTypes) {
        super(parent);
        this.returnType = returnType;
        this.inputTypes = inputTypes;
    }
    /*
    public Optional<Variable> call(Variable[] args) throws IncorrectArgumentAmountException, IncorrectArgumentTypeException {
        if (args.length != inputTypes.length) throw new IncorrectArgumentAmountException();
        for (int i = 0; i < args.length; i++) if (args[i].getType() != inputTypes[i]) throw new IncorrectArgumentTypeException();
    }*/

    public int getInputAmount() {
        return inputTypes.length;
    }
}
