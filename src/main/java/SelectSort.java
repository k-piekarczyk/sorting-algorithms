public class SelectSort implements SorterInterface {
    @Override
    public double[] sort(double[] source) {
        double[] output = source.clone();
        int n = output.length;

        for (int i = 0; i < n; i++) {
            int smallestValIndex = i;

            for (int j = i; j < n; j ++) {
                if (output[j] < output[smallestValIndex]) smallestValIndex = j;
            }

            if (smallestValIndex != i) swap(output, i, smallestValIndex);
        }

        return output;
    }

    private void swap(double[] source, int index1, int index2) {
        if ( index1 >= source.length - 1 || index2 >= source.length - 1 || index1 < 0 || index2 < 0) throw new IndexOutOfBoundsException();
        else if (index1 == index2) return;

        double temp = source[index1];
        source[index1] = source[index2];
        source[index2] = temp;
    }
}
