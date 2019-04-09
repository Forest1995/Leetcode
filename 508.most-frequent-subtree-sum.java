/*
 * @lc app=leetcode id=508 lang=java
 *
 * [508] Most Frequent Subtree Sum
 *
 * https://leetcode.com/problems/most-frequent-subtree-sum/description/
 *
 * algorithms
 * Medium (53.97%)
 * Total Accepted:    46.3K
 * Total Submissions: 85.6K
 * Testcase Example:  '[5,2,-3]'
 *
 * 
 * Given the root of a tree, you are asked to find the most frequent subtree
 * sum. The subtree sum of a node is defined as the sum of all the node values
 * formed by the subtree rooted at that node (including the node itself). So
 * what is the most frequent subtree sum value? If there is a tie, return all
 * the values with the highest frequency in any order.
 * 
 * 
 * Examples 1
 * Input:
 * 
 * ⁠ 5
 * ⁠/  \
 * 2   -3
 * 
 * return [2, -3, 4], since all the values happen only once, return all of them
 * in any order.
 * 
 * 
 * Examples 2
 * Input:
 * 
 * ⁠ 5
 * ⁠/  \
 * 2   -5
 * 
 * return [2], since 2 happens twice, however -5 only occur once.
 * 
 * 
 * Note:
 * You may assume the sum of values in any subtree is in the range of 32-bit
 * signed integer.
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 * 
 * 思路
 * 和上一题一样，将所有的和记录在一个hashmap里，key是值，value是出现次数
 * 然后对于每一个节点，先算以这个节点为头的 sum 加入到hashmap
 * 然后再对左右子节点进行自己的递归
 * 
 * 1.优化 把计算sum和递归整合成一个函数
 */
class Solution {
    int max = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        ComputeSum(root);

        List<Integer> list = new LinkedList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == max)
                list.add(key);
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = list.get(i);
        return res;
    }
    public int ComputeSum(TreeNode root) {
        if (root == null)
            return 0;
        int sum = root.val + ComputeSum(root.left) + ComputeSum(root.right);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        max = Math.max(map.get(sum), max);
        return sum;
    }
}
