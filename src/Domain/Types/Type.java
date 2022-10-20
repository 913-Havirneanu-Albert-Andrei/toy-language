package Domain.Types;

import Domain.Values.Value;

public interface Type{
    // type get type

    boolean equals(Object o);
    Value defaultValue();
    String toString();
}
