package lab5.algo.task1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    public void convertsSimpleRomanNumber() {
        assertEquals(3, solution.romanToInt("III"));
    }

    @Test
    public void convertsRomanNumberWithSubtraction() {
        assertEquals(58, solution.romanToInt("LVIII"));
        assertEquals(1994, solution.romanToInt("MCMXCIV"));
    }

    @Test
    public void convertsAllSubtractivePairs() {
        assertEquals(4, solution.romanToInt("IV"));
        assertEquals(9, solution.romanToInt("IX"));
        assertEquals(40, solution.romanToInt("XL"));
        assertEquals(90, solution.romanToInt("XC"));
        assertEquals(400, solution.romanToInt("CD"));
        assertEquals(900, solution.romanToInt("CM"));
    }
}
