package leetcode.q0001_two_sum;

import util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和  https://leetcode.cn/problems/two-sum/
 * 提交时：把 twoSum 方法整段粘到 LeetCode 编辑器即可（main 方法留在这边不粘）。
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> idx = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (idx.containsKey(need)) {
                return new int[]{idx.get(need), i};
            }
            idx.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.arrayEq(new int[]{0, 1}, s.twoSum(new int[]{2, 7, 11, 15}, 9));
        Assert.arrayEq(new int[]{1, 2}, s.twoSum(new int[]{3, 2, 4}, 6));
        Assert.arrayEq(new int[]{0, 1}, s.twoSum(new int[]{3, 3}, 6));
        Assert.done();
    }
}
