package lab4.algo.task2;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void testSimpleDirReduc() {
        assertArrayEquals(
                "\"NORTH\", \"SOUTH\", \"SOUTH\", \"EAST\", \"WEST\", \"NORTH\", \"WEST\"",
                new String[] {"WEST"},
                Solution.dirReduc(
                        new String[] {
                            "NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"
                        }));
        assertArrayEquals(
                "\"NORTH\",\"SOUTH\",\"SOUTH\",\"EAST\",\"WEST\",\"NORTH\"",
                new String[] {},
                Solution.dirReduc(new String[] {"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH"}));
    }
}
