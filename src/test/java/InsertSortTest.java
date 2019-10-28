import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertSortTest {

    @Test
    void sort() {
        SorterInterface sorter = new InsertSort();

        double[] input = {2.1, 3.1, 6.1, 1.1, 9.1};
        double[] output = sorter.sort(input);
        double[] correctOutput = {1.1, 2.1, 3.1, 6.1, 9.1};

        assertArrayEquals(correctOutput, output);
    }
}