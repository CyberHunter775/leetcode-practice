package com.gnf.leetcode.hot100.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hejingxin
 * @date 2024-04-10 23:17
 */
public class TMainHash {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 13;
        int[] ints = twoSum2(nums, target);
        System.out.println(Arrays.toString(ints));
    }
    // 暴力算法
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
    // hash算法
    public static int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> mm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (mm.containsKey(temp)) {
                res[0] = i;
                res[1] = mm.get(temp);
            }
            mm.put(nums[i], i);
        }
        return res;
    }
}
