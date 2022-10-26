package Domain.Expressions;
import ADT.MyIDictionary;
import Domain.Types.BoolType;
import Domain.Values.BoolValue;
import Domain.Values.Value;
import Exception.MyException;

import java.util.Objects;

public class LogicExpression implements Expression{

    private Expression expression1 , expression2;
    private char operand;

    public LogicExpression(Expression e1 , Expression e2 , char op) {
        this.expression1 = e1;
        this.expression2 = e2;
        this.operand = op;
    }
    @Override
    public Value eval ( MyIDictionary < String, Value > symTable ) throws MyException {
        Value v1 , v2;
        v1 = expression1.eval (symTable);
        v2 = expression2.eval ( symTable );
        if (! (v1.getType ().equals ( new BoolType () )) ){
            throw new MyException("Logical operation error: Operand " + this.expression1 + " is not a boolean");
        }
        if(! (v2.getType ().equals ( new BoolType () ))){
            throw new MyException ( "Logical operation error: Operation " + this.expression2 + " is not a boolean");
        }
        BoolValue b1 = (BoolValue) v1;
        BoolValue b2 = (BoolValue) v2;
        boolean firstValue = b1.getValue ();
        boolean secondValue = b2.getValue ();
        boolean result;
        switch(this.operand){
            case '&' -> {
                result = firstValue && secondValue;
            }
            case '|' -> {
                result = firstValue || secondValue;
            }
            default -> {
                throw new MyException ( "Logical operation error: Operand not valid");
            }
        }
        return new BoolValue ( result );
    }

    @Override
    public String toString(){
        return "";
    }
}
