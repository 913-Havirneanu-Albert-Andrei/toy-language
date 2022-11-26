package Domain.Types;

import Domain.Values.StringValue;
import Domain.Values.Value;

public class StringType implements Type{

    @Override
    public boolean equals(Object o) {
        return o instanceof StringType;
    }

    @Override
    public Value defaultValue ( ) {
        // return new string value
        return new StringValue("");
    }

    @Override
    public String toString() {
        return "string";
    }
}
