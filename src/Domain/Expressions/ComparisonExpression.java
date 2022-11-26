package Domain.Expressions;

import ADT.MyIDictionary;
import Domain.Types.IntType;
import Domain.Values.BoolValue;
import Domain.Values.IntValue;
import Domain.Values.Value;
import Exception.MyException;

public class ComparisonExpression implements Expression{

    private Expression firstExpression , secondExpression;
    String operand;

    public ComparisonExpression ( Expression firstExpression , Expression secondExpression , String operand ) {
        this.firstExpression = firstExpression;
        this.secondExpression = secondExpression;
        this.operand = operand;
    }



    @Override
    public Value eval ( MyIDictionary < String, Value > symTable ) throws MyException {
        Value firstValue , secondValue;
        firstValue = this.firstExpression.eval(symTable);
        secondValue = this.secondExpression.eval(symTable);
        if (!firstValue.getType().equals(new IntType() ))
            throw new MyException("Fist expression is not an integer!");
        if(!secondValue.getType().equals(new IntType()))
            throw new MyException("Second expression is not an integer!");
        IntValue firstInt = (IntValue) firstValue;
        IntValue secondInt = (IntValue) secondValue;
        int f = firstInt.getValue();
        int s = secondInt.getValue();
        switch(this.operand) {
            case "<" -> {
                return new BoolValue(f < s);
            }
            case ">" -> {
                return new BoolValue(f > s);
            }
            case "<=" -> {
                return new BoolValue(f <= s);
            }
            case ">=" -> {
                return new BoolValue(f >= s);
            }
            case "==" ->{
                return new BoolValue(f == s);
            }
            case "!=" -> {
                return new BoolValue(f != s);
            }
            default -> {
                throw new MyException("Invalid operand");
            }
        }
    }

    @Override
    public String toString() {
        return this.firstExpression + this.operand + this.secondExpression;
    }
}
