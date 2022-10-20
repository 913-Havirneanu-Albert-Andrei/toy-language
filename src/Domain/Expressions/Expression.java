package Domain.Expressions;

import ADT.MyIDictionary;
import Domain.Values.Value;
import Exception.MyException;
public interface Expression {
    Value eval(MyIDictionary<String , Value> symTable) throws MyException;

    String toString();
}
