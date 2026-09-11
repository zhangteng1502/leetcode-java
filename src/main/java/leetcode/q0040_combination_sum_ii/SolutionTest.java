package leetcode.q0040_combination_sum_ii;

import util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 组合总和 II 的测试类（无 JUnit 依赖，直接 run main 即可）。
 * 右击本文件 -> Run 'SolutionTest.main()'。
 * <p>
 * 因 Assert 没有 List 比较器，这里用 assertCombo：把每组解的内部元素排序、再把所有解按字典序排序，
 * 转成规范字符串后与期望比较，从而忽略 LeetCode 对输出顺序的要求。
 */
public class SolutionTest {

    public static void main(String[] args) {
        Solution s = new Solution();

        // 示例 1
        assertCombo(rows(
                row(1, 1, 6),
                row(1, 2, 5),
                row(1, 7),
                row(2, 6)),
                s.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));

        // 示例 2
        assertCombo(rows(
                row(1, 2, 2),
                row(5)),
                s.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));

        // 边界：无解
        assertCombo(rows(),
                s.combinationSum2(new int[]{2, 3, 5}, 1));

        // 边界：单元素命中
        assertCombo(rows(row(1)),
                s.combinationSum2(new int[]{1}, 1));

        // 边界：全部相同元素，只应得到一种组合 [1,1]
        assertCombo(rows(row(1, 1)),
                s.combinationSum2(new int[]{1, 1, 1, 1}, 2));

        // 边界：重复元素更多，结果不应膨胀
        assertCombo(rows(
                row(1, 1, 6),
                row(1, 2, 5),
                row(1, 7),
                row(2, 6)),
                s.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5, 2}, 8));

        Assert.done();   // 打印 "x/y 通过"，有失败则抛异常让 IDEA 标红
    }

    /** 期望/实际 规范化后比较（忽略顺序）。 */
    private static void assertCombo(List<List<Integer>> expected, List<List<Integer>> actual) {
        Assert.eq(canonical(expected), canonical(actual));
    }

    private static String canonical(List<List<Integer>> lists) {
        List<List<Integer>> copy = new ArrayList<>();
        for (List<Integer> inner : lists) {
            List<Integer> t = new ArrayList<>(inner);
            t.sort(Comparator.naturalOrder());
            copy.add(t);
        }
        copy.sort((a, b) -> {
            int n = Math.min(a.size(), b.size());
            for (int i = 0; i < n; i++) {
                int c = Integer.compare(a.get(i), b.get(i));
                if (c != 0) {
                    return c;
                }
            }
            return Integer.compare(a.size(), b.size());
        });
        return copy.toString();
    }

    /** 构造一个内层组合，如 row(1, 2, 5)。 */
    private static List<Integer> row(int... nums) {
        List<Integer> t = new ArrayList<>();
        for (int n : nums) {
            t.add(n);
        }
        return t;
    }

    /** 构造外层解集合，如 rows(row(1, 7), row(2, 6))。 */
    @SafeVarargs
    private static List<List<Integer>> rows(List<Integer>... lists) {
        return new ArrayList<>(Arrays.asList(lists));
    }
}
