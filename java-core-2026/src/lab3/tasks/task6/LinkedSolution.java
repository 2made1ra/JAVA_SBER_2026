package lab3.tasks.task6;

import java.util.LinkedList;

public class LinkedSolution extends AbstractSolution{
    LinkedSolution(int n) {
        super();
        this.people = new LinkedList<>();
        fillList(people, n);
    }
}
