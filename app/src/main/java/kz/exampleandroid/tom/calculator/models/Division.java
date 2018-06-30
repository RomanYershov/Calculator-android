package kz.exampleandroid.tom.calculator.models;

import kz.exampleandroid.tom.calculator.abstraction.OperatorBase;

public class Division extends OperatorBase{


    public Division(double x, double y) {
        super(x, y);
    }

    @Override
    public double calculate() {
        return getX() / getY();
    }
}
