package lab2.tasks.task9;

public abstract class Shape {
    private String name;
    private String color;

    public Shape(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract double calcArea();

    public abstract double calcPerimeter();

    public void displayInfo() {
        double area = calcArea();
        double perimeter = calcPerimeter();

        String format = "| %-15s | %-10s | %8.2f | %8.2f |%n";
        String line = "---------------------------------------------------------";

        System.out.printf(format, name, color, area, perimeter);
        System.out.println(line);
    }
}
