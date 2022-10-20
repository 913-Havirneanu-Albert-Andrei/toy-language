package Domain.Values;

import Domain.Types.IntType;
import Domain.Types.Type;

public class IntValue implements Value{
     private int value;

     public IntValue(){
         this.value = 0;
     }

     @Override
    public Type getType(){
         return new IntType();
     }

     @Override
    public boolean equals(Object o){
         if(!(o instanceof IntValue i)){
             return false;
         }
         return this.value == i.value;
     }

     public int getValue(){
         return this.value;
     }

     @Override
    public String toString(){
         return Integer.toString(this.value);
     }
}
