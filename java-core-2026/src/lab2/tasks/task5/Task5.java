package lab2.tasks.task5;

public class Task5 {
    public static void main(String[] args) {
        Rectangle testRect = new Rectangle(15.0, 10.0);
        System.out.printf("Длина прямоугольника: %.2f\n", testRect.getLength());
        System.out.printf("Ширина прямоугольника: %.2f\n", testRect.getWidth());
        System.out.printf("Площадь прямоугольника: %.2f\n", testRect.area());
        System.out.printf("Периметр прямоугольника: %.2f\n", testRect.perimeter());
    }
}
