package lab5.tasks;

import java.util.List;
import java.util.stream.Collectors;

public class Task6 {
    public static List<String> getStringsContainingSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(value -> value != null && value.contains(substring))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> strings = List.of("Java", "stream", "lambda", "api");
        System.out.println(getStringsContainingSubstring(strings, "a"));
    }
}
