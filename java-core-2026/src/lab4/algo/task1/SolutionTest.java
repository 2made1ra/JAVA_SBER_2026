package lab4.algo.task1;

import static org.junit.Assert.*;

public class SolutionTest {
    @org.junit.Test
    public void test1() {
        String[] a = new String[]{"arp", "live", "strong"};
        String[] b = new String[]{"lively", "alive", "harp", "sharp", "armstrong"};
        String[] r = new String[]{"arp", "live", "strong"};
        assertArrayEquals(r, Solution.inArray(a, b));
    }
}
