package utils;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import peter.sphereoj.solutions.in_progress.QuickInteger;

/**
 * Created by Piotr Kulma on 11.04.15.
 */

public class QuickIntegerTest {
    @Test
    public void addTest() {
        performTest(
                new Operation() {
                    public long operation(long a, long b) {
                        return a+b;
                    }
                },
                new OperationQI() {
                    public long operation(long a, long b) {
                        QuickInteger qi = new QuickInteger(Long.toString(a));
                        QuickInteger result = qi.add(new QuickInteger(Long.toString(b)));

                        return Long.parseLong(result.toString());
                    }
                });
    }

    @Test
    public void mulTest() {
        performTest(
                new Operation() {
                        public long operation(long a, long b) {
                            return a*b;
                        }
                    },
                new OperationQI() {
                    public long operation(long a, long b) {
                        QuickInteger qi = new QuickInteger(Long.toString(a));
                        QuickInteger result = qi.mul(new QuickInteger(Long.toString(b)));

                        return Long.parseLong(result.toString());
                    }
                });
    }

    @Test
    public void quickMulTest() {
        performTest(
                new Operation() {
                    public long operation(long a, long b) {
                        return a*b;
                    }
                },
                new OperationQI() {
                    public long operation(long a, long b) {
                        QuickInteger qi = new QuickInteger(Long.toString(a));
                        QuickInteger result = qi.quickMul(new QuickInteger(Long.toString(b)));

                        return Long.parseLong(result.toString());
                    }
                });
    }

    @Test
    public void subTest() {
        performTest2(
                new Operation() {
                    public long operation(long a, long b) {
                        return a - b;
                    }
                },
                new OperationQI() {
                    public long operation(long a, long b) {
                        QuickInteger qi = new QuickInteger(Long.toString(a));
                        QuickInteger result = qi.sub(new QuickInteger(Long.toString(b)));

                        return Long.parseLong(result.toString());
                    }
                });
    }

    @Ignore
    private void performTest(Operation test, OperationQI op) {
        long a, b;

        a = 111111; b = 111111;
        assertEquals(test.operation(a,b), op.operation(a, b));

        a = 222222; b = 222222;
        assertEquals(test.operation(a,b), op.operation(a, b));

        a = 333333; b = 333333;
        assertEquals(test.operation(a,b), op.operation(a, b));

        a = 555555; b = 555555;
        assertEquals(test.operation(a,b), op.operation(a, b));

        a = 999999; b = 999999;
        assertEquals(test.operation(a,b), op.operation(a, b));

        b = 222222; a = 222222;
        assertEquals(test.operation(a,b), op.operation(a, b));

        b = 333333; a = 333333;
        assertEquals(test.operation(a,b), op.operation(a, b));

        b = 555555; a = 555555;
        assertEquals(test.operation(a,b), op.operation(a, b));

        b = 999999; a = 999999;
        assertEquals(test.operation(a,b), op.operation(a, b));


        a = 9999999; b = 11;
        assertEquals(test.operation(a,b), op.operation(a, b));

        a = 21312321; b = 213213;
        assertEquals(test.operation(a,b), op.operation(a, b));

        a = 9999999; b = 999;
        assertEquals(test.operation(a,b), op.operation(a, b));

        a = 123456789; b = 9876542;
        assertEquals(test.operation(a,b), op.operation(a, b));

        a = 21212121; b = 6789;
        assertEquals(test.operation(a,b), op.operation(a, b));

        b = 9999999; a = 11;
        assertEquals(test.operation(a,b), op.operation(a, b));

        b = 21312321; a = 213213;
        assertEquals(test.operation(a,b), op.operation(a, b));

        b = 9999999; a = 999;
        assertEquals(test.operation(a,b), op.operation(a, b));

        b = 123456789; a = 9876542;
        assertEquals(test.operation(a,b), op.operation(a, b));

        b = 21212121; a = 6789;
        assertEquals(test.operation(a,b), op.operation(a, b));


        a = 123333; b = 90000;
        assertEquals(test.operation(a,b), op.operation(a, b));
        a = 9999999; b = 90000;
        assertEquals(test.operation(a,b), op.operation(a, b));
        b = 123333; a = 90000;
        assertEquals(test.operation(a,b), op.operation(a, b));
        b = 9999999; a = 90000;
        assertEquals(test.operation(a,b), op.operation(a, b));
    }

    @Ignore
    private void performTest2(Operation test, OperationQI op) {
        long a, b;

        a = 111111; b = 111111;
        assertEquals(test.operation(a,b), op.operation(a, b));

        a = 222222; b = 222222;
        assertEquals(test.operation(a,b), op.operation(a, b));

        a = 333333; b = 333333;
        assertEquals(test.operation(a,b), op.operation(a, b));

        a = 555555; b = 555555;
        assertEquals(test.operation(a,b), op.operation(a, b));

        a = 999999; b = 999999;
        assertEquals(test.operation(a,b), op.operation(a, b));


        a = 9999999; b = 11;
        assertEquals(test.operation(a,b), op.operation(a, b));

        a = 21312321; b = 213213;
        assertEquals(test.operation(a,b), op.operation(a, b));

        a = 9999999; b = 999;
        assertEquals(test.operation(a,b), op.operation(a, b));

        a = 123456789; b = 9876542;
        assertEquals(test.operation(a,b), op.operation(a, b));

        a = 21212121; b = 6789;
        assertEquals(test.operation(a,b), op.operation(a, b));


        a = 123333; b = 90000;
        assertEquals(test.operation(a,b), op.operation(a, b));

        a = 9999999; b = 90000;
        assertEquals(test.operation(a,b), op.operation(a, b));
    }

    @Ignore
    private interface OperationQI {
        long operation(long a, long b);
    }

    @Ignore
    private interface Operation {
        long operation(long a, long b);
    }
}
