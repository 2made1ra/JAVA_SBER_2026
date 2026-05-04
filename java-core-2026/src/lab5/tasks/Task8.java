package lab5.tasks;

import java.util.List;
import java.util.stream.Collectors;

public class Task8 {
    public static List<String> getStringsLongerThan(List<String> strings, int minLength) {
        return strings.stream()
                .filter(value -> value != null && value.length() > minLength)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> strings = List.of("Java", "stream", "API", "lambda");
        System.out.println(getStringsLongerThan(strings, 4));
    }
}
