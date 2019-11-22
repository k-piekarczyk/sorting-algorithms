import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {

    @Test
    void sort() {
        SorterInterface sorter = new InsertionSort();

        double[] input = {8.9, 8.9, 8.2, 3.7, 2.9, 9.3, 4.3, 2.1, 6.0, 2.3, 6.2, 2.3, 6.3, 0.3, 5.5};
        double[] output = sorter.sort(input);
        double[] correctOutput = {0.3, 2.1, 2.3, 2.3, 2.9, 3.7, 4.3, 5.5, 6.0, 6.2, 6.3, 8.2, 8.9, 8.9, 9.3};

        assertArrayEquals(correctOutput, output);

        assertThrows(NullArrayException.class, () -> sorter.sort(null));
    }

    @Test
    void timeTest_bestCase() {
        SorterInterface sorter = new InsertionSort();
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
            BufferedWriter writer = new BufferedWriter(new FileWriter("complexity/timeTest-insertSort-bestCase.csv", false));
            writer.write(String.format("n\ttime [ns]%n"));
            for (long[] pair : timeList) {
                writer.write(String.format("%d\t%d%n", pair[0], pair[1]));
            }
            writer.close();
        } catch (IOException ignored) {}
    }

    @Test
    void timeTest_worstCase() {
        SorterInterface sorter = new InsertionSort();
        long start;
        long elapsed;
        long avg;
        int attempts = 15;
        int maxN = 100000;
        List<long []> timeList = new ArrayList<>();

        for (int i = 5000; i <= maxN; i += 1000) {
            double [] input = new double[i];
            for (int j = 0; j < input.length; j++) {
                input[j] = input.length - j;
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
            BufferedWriter writer = new BufferedWriter(new FileWriter("complexity/timeTest-insertSort-worstCase.csv", false));
            writer.write(String.format("n\ttime [ns]%n"));
            for (long[] pair : timeList) {
                writer.write(String.format("%d\t%d%n", pair[0], pair[1]));
            }
            writer.close();
        } catch (IOException ignored) {}
    }
}