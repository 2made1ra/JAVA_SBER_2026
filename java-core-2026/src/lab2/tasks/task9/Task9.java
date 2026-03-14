package lab2.tasks.task9;

public class Task9 {
    public static void main(String[] args) {
        Circle myCircle = new Circle("круг", "черный", 2.5);
        Square mySquare = new Square("квадрат", "синий", 5);
        Triangle myTriangle = new Triangle(
                "треугольник", "лазурный", 4, 5, 6
        );

        Shape[] shapes = new Shape[] {myCircle, mySquare, myTriangle};

        System.out.println("\tИнформация о созданных фигурах\n");
        for (Shape shape: shapes) {
            shape.displayInfo();
        }
    }
}
