import javax.lang.model.util.ElementScanner6;

/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 *
 * https://leetcode.com/problems/container-with-most-water/description/
 *
 * algorithms
 * Medium (42.56%)
 * Total Accepted:    330.6K
 * Total Submissions: 768.2K
 * Testcase Example:  '[1,8,6,2,5,4,8,3,7]'
 *
 * Given n non-negative integers a1, a2, ..., an , where each represents a
 * point at coordinate (i, ai). n vertical lines are drawn such that the two
 * endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together
 * with x-axis forms a container, such that the container contains the most
 * water.
 * 
 * Note: You may not slant the container and n is at least 2.
 * 
 * 
 * 
 * 
 * 
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In
 * this case, the max area of water (blue section) the container can contain is
 * 49. 
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * 思路1： 暴力做法，直接穷尽所有可能，找出最大值，时间复杂 n2
 * 
 * 思路2: 2指针，每次计算当前面积，然后把左右两边短的那一边 向里放，
 * 因为长度变短了，所以只能期待高度变高才有可能增加面积，
 * 如果变长的那边，那么2种情况，
 * 1. 长的更长，但是面积只考虑最短边，所以不能增加面积
 * 2. 长的更短， 更不能增加面积
 * 所以只能变短的那边，期望它变长。
 * 
 * 证明比较复杂
 */
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
