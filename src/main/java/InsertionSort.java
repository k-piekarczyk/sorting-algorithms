public class InsertionSort implements SorterInterface {
    @Override
    public double[] sort(double[] source) {
        if (source == null) throw new NullArrayException();

        double[] output = source.clone();
        int n = output.length;

        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (output[j] < output[j - 1]) SortUtils.swap(output, j - 1, j);
                else break;
            }
        }

        return output;
    }
}