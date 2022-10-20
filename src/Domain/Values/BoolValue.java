package Domain.Values;

import Domain.Types.BoolType;
import Domain.Types.Type;

public class BoolValue implements Value {

    private boolean value;

    public BoolValue(){
        this.value = false;
    }

    public BoolValue(boolean value){
        this.value = value;
    }

    @Override
    public Type getType() {
        return new BoolType();
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof BoolValue b))
            return false;
        return this.value == b.value;
    }

    @Override
    public String toString(){
        return Boolean.toString(this.value);
    }

    public boolean getValue(){
        return this.value;
    }
}
