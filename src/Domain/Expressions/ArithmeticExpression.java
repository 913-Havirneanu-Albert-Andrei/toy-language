package Domain.Expressions;

import ADT.MyIDictionary;
import Domain.Types.IntType;
import Domain.Values.IntValue;
import Domain.Values.Value;
import Exception.MyException;

public class ArithmeticExpression implements Expression {

    private Expression fistExpression, secondExpression;
    private char operand;

    public ArithmeticExpression(char op  , Expression e1 , Expression e2) {
        this.operand = op;
        this.fistExpression = e1;
        this.secondExpression = e2;
    }
    public ArithmeticExpression ( Expression e1, Expression e2, char op ) {
        this.fistExpression = e1;
        this.secondExpression = e2;
        this.operand = op;
    }

    @Override
    public Value eval ( MyIDictionary<String, Value> symTable ) throws MyException {
        Value v1, v2;
        v1 = fistExpression.eval ( symTable );
        v2 = secondExpression.eval ( symTable );

        // just checking the types
        if ( ! ( v1.getType ( ).equals ( new IntType ( ) ) ) )
            throw new MyException ( "Arithmetic exception: Operand " + this.fistExpression + " is not an integer" );
        if ( ! ( v2.getType ( ).equals ( new IntType ( ) ) ) )
            throw new MyException ( "Arithmetic exception: Operand " + this.secondExpression + " is not an integer" );
        // TODO kill my self tf im doing here
        // casting so that i can call the method get value
        IntValue intValue1 = (IntValue) v1;
        IntValue intValue2 = (IntValue) v2;

        int firstValue = intValue1.getValue ( );
        int secondValue = intValue2.getValue ( );
        int result = 0;
        switch ( this.operand ) {
            case '+' -> {
                result = firstValue + secondValue;
            }

            case '-' -> {
                result = firstValue - secondValue;
            }
            case '*' -> {
                result = firstValue * secondValue;
            }
            case '/' -> {
                if ( secondValue == 0 )
                    throw new MyException ( "Arithmetic exception: Division by zero" );
                result = firstValue / secondValue;
            }
            default -> {
                throw new MyException ( "Arithmetic exception: Operand not valid" );
            }
        }
        return new IntValue ( result );
    }
}
