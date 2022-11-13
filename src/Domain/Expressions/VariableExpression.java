package Domain.Expressions;

import ADT.MyIDictionary;
import Domain.Values.Value;
import Exception.MyException;
public class VariableExpression implements Expression{

    private String id;

    public VariableExpression(String id){
        this.id = id;
    }

    @Override
    public Value eval(MyIDictionary<String, Value> symTable) throws MyException{
        if( ! symTable.checkIfKeyExists ( this.id ) )
           throw new MyException("Variable " + this.id + " is not declared!");
       return symTable.getValue(this.id);
    }
}
