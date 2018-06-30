package kz.exampleandroid.tom.calculator.models;

import kz.exampleandroid.tom.calculator.abstraction.OperatorBase;

public class Addition extends OperatorBase {


    public Addition(double x, double y) {
        super(x, y);
    }

    @Override
    public double calculate() {
        return  getX() + getY();
    }
}
