import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SelectionSortTest {

    @Test
    void sort() {
        SorterInterface sorter = new SelectionSort();

        double[] input = {1.7, 9.5, 1.2, 0.6, 5.3, 8.2, 3.5, 4.8, 3.4, 0.3, 9.8, 8.3, 9.7, 2.5, 8.4};
        double[] output = sorter.sort(input);
        double[] correctOutput = {0.3, 0.6, 1.2, 1.7, 2.5, 3.4, 3.5, 4.8, 5.3, 8.2, 8.3, 8.4, 9.5, 9.7, 9.8};

        assertArrayEquals(correctOutput, output);
        assertThrows(NullArrayException.class, () -> sorter.sort(null));
    }


    @Test
    void timeTest() {
        SorterInterface sorter = new SelectionSort();
        Random random = new Random();
        long start;
        long elapsed;
        long avg;
        int attempts = 15;
        int maxN = 100000;
        List<long []> timeList = new ArrayList<>();

        for (int i = 5000; i <= maxN; i += 1000) {
            double [] input = new double[i];
            for (int j = 0; j < input.length; j++) {
                input[j] = random.nextDouble();
            }

            elapsed = 0;
            for (int k = 0; k < attempts; k++) {
                start = System.nanoTime();
                sorter.sort(input);
                elapsed += System.nanoTime() - start;
            }
            avg = Math.floorDiv(elapsed, (long) attempts);

            long[] pair = {i, avg};
            timeList.add(pair);
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("complexity/timeTest-selectSort.csv", false));
            writer.write(String.format("n\ttime [ns]%n"));
            for (long[] pair : timeList) {
                writer.write(String.format("%d\t%d%n", pair[0], pair[1]));
            }
            writer.close();
        } catch (IOException ignored) {}
    }
}