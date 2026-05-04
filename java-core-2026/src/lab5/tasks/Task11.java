package lab5.tasks;

import java.util.List;
import java.util.stream.Collectors;

public class Task11 {
    public static List<Integer> getNumbersLessThan(List<Integer> numbers, int maxValue) {
        return numbers.stream()
                .filter(number -> number < maxValue)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        System.out.println(getNumbersLessThan(numbers, 4));
    }
}
