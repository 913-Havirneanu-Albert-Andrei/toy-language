package Domain.Expressions;

import ADT.MyIDictionary;
import Domain.Values.Value;
import Exception.MyException;

public class ValueExpression implements Expression{

    private Value val;

    public ValueExpression(Value v){
        this.val = v;
    }

    @Override
    public Value eval(MyIDictionary<String, Value> symTable) throws MyException {
       return this.val;
    }

    @Override
    public String toString(){
        return this.val.toString();
    }
}
