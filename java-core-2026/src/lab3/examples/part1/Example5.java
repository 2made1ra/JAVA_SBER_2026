package lab3.examples.part1;

public class Example5 {
    public static int step = 0;

    public static void space() {
        for (int i = 0; i < step; i++) {
            System.out.print("    ");
        }
    }

    public static int getFibonachi(int x) {
        space();
        System.out.println("Вход: f(" + x + ") ->");

        step++;

        int result;
        if (x == 0) {
            result = 0;
        } else if (x == 1) {
            result = 1;
        } else {
            result = getFibonachi(x - 1) + getFibonachi(x - 2);
        }

        step--;
        space();
        System.out.println("<- Выход: f(" + x + ") возвращает " + result);

        return result;
    }


    public static void main(String[] args) {
        int num, result;
        num = 4;
        result = getFibonachi(num);
    }
}
