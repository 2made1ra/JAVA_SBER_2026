package LAB_2.tasks.Task9;

public class Square extends Shape{
    private final double side;

    public Square(String name, String color, double side) {
        super(name, color);

        if (side <= 0) {
            throw new IllegalArgumentException("Сторона должна быть положительным числом");
        }

        this.side = side;
    }

    public double getSide() { return side; }

    @Override
    public double calcArea() {
        return side * side;
    }

    @Override
    public double calcPerimeter() {
        return 4 * side;
    }

    /**
     * Вычисляет диагональ квадрата
     * @return диагональ данного квадрата.
     */
    public double getDiagonal() {
        return side * Math.sqrt(2);
    }
}
