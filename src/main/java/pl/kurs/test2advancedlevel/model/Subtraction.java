package pl.kurs.test2advancedlevel.model;

public class Subtraction implements IOperator{

    private double a;
    private double b;

    public Subtraction() {
    }

    public Subtraction(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    @Override
    public double getResult() {
        return this.a - this.b;
    }
}
