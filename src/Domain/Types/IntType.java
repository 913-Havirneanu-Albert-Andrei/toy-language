package Domain.Types;

public class IntType implements Type {
    private int value;

    public IntType(){
        this.value = 0;
    }

    public IntType(int val){
        this.value = val;
    }

    @Override
    public boolean equals(Object o){
        return o instanceof IntType;
    }

    @Override
    public String toString(){
        return "int";
    }

}
