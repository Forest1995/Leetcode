/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 *
 * https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 *
 * algorithms
 * Hard (30.22%)
 * Total Accepted:    162.2K
 * Total Submissions: 532.6K
 * Testcase Example:  '[2,1,5,6,2,3]'
 *
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 * 
 * 
 * 
 * 
 * Above is a histogram where width of each bar is 1, given height =
 * [2,1,5,6,2,3].
 * 
 * 
 * 
 * 
 * The largest rectangle is shown in the shaded area, which has area = 10
 * unit.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: [2,1,5,6,2,3]
 * Output: 10
 * 
 * 思路1：
 * 1.首先想到找到数组最小值，然后乘以当前数组长度就是最大面积
 * 遍历数组，找到最小值并判断是否sorted
 * 如果有后一个数小于前一个数，则不是sorted
 * 如果有height[i]<height[minpos] 则令minpos = i；
 * 
 * 分支1 ：考虑到如果是sorted数组，那么需要计算每一个元素的对应的面积找到最大值
 * 
 * 分支2：不是sorted数组
 * 2.如果想要找到更大的面积，只能去掉这个最小值，在这个最小值的左边和右边分别找到subarray的最大面积
 * 3.最后取三个部分的最大值即可
 * 
 * 注意开头边界情况的限制
 * 
 * 
 * 思路2：
 * 维护一个递增的栈，这个栈保存了元素在数组中的位置。
 * 这样在栈中每一个左边的bar都比本身小，所以左边就天然有界了，也就是左边界就是左边的一个bar。
 * 遍历一遍height数组，
 * 在将height数组入栈的时候，如果当前元素height[i]比栈顶元素小，则我们又找到了栈顶元素的右边界。
 * 
 * 因此我们在此时就可以计算以栈顶元素为最低bar的矩形面积了，因为左右边界我们都已经找到了，而且是在O(1)的时间复杂度内找到的。
 * 然后就可以将栈顶元素出栈了。这样每出栈一个元素，即计算以此元素为最低点的矩形面积。
 * 当最终栈空的时候我们就计算出了以所有bar为最低点的矩形面积。
 * 为保证让所有元素都出栈，我们在height数组最后加一个0，因为一个元素要出栈必须要遇到一个比他小的元素，也就是右边界。
 * 
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack <Integer> stack = new Stack <>();
        int maxArea = 0;
        int n =heights.length;
        for(int i=0; i<=n;i++){
            int h = (i==n)? 0: heights[i];
            while ( !stack.isEmpty()&& h< heights[stack.peek()]){
                int curHeight = heights[stack.pop()];
                int curWidth = stack.isEmpty()?i: i-1-stack.peek();
                maxArea = Math.max(maxArea,curHeight*curWidth);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
    //     return getMax(0, heights.length - 1, heights);
    // }

    // public int getMax(int left, int right, int[] heights) {
    //     if (left > right)
    //         return 0;
    //     else if (left == right)
    //         return heights[left];
    //     int minPos = left;
    //     boolean sorted = true;
    //     for (int i = left + 1; i <= right; i++) {
    //         if (heights[i - 1] > heights[i])
    //             sorted = false;
    //         if (heights[minPos] > heights[i])
    //             minPos = i;
    //     }
    //     if (sorted) {
    //         int max = 0;
    //         for (int i = left; i <= right; i++)
    //             max = Math.max(max, (right - i + 1) * heights[i]);
    //         return max;
    //     }
    //     int leftmax = getMax(left, minPos - 1, heights);
    //     int rightmax = getMax(minPos + 1, right, heights);
    //     int localmax = heights[minPos] * (right - left + 1);
    //     return Math.max(localmax, Math.max(leftmax, rightmax));
    // }
// }
