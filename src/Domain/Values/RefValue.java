package Domain.Values;

import Domain.Types.RefType;
import Domain.Types.Type;

public class RefValue implements Value{
    int address;
    Type locationType;

    public int getAddress ( ) {
        return address;
    }

    public RefValue ( int address , Type locationType ) {
        this.address = address;
        this.locationType = locationType;
    }

    @Override
    public Type getType ( ) {
       return new RefType(locationType);
    }
}
