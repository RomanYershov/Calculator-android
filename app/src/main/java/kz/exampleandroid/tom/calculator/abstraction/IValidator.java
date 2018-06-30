package kz.exampleandroid.tom.calculator.abstraction;

public interface IValidator {
    OperatorBase getOperation(String str, double buffer);

    String getNextString(String str, double buffer);

    boolean isValidString(String string);
}
