public class SelectionSort implements SorterInterface {
    @Override
    public double[] sort(double[] source) {
        if (source == null) throw new NullArrayException();

        double[] output = source.clone();
        int n = output.length;

        for (int i = 0; i < n; i++) {
            int smallestValIndex = i;

            for (int j = i; j < n; j ++) {
                if (output[j] < output[smallestValIndex]) smallestValIndex = j;
            }

            if (smallestValIndex != i) SortUtils.swap(output, i, smallestValIndex);
        }

        return output;
    }
}