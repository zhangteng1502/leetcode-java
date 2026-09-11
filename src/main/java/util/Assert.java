package util;

import java.util.Arrays;
import java.util.Objects;

/**
 * 极简断言工具：不依赖 JUnit，写完 main 方法就能自测。
 * <p>
 * 用法：
 * <pre>{@code
 * Assert.eq(9, s.lengthOfLongestSubstring("abcabcbb"));
 * Assert.arrayEq(new int[]{0, 1}, s.twoSum(nums, 9));
 * Assert.done();   // 最后一行，输出汇总
 * }</pre>
 */
public final class Assert {

    private static int total = 0;
    private static int passed = 0;

    private Assert() {
    }

    public static void eq(long expected, long actual) {
        total++;
        if (expected == actual) {
            passed++;
            return;
        }
        fail("期望 " + expected + "，实际 " + actual);
    }

    public static void eq(double expected, double actual, double eps) {
        total++;
        if (Math.abs(expected - actual) <= eps) {
            passed++;
            return;
        }
        fail("期望 " + expected + "，实际 " + actual);
    }

    public static void eq(String expected, String actual) {
        total++;
        if (Objects.equals(expected, actual)) {
            passed++;
            return;
        }
        fail("期望 \"" + expected + "\"，实际 \"" + actual + "\"");
    }

    public static void arrayEq(int[] expected, int[] actual) {
        total++;
        if (Arrays.equals(expected, actual)) {
            passed++;
            return;
        }
        fail("期望 " + Arrays.toString(expected) + "，实际 " + Arrays.toString(actual));
    }

    public static void array2dEq(int[][] expected, int[][] actual) {
        total++;
        if (Arrays.deepEquals(expected, actual)) {
            passed++;
            return;
        }
        fail("期望 " + Arrays.deepToString(expected) + "，实际 " + Arrays.deepToString(actual));
    }

    public static void isTrue(boolean cond) {
        total++;
        if (cond) {
            passed++;
            return;
        }
        fail("期望 true，实际 false");
    }

    /** 最后一个用例跑完调用，打印汇总；有失败则抛异常让 IDEA 标红。 */
    public static void done() {
        System.out.println("---- " + passed + "/" + total + " 通过 ----");
        if (passed != total) {
            total = 0;
            passed = 0;
            throw new AssertionError("有用例未通过");
        }
        total = 0;
        passed = 0;
    }

    private static void fail(String msg) {
        throw new AssertionError("❌ " + msg + "  @" + caller());
    }

    private static String caller() {
        StackTraceElement[] st = Thread.currentThread().getStackTrace();
        for (StackTraceElement e : st) {
            if (!e.getClassName().equals(Assert.class.getName())) {
                return e.getClassName().replaceAll("^.*\\.", "") + ":" + e.getLineNumber();
            }
        }
        return "unknown";
    }
}
