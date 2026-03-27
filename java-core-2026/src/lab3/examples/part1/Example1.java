package lab3.examples.part1;

import java.util.List;
import java.util.ArrayList;

public class Example1 {
    public static void rec_1(int x, List<Integer> result) {
        result.add(x);
        if (2 * x + 1 < 20) {
            rec_1(2 * x + 1, result);
        }
    }

    public static void main(String[] args) {
        List<Integer> result = new ArrayList<>();
        rec_1(1, result);
        System.out.println(result);
    }
}
