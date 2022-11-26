package Domain.Values;

import Domain.Types.StringType;
import Domain.Types.Type;

import java.util.Objects;

public class StringValue implements Value{

    private String value;

    public StringValue(String val) {
        this.value = val;
    }

    @Override
    public Type getType ( ) {
        return new StringType();
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof StringValue s))
            return false;
        return this.value.equals(s.value);
    }

    @Override
    public String toString() {
        return this.value;
    }
}
