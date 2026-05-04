package lab5.tasks.examples;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Example2 {
    public static int[] getCommonElements(int[] first, int[] second) {
        Set<Integer> secondNumbers = Arrays.stream(second)
                .boxed()
                .collect(Collectors.toSet());

        return Arrays.stream(first)
                .filter(secondNumbers::contains)
                .toArray();
    }

    public static void main(String[] args) {
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 4, 6, 8};
        System.out.println(Arrays.toString(getCommonElements(first, second)));
    }
}
