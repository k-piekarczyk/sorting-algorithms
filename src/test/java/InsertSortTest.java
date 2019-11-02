import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    @Test
    void timeTest_bestCase() {
        SorterInterface sorter = new InsertSort();
        long start;
        long elapsed;
        long avg;
        int attempts = 100;
        List<long []> timeList = new ArrayList<>();

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

            long[] pair = {i, avg};
            timeList.add(pair);
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("complexity/timeTest-insertSort-bestCase.csv", false));
            for (long[] pair : timeList) {
                writer.write(String.format("%d\t%d%n", pair[0], pair[1]));
            }
            writer.close();
        } catch (IOException ignored) {}
    }

    @Test
    void timeTest_avgCase() {
        SorterInterface sorter = new InsertSort();
        Random random = new Random();
        long start;
        long elapsed;
        long avg;
        int attempts = 100;
        List<long []> timeList = new ArrayList<>();

        for (int i = 5000; i < 25000; i += 1000) {
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
            BufferedWriter writer = new BufferedWriter(new FileWriter("complexity/timeTest-insertSort-avgCase.csv", false));
            for (long[] pair : timeList) {
                writer.write(String.format("%d\t%d%n", pair[0], pair[1]));
            }
            writer.close();
        } catch (IOException ignored) {}
    }

    @Test
    void timeTest_worstCase() {
        SorterInterface sorter = new InsertSort();
        long start;
        long elapsed;
        long avg;
        int attempts = 100;
        List<long []> timeList = new ArrayList<>();

        for (int i = 5000; i < 25000; i += 1000) {
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
            for (long[] pair : timeList) {
                writer.write(String.format("%d\t%d%n", pair[0], pair[1]));
            }
            writer.close();
        } catch (IOException ignored) {}
    }
}