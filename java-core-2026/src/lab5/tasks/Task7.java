package lab5.tasks;

import java.util.List;
import java.util.stream.Collectors;

public class Task7 {
    public static List<Integer> getNumbersDivisibleBy(List<Integer> numbers, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor must not be zero");
        }

        return numbers.stream()
                .filter(number -> number % divisor == 0)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        System.out.println(getNumbersDivisibleBy(numbers, 3));
    }
}
