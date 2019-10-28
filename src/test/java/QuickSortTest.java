import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void sort() {
        SorterInterface sorter = new QuickSort();

        double[] input = {2.1, 3.1, 6.1, 1.1, 9.1};
        double[] output = sorter.sort(input);
        double[] correctOutput = {1.1, 2.1, 3.1, 6.1, 9.1};

        assertArrayEquals(correctOutput, output);
    }

    @Test
    void timeTest() {
        SorterInterface sorter = new QuickSort();
        long start;
        long elapsed;
        long avg;
        int attempts = 100;

        for (int i = 5000; i < 25000; i += 1000) {
            double [] input = new double[i];
            for (int j = 0; j < input.length; j++) {
                input[j] = j;
            }

            elapsed = 0;
            for (int k = 0; k < attempts; k++) {
                start = System.nanoTime();
                sorter.sort(input);
                elapsed += System.nanoTime() - start;
            }
            avg = Math.floorDiv(elapsed, (long) attempts);
            System.out.printf("%d\t%d%n", i, avg);
        }
    }
}