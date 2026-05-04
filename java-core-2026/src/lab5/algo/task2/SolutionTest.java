package lab5.algo.task2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    public void convertsLeetcodeExamples() {
        assertEquals("PAHNAPLSIIGYIR", solution.convert("PAYPALISHIRING", 3));
        assertEquals("PINALSIGYAHRPI", solution.convert("PAYPALISHIRING", 4));
    }

    @Test
    public void returnsSameStringForOneRow() {
        assertEquals("A", solution.convert("A", 1));
        assertEquals("ABC", solution.convert("ABC", 1));
    }

    @Test
    public void returnsSameStringWhenRowsAreNotLessThanLength() {
        assertEquals("AB", solution.convert("AB", 2));
        assertEquals("AB", solution.convert("AB", 3));
    }

    @Test
    public void convertsShortZigzag() {
        assertEquals("ABDC", solution.convert("ABCD", 3));
    }
}
