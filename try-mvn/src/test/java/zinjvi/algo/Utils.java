package zinjvi.algo;

/**
 * @author Vitalii Zinchenko
 */
public final class Utils {

    private Utils() {
    }

    public static void print(byte[] array) {
        StringBuilder sb = new StringBuilder(array.length * 8);
        for (byte b : array) {
            print(b);
        }
    }

    public static void print(byte b) {
        System.out.println(toBinaryString(b));
    }

    public static String toBinaryString(byte b) {
        return String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
    }
}
