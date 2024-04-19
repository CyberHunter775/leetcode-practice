package com.gnf.leetcode.hot100.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author hejingxin
 */
public class TMainHash {


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
        for (int i = 0; i < length + 1; i++) {
            if (!map.containsKey(i)) {
                index = i;
                break;
            }
        }
        return index;
    }

    // 290 单词规律
    public static boolean wordPattern(String pattern, String s) {
        int len = pattern.length();
        HashMap<Character, String> map = new HashMap<>(pattern.length());
        String[] str = s.split(" ");
        if (len != str.length) return false;
        for (int i = 0; i < len; i++) {
            char key = pattern.charAt(i);
            String value = str[i];
            if (!map.containsKey(key)) {
                if (map.containsValue(value)) {
                    return false;
                }
                map.put(key, value);
            } else if (!map.get(key).equals(value)) {
                return false;
            }
        }
        return true;
    }

    // 645 错误的集合
    public static int[] findErrorNums(int[] nums) {
        // 从小到大排序
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }

        }
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                if (nums[i] > 1) {
                }
            }
            if (map.containsKey(nums[i])) {
                result[0] = i;
                result[1] = nums[i] + 1;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }

    // 500 键盘行
    public static String[] findWords(String[] words) {
        Map<String, Integer> map = new HashMap<>(26);
        map.put("q", 1);
        map.put("w", 1);
        map.put("e", 1);
        map.put("r", 1);
        map.put("t", 1);
        map.put("y", 1);
        map.put("u", 1);
        map.put("i", 1);
        map.put("o", 1);
        map.put("p", 1);

        map.put("a", 100);
        map.put("s", 100);
        map.put("d", 100);
        map.put("f", 100);
        map.put("g", 100);
        map.put("h", 100);
        map.put("j", 100);
        map.put("k", 100);
        map.put("l", 100);

        map.put("z", 10000);
        map.put("x", 10000);
        map.put("c", 10000);
        map.put("v", 10000);
        map.put("b", 10000);
        map.put("n", 10000);
        map.put("m", 10000);

        List<String> rs = new ArrayList<>(words.length);
        for (int i = 0; i < words.length; i++) {
            String[] word = words[i].split("");
            Set<String> tempWord = new HashSet<>();
            for (int j = 0; j < word.length; j++) {
                tempWord.add(word[j].toLowerCase());
            }
            int count = 0;
            for (String s : tempWord) {
                count += map.get(s);
            }
            int length = tempWord.size();
            if (count == length * 1 || count == length * 100 || count == length * 10000) {
                rs.add(words[i]);
            }
        }
        return rs.toArray(new String[0]);
    }

    /*
        Alice 有 n 枚糖，其中第 i 枚糖的类型为 candyType[i] 。Alice 注意到她的体重正在增长，所以前去拜访了一位医生。

        医生建议 Alice 要少摄入糖分，只吃掉她所有糖的 n / 2 即可（n 是一个偶数）。Alice 非常喜欢这些糖，她想要在遵循医生建议的情况下，尽可能吃到最多不同种类的糖。

        给你一个长度为 n 的整数数组 candyType ，返回： Alice 在仅吃掉 n / 2 枚糖的情况下，可以吃到糖的 最多 种类数。

        示例 1：

        输入：candyType = [1,1,2,2,3,3]
        输出：3
        解释：Alice 只能吃 6 / 2 = 3 枚糖，由于只有 3 种糖，她可以每种吃一枚。
        示例 2：

        输入：candyType = [1,1,2,3]
        输出：2
        解释：Alice 只能吃 4 / 2 = 2 枚糖，不管她选择吃的种类是 [1,2]、[1,3] 还是 [2,3]，她只能吃到两种不同类的糖。
        示例 3：

        输入：candyType = [6,6,6,6]
        输出：1
        解释：Alice 只能吃 4 / 2 = 2 枚糖，尽管她能吃 2 枚，但只能吃到 1 种糖。
*/


    // 575. 分糖果
    public static int distributeCandies(int[] candyType) {
        // 能吃i颗糖果
        int i = candyType.length / 2;
        Set<Integer> set = new HashSet<>();
        for (int j = 0; j < candyType.length; j++) {
            set.add(candyType[j]);
        }
        return i <= set.size() ? i : set.size();
    }


    public static void main(String[] args) {
//        String[] words = {"qwee"};
        System.out.println(distributeCandies(new int[]{1, 1, 2, 2, 3, 3}));
    }
}
