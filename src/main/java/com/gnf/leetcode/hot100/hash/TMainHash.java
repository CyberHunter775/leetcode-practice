package com.gnf.leetcode.hot100.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hejingxin
 */
public class TMainHash {
    public static void main(String[] args) {
        int[] nums = {0,1};
        System.out.println(missingNumber(nums));
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


    public static int romanToInt(String s) {
        return 0;
    }

    // 169. 多数元素
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        int tempMax = 0;
        int index = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            Integer entryKey = entry.getKey();
            if (tempMax == 0) {
                tempMax = value;
                index = entryKey;
            } else if (value >= tempMax) {
                tempMax = value;
                index = entryKey;
            }
        }
        return index;
    }

    // 268. 丢失的数字
    public static int missingNumber(int[] nums) {
        // 全放到map集合中
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>(length);
        for (int i = 0; i < length; i++) {
            map.put(nums[i], nums[i]);
        }
        int index = -1;
        for (int i = 0; i < length+1; i++) {
            if (!map.containsKey(i)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
