package Domain.Types;

public class BoolType implements Type {
    boolean value;

    public BoolType(){
        this.value = false;
    }

    public BoolType(boolean v){
        this.value = v;
    }

    @Override
    public boolean equals(Object o){
        return o instanceof BoolType;
    }

    @Override
    public String toString(){
        return "string";
    }
}
