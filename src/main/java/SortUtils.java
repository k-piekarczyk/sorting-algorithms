public class SortUtils {
    public static void swap(double[] source, int index1, int index2) {
        if (index1 >= source.length || index2 >= source.length || index1 < 0 || index2 < 0)
            throw new IndexOutOfBoundsException();
        else if (index1 == index2) return;

        double temp = source[index1];
        source[index1] = source[index2];
        source[index2] = temp;
    }


}
