package lab2.tasks.task6;

/**
 * 6 Создание классов и интерфейсов для работы с фигурами:
 * Создайте классы для различных геометрических фигур (например,
 * круг, квадрат, треугольник), каждый из которых имеет свои методы и поля.
 * Создайте интерфейс, который определяет методы, которые
 * должны быть реализованы для каждой фигуры, чтобы вычислить ее площадь и
 * периметр.
 * Реализуйте методы интерфейса в каждом классе фигуры и
 * создайте объекты для каждой из них, чтобы вычислить их площадь и
 * периметр.
 */
public class Task6 {
    public static void main(String[] args) {
        Circle myCircle = new Circle(5.0);
        Triangle myTriangle = new Triangle(3.0, 4.0, 5.0);
        Square mySquare = new Square(10.0);

        System.out.printf(
                "Периметр круга: %.2f; Площадь круга: %.2f\n",
                myCircle.calculatePerimeter(),
                myCircle.calculateArea()
        );

        System.out.printf(
                "Периметр треугольника: %.2f; Площадь треугольника: %.2f\n",
                myTriangle.calculatePerimeter(),
                myTriangle.calculateArea()
        );

        System.out.printf(
                "Периметр квадрата: %.2f; Площадь квадрата: %.2f\n",
                mySquare.calculatePerimeter(),
                mySquare.calculateArea()
        );
    }
}
