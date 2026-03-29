package lab3.tasks.task6;

import java.util.ArrayList;

public class ArraySolution extends AbstractSolution{
    ArraySolution(int n) {
        super();
        this.people = new ArrayList<>();
        fillList(people, n);
    }
}
