package pl.kurs.test2advancedlevel.model;

public class Division implements IOperator {

    private double a;
    private double b;

    public Division() {
    }

    public Division(double a, double b) {
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
        if (this.b == 0) {
            throw new ArithmeticException("Nie mozemy dzielic przez 0");}
        else {
            return this.a / this.b;
        }
    }
}
