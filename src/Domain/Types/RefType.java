package Domain.Types;

import Domain.Values.Value;

import java.util.Objects;

public class RefType implements Type{
    Type inner;

    public RefType ( ) {
    }

    public RefType ( Type inner ) {
        this.inner = inner;
    }

    public Type getInner ( ) {
        return inner;
    }

    @Override
    public boolean equals ( Object o ) {
        if(!(o instanceof RefType r))
            return false;
        return this.inner.equals(r.inner);
    }

    @Override
    public String toString ( ) {
        return "Ref(" + this.inner.toString() + ")";
    }

    @Override
    public Value defaultValue ( ) {
        return null;
    }
}
