public class InsertSort implements SorterInterface {
    @Override
    public double[] sort(double[] source) {
        double[] output = source.clone();
        int n = output.length;

        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (output[j] < output[j - 1]) swap(output, j - 1, j);
                else break;
            }
        }

        return output;
    }

    private void swap(double[] source, int index1, int index2) {
        if (index1 >= source.length - 1 || index2 >= source.length - 1 || index1 < 0 || index2 < 0)
            throw new IndexOutOfBoundsException();
        else if (index1 == index2) return;

        double temp = source[index1];
        source[index1] = source[index2];
        source[index2] = temp;
    }
}
