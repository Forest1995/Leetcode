import java.util.ArrayList;

import javax.lang.model.util.ElementScanner6;

/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 *
 * https://leetcode.com/problems/triangle/description/
 *
 * algorithms
 * Medium (38.29%)
 * Total Accepted:    172.4K
 * Total Submissions: 447K
 * Testcase Example:  '[[2],[3,4],[6,5,7],[4,1,8,3]]'
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step
 * you may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * 
 * 
 * [
 * ⁠    [2],
 * ⁠   [3,4],
 * ⁠  [6,5,7],
 * ⁠ [4,1,8,3]
 * ]
 * 
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note:
 * 
 * Bonus point if you are able to do this using only O(n) extra space, where n
 * is the total number of rows in the triangle.
 * 
 * 思路1
 * 从上往下计算，
 * 利用dp的思想并一行一行更新当前 最小值
 * 注意第一个元素和最后一个只有一个选择，所以分开讨论
 * 然后再最后一行里找到最小值，便是最小路径
 * 思路2：
 * 从下往上计算，从倒数第二行开始
 * 找到它2个孩子小的那一个加入到自己身上
 * 一行一行往上
 * 最后只要返回 triangle.get(0).get(0)即可
 * 
 * 
 * java 这里get的reference都是指针，
 * 所以改变当前变量的值会直接影响triangle
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> current = triangle.get(i);
            List<Integer> pre = triangle.get(i - 1);
            for (int j = 0; j <= i; j++) {
                if (j == 0)
                    current.set(0, current.get(0) + pre.get(0));
                else if (j == i)
                    current.set(i, current.get(i) + pre.get(i-1));
                else
                    current.set(j, current.get(j) + Math.min(pre.get(j - 1), pre.get(j)));
            }
            //triangle.set(i,current);
        }
        List <Integer> lastRow = triangle.get(triangle.size()-1);
        int min =Integer.MAX_VALUE;
        for(int i =0 ;i<triangle.size();i++){
            min=Math.min(min,lastRow.get(i));
        }
        return min;
    }
}
