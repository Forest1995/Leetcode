import java.util.HashMap;

/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 *
 * https://leetcode.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (40.81%)
 * Total Accepted:    1.5M
 * Total Submissions: 3.6M
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * Example:
 * 
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 
 * 
 * 
 * 
 */
/**思路
 * 扫一遍数组的同时将其存入一个Hashmap,
 * 在新加元素之前判断是否有符合条件的配对，
 * 因为要返回index,所以将Index存成 map 里的Value, 元素存成KEY
 * 返回数组  return new int [] {a,b}
 * 抛出异常 throw new IllegalArgumentException()
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap <Integer, Integer> map= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int complement= target-nums[i];
            if(map.containsKey(complement)){
                return new int []{map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException();
    }
}

