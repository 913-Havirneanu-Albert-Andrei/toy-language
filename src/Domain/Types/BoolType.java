package Domain.Types;

import Domain.Values.BoolValue;
import Domain.Values.Value;

public class BoolType implements Type {

    @Override
    public boolean equals(Object o){
        return o instanceof BoolType;
    }

    @Override
    public Value defaultValue() {
        return new BoolValue(false);
    }

    @Override
    public String toString(){
        return "boolean";
    }
}
