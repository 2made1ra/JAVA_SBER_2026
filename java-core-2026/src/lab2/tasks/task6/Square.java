package lab2.tasks.task6;

public class Square implements Shape{
    private double a;

    public Square(double a) {
        if (a <= 0) {
            throw new IllegalArgumentException("Сторона должна быть положительным числом");
        }
        this.a = a;
    }

    public double getA() {
        return this.a;
    }

    public void setA(double a) {
        if (a <= 0) {
            throw new IllegalArgumentException("Сторона должна быть положительным числом");
        }
        this.a = a;
    }

    @Override
    public double calculateArea() {
        return a * a;
    }

    @Override
    public double calculatePerimeter() {
        return a * 4;
    }
}
