package zinjvi.algo;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

/**
 * @author Vitalii Zinchenko
 */
public class BitwiseTest {

    @Test
    public void test_big_integer() {
        Assert.assertEquals(new BigInteger("0"), new BigInteger("0", 2));
        Assert.assertEquals(new BigInteger("1"), new BigInteger("1", 2));
        Assert.assertEquals(new BigInteger("2"), new BigInteger("10", 2));
        Assert.assertEquals(new BigInteger("3"), new BigInteger("11", 2));

//        BigInteger.ZERO
    }

    @Test
    public void test_1() {
        Assert.assertEquals("0", Integer.toBinaryString(0));
        Assert.assertEquals("1", Integer.toBinaryString(1));
        Assert.assertEquals("10", Integer.toBinaryString(2));
        Assert.assertEquals("11", Integer.toBinaryString(3));
    }

    @Test
    public void test_and() {
        int result = Integer.parseInt("100101", 2) & Integer.parseInt("100101", 2);
        Assert.assertEquals("100101", Integer.toBinaryString(result));

        result = Integer.parseInt("100101", 2) & Integer.parseInt("100100", 2);
        Assert.assertEquals("100100", Integer.toBinaryString(result));
    }

    @Test
    public void test_or() {
        int result = Integer.parseInt("100101", 2) | Integer.parseInt("100101", 2);
        Assert.assertEquals("100101", Integer.toBinaryString(result));

        result = Integer.parseInt("100101", 2) | Integer.parseInt("100100", 2);
        Assert.assertEquals("100101", Integer.toBinaryString(result));

        result = Integer.parseInt("100100", 2) | Integer.parseInt("100100", 2);
        Assert.assertEquals("100100", Integer.toBinaryString(result));
    }

    @Test
    public void test_complement() {
        int result = ~ Integer.parseInt("100101", 2);
        Assert.assertEquals("11111111111111111111111111011010", Integer.toBinaryString(result));
    }

    @Test
    public void test_xor() {
        int result = Integer.parseInt("100101", 2) ^ Integer.parseInt("100100", 2);
        Assert.assertEquals("1", Integer.toBinaryString(result));

        result = Integer.parseInt("100101", 2) ^ Integer.parseInt("000100", 2);
        Assert.assertEquals("100001", Integer.toBinaryString(result));

        result = Integer.parseInt("100001", 2) ^ Integer.parseInt("000100", 2);
        Assert.assertEquals("100101", Integer.toBinaryString(result));
    }

    @Test
    public void test_signed_left() {
        int result = Byte.parseByte("10001", 2) << 2;
        Assert.assertEquals(  "1000100", Integer.toBinaryString(result));

        // Set third bit to "1", no matter it was "1" or zero
        result = Byte.parseByte("10001", 2) | 1 << 2;
        Assert.assertEquals(  "10101", Integer.toBinaryString(result));
        result = Byte.parseByte("10101", 2) | 1 << 2;
        Assert.assertEquals(  "10101", Integer.toBinaryString(result));

        // Set third bit to "0", no matter it was "1" or zero
        result = Byte.parseByte("10101", 2) & ~(1 << 2);
        Assert.assertEquals(  "10001", Integer.toBinaryString(result));
        result = Byte.parseByte("10001", 2) & ~(1 << 2);
        Assert.assertEquals(  "10001", Integer.toBinaryString(result));
    }

    @Test
    public void test_signed_right() {
        int result = Byte.parseByte("00100101", 2) >> 2;
        Assert.assertEquals("1001", Integer.toBinaryString(result));
    }

    @Test
    public void test_unsigned_right() {
        int result = Integer.parseInt("10100100", 2) >>> 2;
        Assert.assertEquals("101001", Integer.toBinaryString(result));
    }

    @Test
    public void bit_count() {
        Assert.assertEquals(1, Integer.bitCount(1));
        Assert.assertEquals(1, Integer.bitCount(2));
        Assert.assertEquals(2, Integer.bitCount(3));
    }

}
