package lab3.tasks.task6;

import java.util.List;

public abstract class AbstractSolution implements Solution{
    protected List<Integer> people;

    public AbstractSolution() {}

    @Override
    public void solveProblem() {
        int currentIndex = 1;
        while (people.size() > 1) {
            people.remove(currentIndex);
            currentIndex = (currentIndex + 1) % people.size();
        }
    }

    @Override
    public void calculateWorkTime() {
        long startTime = System.nanoTime();
        solveProblem();
        long endTime = System.nanoTime();
        double resultTime = (double) (endTime - startTime) / 1000000;
        System.out.printf("Время выполнения, используя %s - %.4f мс.\n", getSimpleName(), resultTime);
    }

    protected void fillList(List<Integer> list, int n) {
        list.clear();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
    }

    protected String getSimpleName() {
        return this.people.getClass().getSimpleName();
    }
}
