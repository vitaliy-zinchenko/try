package zinjvi.algo;

import org.junit.Test;

import java.math.BigInteger;

/**
 * @author Vitalii Zinchenko
 */
public class BigIntegerTest {
    @Test
    public void test1() {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        int a = Integer.MAX_VALUE;
        int b = a + 1;
        System.out.println(b);

        byte c1 = Byte.valueOf("000001", 2);
        int  c2 = Integer.valueOf("11111000010", 2);

        int c3 = c1 | c2;
        System.out.println(c1 + ", " + c2 + ", " + c3 + "(" + Integer.toBinaryString(c3) + ")");

        System.out.println("----");

        byte[] d01 = new byte[1];
        byte[] d02 = new byte[1];
        BigInteger d1 = new BigInteger(d01);
        BigInteger d2 = new BigInteger(d02);

        Utils.print(d01);
    }


}
