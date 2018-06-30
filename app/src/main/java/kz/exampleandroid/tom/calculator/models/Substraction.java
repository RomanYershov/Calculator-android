package kz.exampleandroid.tom.calculator.models;

import kz.exampleandroid.tom.calculator.abstraction.OperatorBase;

public class Substraction extends OperatorBase {


    public Substraction(double x, double y) {
        super(x, y);
    }

    @Override
    public double calculate() {
        return getX() - getY();
    }
}
