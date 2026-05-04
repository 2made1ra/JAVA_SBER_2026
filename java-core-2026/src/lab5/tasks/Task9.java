package lab5.tasks;

import java.util.List;
import java.util.stream.Collectors;

public class Task9 {
    public static List<Integer> getNumbersGreaterThan(List<Integer> numbers, int minValue) {
        return numbers.stream()
                .filter(number -> number > minValue)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        System.out.println(getNumbersGreaterThan(numbers, 3));
    }
}
