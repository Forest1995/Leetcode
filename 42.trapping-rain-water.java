/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 *
 * https://leetcode.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (41.85%)
 * Total Accepted:    257.3K
 * Total Submissions: 614.4K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * 
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped. Thanks
 * Marcos for contributing this image!
 * 
 * Example:
 * 
 * 
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * 
 * 
 * 思路：
 * 从左边开始找左边的最高边，从右边开始找右边最高边
 * 如果左边的值小，根据木桶原理，比左边最大值 小的边 可以容下 leftmax-height[left]的水，
 * 证明： 2种情况 ：1. 如果右面有一条边比当前leftmax高，那么 至少是可以装下 Leftmax-height[left]的水的，因为左边的低
 * 2.如果右边没有一条边当前高，那么说明到rightmax之前都没碰到比它高的边，那么它还是可以装下这么多水
 */
class Solution {
    public int trap(int[] height) {
        int left=0;
        int right =height.length-1;
        int leftmax = 0;
        int rightmax= 0;
        int result=0;
        while (left<=right){
            leftmax=Math.max(leftmax,height[left]);
            rightmax=Math.max(rightmax,height[right]);
            if(leftmax<rightmax){
                result+= leftmax-height[left];
                left++;
            }
            else{
                result+=rightmax-height[right];
                right--;
            }
        }
        return result;
    }
}

