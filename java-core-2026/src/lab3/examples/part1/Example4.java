package lab3.examples.part1;

public class Example4 {
    public static int factorial(int x) {
        if (x == 1) {
            return x;
        }
        return x * factorial(x - 1);
    }

    public static void main(String[] args) {
        int result = factorial(5);
        System.out.println(result);
    }
}
