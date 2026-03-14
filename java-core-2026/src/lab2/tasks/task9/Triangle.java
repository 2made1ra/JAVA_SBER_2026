package lab2.tasks.task9;

public class Triangle extends Shape{
    private final double sideA, sideB, sideC;

    public Triangle(
            String name,
            String color,
            double sideA,
            double sideB,
            double sideC
    ) {
        super(name, color);

        if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
            throw new IllegalArgumentException("Стороны должны быть положительными числами");
        }

        if (!isValidTriangle(sideA, sideB, sideC)) {
            throw new IllegalArgumentException("Треугольник с такими сторонами не может существовать");
        }

        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getSideA() { return sideA; }

    public double getSideB() { return sideB; }

    public double getSideC() { return sideC; }

    /**
     * Вычисляет площадь треугольника по формуле Герона
     * @return площадь треугольника.
     * @see #calcPerimeter()
     */
    @Override
    public double calcArea() {
        double p = calcPerimeter() / 2;
        return Math.sqrt(p * (p-sideA) * (p - sideB) * (p-sideC));
    }

    @Override
    public double calcPerimeter() {
        return sideA + sideB + sideC;
    }

    /**
     * Проверяет, может ли существовать треугольника с данными сторонами.
     * @return может/не может существовать.
     */
    public static boolean isValidTriangle(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }
}
