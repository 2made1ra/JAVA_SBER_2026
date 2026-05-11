package lab6.algo.task1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    public void validatesLeetcodeExamples() {
        assertTrue(solution.isValid("()"));
        assertTrue(solution.isValid("()[]{}"));
        assertFalse(solution.isValid("(]"));
        assertTrue(solution.isValid("([])"));
    }

    @Test
    public void rejectsWrongClosingOrder() {
        assertFalse(solution.isValid("([)]"));
        assertFalse(solution.isValid("{[}]"));
    }

    @Test
    public void rejectsUnmatchedBrackets() {
        assertFalse(solution.isValid("("));
        assertFalse(solution.isValid("]"));
        assertFalse(solution.isValid("(([]"));
    }
}
