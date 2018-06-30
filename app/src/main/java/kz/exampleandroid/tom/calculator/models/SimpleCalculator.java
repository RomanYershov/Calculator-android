package kz.exampleandroid.tom.calculator.models;

import kz.exampleandroid.tom.calculator.Helpers.Validator;
import kz.exampleandroid.tom.calculator.abstraction.IValidator;
import kz.exampleandroid.tom.calculator.abstraction.OperatorBase;

public class SimpleCalculator {
    IValidator validator;
    OperatorBase operation;
    private double _buffer;

    public SimpleCalculator() {
        validator = new Validator();
    }


    public double get_buffer() {
        return _buffer;
    }


    public void calculate(String string) {
        operation = validator.isValid(string);
        if(operation == null)return;
        _buffer = operation.calculate();
    }
}
