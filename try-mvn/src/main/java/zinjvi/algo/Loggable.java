package zinjvi.algo;

/**
 * @author Vitalii Zinchenko
 */
public class Loggable {
    protected static void log(String m, Object... arg) {
        System.out.println(String.format(m, arg));
    }
}
