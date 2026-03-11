package LAB_2.tasks.Task9;

public class Circle extends Shape{
    private final double radius;

    public Circle(String name, String color, double radius) {
        super(name, color);

        if (radius <= 0) {
            throw new IllegalArgumentException("Радиус должен быть положительным числом");
        }
        this.radius = radius;
    }

    public double getRadius() { return radius; }

    @Override
    public double calcArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calcPerimeter() {
        return 2 * Math.PI * radius;
    }

    /**
     * Вычисляет диаметр круга
     * @return диаметр данного круга.
     */
    public double getDiameter() {
        return 2 * radius;
    }
}
