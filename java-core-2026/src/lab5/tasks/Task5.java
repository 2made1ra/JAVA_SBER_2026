package lab5.tasks;

import java.util.List;
import java.util.stream.Collectors;

public class Task5 {
    public static List<Integer> getSquares(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> number * number)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        System.out.println(getSquares(numbers));
    }
}
