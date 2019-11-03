import java.util.Arrays;

public class QuickSort implements SorterInterface {
    @Override
    public double[] sort(double[] source) {
        SorterInterface inSort = new InsertSort();
        int inSortLengthThreshold = 10;
        double[] output = source.clone();

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(output.length - 1);

        while (!stack.isEmpty()) {
            int endIndex = stack.pop();
            int startIndex = stack.pop();

            if (endIndex - startIndex < inSortLengthThreshold) {
                double[] almostSortedSub = Arrays.copyOfRange(output, startIndex, endIndex + 1);
                double[] sortedSubarray = inSort.sort(almostSortedSub);

                System.arraycopy(sortedSubarray, 0, output, startIndex, sortedSubarray.length);

                continue;
            }

            int pivotIndex = getMedianPivotIndex(output, startIndex, endIndex);
            pivotIndex = partition(output, pivotIndex, startIndex, endIndex);

            stack.push(pivotIndex + 1);
            stack.push(endIndex);

            stack.push(startIndex);
            stack.push(pivotIndex);
        }

        return output;
    }

    private static int partition(double[] source, int pivotIndex, int startIndex, int endIndex) {
        int l = startIndex;
        int h = endIndex - 1;
        double pivot = source[pivotIndex];

        SortUtils.swap(source, pivotIndex, endIndex);

        while (l < h) {
            if (source[l] < pivot) l++;
            else if (source[h] >= pivot) h--;
            else SortUtils.swap(source, l, h);
        }

        int newPivotIndex = h;
        if (source[h] < pivot) newPivotIndex++;

        SortUtils.swap(source, endIndex, newPivotIndex);
        return newPivotIndex;
    }

    private static int getMedianPivotIndex(double[] source, int startIndex, int endIndex) {
        int middleIndex = (endIndex - startIndex) / 2;

        if ((source[middleIndex] >= source[startIndex] && source[startIndex] >= source[endIndex]) || (source[endIndex] >= source[startIndex] && source[startIndex] >= source[middleIndex]))
            return startIndex;
        else if ((source[startIndex] >= source[middleIndex] && source[middleIndex] >= source[endIndex]) || (source[endIndex] >= source[middleIndex] && source[middleIndex] >= source[startIndex]))
            return middleIndex;
        else
            return endIndex;
    }
}