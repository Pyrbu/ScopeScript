package lol.pyr.scopescript;

import lol.pyr.scopescript.api.Type;
import lombok.Data;

@Data
public class Variable {
    private final Type type;
    private final Object value;
}
