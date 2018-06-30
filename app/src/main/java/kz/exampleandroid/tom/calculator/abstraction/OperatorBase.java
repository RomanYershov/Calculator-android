package kz.exampleandroid.tom.calculator.abstraction;

public abstract class OperatorBase {
    private double x;
    private double y;



    public OperatorBase(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }


    public abstract double calculate();
}
