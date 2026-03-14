package lab2.tasks.task6;

/**
 * Класс, имплементирующий поиск периметра и площади треугольника при известных трех сторонах.
 * Для поиска площади используется формула Герона.
 * Особенность реализации в отсутствии сеттеров - я решил, что в этом случае, поля объекта задаются раз и навсегда,
 * без возможности из изменения. По идеи, для этого можно использовать Records - нужно уточнить.
 */
public class Triangle implements Shape{
    private final double a;
    private final double b;
    private final double c;

    public Triangle(double a, double b, double c) {
        // проверим правильно ли переданы длины сторон (неотрицательны ли?)
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Стороны должны быть положительными числами");
        }
        // также, нужно проверить возможность существования треугольника
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Треугольник с такими сторонами не существует");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Вычисляет площадь треугольника по формуле Герона
     * @return площадь треугольника.
     * @see #calculatePerimeter()
     */
    @Override
    public double calculateArea() {
        // Ищем полупериметр
        double s = calculatePerimeter() / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double calculatePerimeter() {
        return a + b + c;
    }
}
