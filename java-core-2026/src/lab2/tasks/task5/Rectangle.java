package lab2.tasks.task5;

/**
 * Создание класса "Прямоугольник":
 * Создайте класс Rectangle, который содержит поля для длины и
 * ширины прямоугольника.
 * Добавьте методы, которые позволяют установить и получить
 * значения этих полей.
 * Добавьте методы, которые позволяют вычислить площадь и
 * периметр прямоугольника.
 * Добавьте конструктор, который позволяет создавать объекты
 * класса Rectangle, используя значения для длины и ширины.
 */
public class Rectangle {
    private double length;
    private double width;

    public Rectangle (double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return this.length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    /**
     *
     * @return площадь с плавающей точкой double
     */
    public double area() {
        return this.width * this.length;
    }

    /**
     *
     * @return Периметр прямоугольника double
     */
    public double perimeter() {
        return 2 * this.width + 2 * this.length;
    }
}
