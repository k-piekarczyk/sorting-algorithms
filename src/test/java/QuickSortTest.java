import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void sort() {
        SorterInterface sorter = new QuickSort();

        double[] input = {8.3, 2.4, 8.6, 8.1, 5.3, 9.3, 2.2, 6.8, 5.9, 4.2, 8.9, 8.1, 4.8, 3.1, 4.2};
        double[] output = sorter.sort(input);
        double[] correctOutput = {2.2, 2.4, 3.1, 4.2, 4.2, 4.8, 5.3, 5.9, 6.8, 8.1, 8.1, 8.3, 8.6, 8.9, 9.3};

        assertArrayEquals(correctOutput, output);
        assertThrows(NullArrayException.class, () -> sorter.sort(null));
    }

    @Test
    void timeTest_bestCase() {
        SorterInterface sorter = new QuickSort();
        long start;
        long elapsed;
        long avg;
        int attempts = 15;
        int maxN = 100000;
        List<long []> timeList = new ArrayList<>();

        for (int i = 5000; i <= maxN; i += 1000) {
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

            long[] pair = {i, avg};
            timeList.add(pair);
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("complexity/timeTest-quickSort-bestCase.csv", false));
            writer.write(String.format("n\ttime [ns]%n"));
            for (long[] pair : timeList) {
                writer.write(String.format("%d\t%d%n", pair[0], pair[1]));
            }
            writer.close();
        } catch (IOException ignored) {}
    }

    @Test
    void timeTest_worstCase() {
        SorterInterface sorter = new QuickSort();
        long start;
        long elapsed;
        long avg;
        int attempts = 15;
        int maxN = 100000;
        List<long []> timeList = new ArrayList<>();

        for (int i = 5000; i <= maxN; i += 1000) {
            double [] input = new double[i];
            Arrays.fill(input, 1);

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
            BufferedWriter writer = new BufferedWriter(new FileWriter("complexity/timeTest-quickSort-worstCase.csv", false));
            writer.write(String.format("n\ttime [ns]%n"));
            for (long[] pair : timeList) {
                writer.write(String.format("%d\t%d%n", pair[0], pair[1]));
            }
            writer.close();
        } catch (IOException ignored) {}
    }
}