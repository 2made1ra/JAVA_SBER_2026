package lab5.tasks.examples;

import java.util.List;
import java.util.stream.Collectors;

public class Example3 {
    public static List<String> getStringsStartingWithUppercase(List<String> strings) {
        return strings.stream()
                .filter(value -> value != null && !value.isEmpty())
                .filter(value -> Character.isUpperCase(value.charAt(0)))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> strings = List.of("Java", "stream", "Api", "lambda");
        System.out.println(getStringsStartingWithUppercase(strings));
    }
}
