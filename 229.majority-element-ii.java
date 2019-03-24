import java.util.HashMap;

import javax.lang.model.util.ElementScanner6;

/*
 * @lc app=leetcode id=229 lang=java
 *
 * [229] Majority Element II
 *
 * https://leetcode.com/problems/majority-element-ii/description/
 *
 * algorithms
 * Medium (31.47%)
 * Total Accepted:    94.8K
 * Total Submissions: 301.1K
 * Testcase Example:  '[3,2,3]'
 *
 * Given an integer array of size n, find all elements that appear more than ⌊
 * n/3 ⌋ times.
 * 
 * Note: The algorithm should run in linear time and in O(1) space.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,3]
 * Output: [3]
 * 
 * Example 2:
 * 
 * 
 * Input: [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 * 思路：摩尔投票升级版，超过n/3的数最多只能有两个；
    先选出两个候选人A,B,(出现次数做多的两个数，但不确实是否大于1/3)
    遍历数组，如果投A（等于A），则A的票数++;如果投B，B的票数++；
    如果A,B都不投（即与A，B都不相等）,那么检查此时是否AB中候选人的票数是否为0，如果为0,则成为新的候选人；
    如果A,B两个人的票数都不为0，那么A,B两个候选人的票数均--；
    遍历结束后选出两个候选人，但是这两个候选人是否满足>n/3，还需要再遍历一遍数组，找出两个候选人的具体票数
    
    思路2
    hashmap做法，key是num value是count
    遍历数组后判断count是否大于1/3，是的话加入对应num
 */

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<Integer>();
        int majorNum1 = nums[0];
        int majorNum2 = nums[0];
        int count1 = 0;
        int count2 = 0;
        for (int num : nums) {
            if (majorNum1 == num)
                count1++;
            else if (majorNum2 == num)
                count2++;
            else if (count1 == 0) {
                majorNum1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                majorNum2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == majorNum1)
                count1++;
            else if (num == majorNum2)
                count2++;
        }
        List<Integer> result = new ArrayList<>();
        if (count1 > nums.length / 3)
            result.add(majorNum1);
        if (count2 > nums.length / 3)
            result.add(majorNum2);
        return result;
    }
}
// HashMap<Integer, Integer> map = new HashMap<>();
// List<Integer> result = new ArrayList<>();
// for (int num : nums) {
// if (map.containsKey(num))
// map.put(num, map.get(num) + 1);
// else
// map.put(num, 1);
// }
// map.forEach((num, count) -> {
// if (count > nums.length / 3)
// result.add(num);
// });
// return result;
// }
// }
