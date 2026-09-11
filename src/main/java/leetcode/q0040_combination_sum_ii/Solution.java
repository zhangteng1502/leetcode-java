package leetcode.q0040_combination_sum_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II  https://leetcode.cn/problems/combination-sum-ii/
 * <p>
 * 题意：candidates 中每个数字在每个组合里只能使用一次，且解集不能包含重复组合。
 * 思路：排序 + 回溯。排序后相同元素相邻，便于「同层去重」——同一层里若 candidates[i] == candidates[i-1]
 * 且 i > start，说明这个重复元素在当前层已经作为代表被选过，跳过即可（跨层的重复如 [1,1,6] 仍然允许）。
 * <p>
 * 提交时：把 combinationSum2 方法整段粘到 LeetCode 编辑器即可（import 与类声明按需保留）。
 */
public class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);            // 排序：让相同元素相邻，方便去重与剪枝
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] candidates, int remain, int start,
                           List<Integer> path, List<List<Integer>> res) {
        if (remain == 0) {
            res.add(new ArrayList<>(path));  // 找到一组和为 target 的组合
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > remain) {    // 剪枝：已排序，后面的更大，无需继续
                break;
            }
            // 同层去重：当前层已用过相同数字，跳过，避免产生重复组合
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            backtrack(candidates, remain - candidates[i], i + 1, path, res); // i+1：每个数只用一次
            path.remove(path.size() - 1);    // 回溯
        }
    }
}
