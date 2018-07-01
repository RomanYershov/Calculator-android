package kz.exampleandroid.tom.calculator.models;

import kz.exampleandroid.tom.calculator.Helpers.Validator;
import kz.exampleandroid.tom.calculator.abstraction.IValidator;
import kz.exampleandroid.tom.calculator.abstraction.OperatorBase;

public class SimpleCalculator {
    private IValidator validator;
    private OperatorBase operation;
    private double _buffer;


    public SimpleCalculator(IValidator validator) {
        this.validator = validator;
    }

    public double getBuffer() {
        return _buffer;
    }

    public void setBuffer(double _buffer) {
        this._buffer = _buffer;
    }

    public void calculate(String string) {
        while (validator.isValidString(string)) {
            operation = validator.getOperation(string, _buffer);
            _buffer = operation.calculate();
             string = validator.getNextString(string, _buffer);
        }
    }
}
