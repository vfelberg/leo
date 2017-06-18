package leo;

public class NumberUtils {
    public static double max(double... array) {
        if (array.length == 0) {
            throw new IllegalArgumentException();
        }
        double largest = array[0];
        for (double d : array) {
            if (d > largest) {
                largest = d;
            }
        }
        return largest;
    }

    public static int max(int a, int b, int c) {
        double[] nums = new double[]{a, b, c};
        return (int) max(nums);
    }

}
