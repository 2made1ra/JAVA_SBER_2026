package lab5.tasks;

import java.util.List;
import java.util.stream.Collectors;

public class Task10 {
    public static List<String> getStringsWithLettersOnly(List<String> strings) {
        return strings.stream()
                .filter(value -> value != null && !value.isEmpty())
                .filter(value -> value.chars().allMatch(Character::isLetter))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> strings = List.of("Java", "lab5", "Stream", "hello!");
        System.out.println(getStringsWithLettersOnly(strings));
    }
}
