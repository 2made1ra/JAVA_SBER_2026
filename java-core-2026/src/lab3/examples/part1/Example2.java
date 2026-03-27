package lab3.examples.part1;

import java.util.ArrayList;
import java.util.List;

public class Example2 {
    public static void rec_2(int x, List<Integer> result) {
        if (2 * x + 1 < 20) {
            rec_2(2 * x + 1, result);
        }
        result.add(x);
    }

    public static void main(String[] args) {
        List<Integer> result = new ArrayList<>();
        rec_2(1, result);
        System.out.println(result);
    }
}
