/*
 * @lc app=leetcode id=124 lang=java
 *
 * [124] Binary Tree Maximum Path Sum
 *
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 *
 * algorithms
 * Hard (29.47%)
 * Total Accepted:    180.2K
 * Total Submissions: 609K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a non-empty binary tree, find the maximum path sum.
 * 
 * For this problem, a path is defined as any sequence of nodes from some
 * starting node to any node in the tree along the parent-child connections.
 * The path must contain at least one node and does not need to go through the
 * root.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3]
 * 
 * ⁠      1
 * ⁠     / \
 * ⁠    2   3
 * 
 * Output: 6
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [-10,9,20,null,null,15,7]
 * 
 * -10
 * / \
 * 9  20
 * /  \
 * 15   7
 * 
 * Output: 42
 * 
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } } 思路
 * 
 * 
 * 
 * For each node there can be four ways that the max path goes through the node:
 * 
 * 1. Node only  如果左右子树都是负数 那么都设置为0
 * 
 * 2. Max path through Left Child + Node  如果右子树小于0，这种情况通过MAX 来解决
 * 
 * 3. Max path through Right Child + Node  如果左子树小于0，这种情况通过MAX 来解决
 * 
 * 4. Max path through Left Child + Node + Max path through Right Child
 * 
 * 所以需要找到这四个中的最大值，并且是在在每一步dfs的过程中同步更新最大值
 * 同时需要注意，如果左边或者右边的子树已经小于0了，那么就不要将他们加进来，直接取0 用max来实现
 * 返回的是当前node值加上左右子树大的那个  作为它上一层函数的结果
 */
class Solution {
    public int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathDown(root);
        return max;
    }

    public int maxPathDown(TreeNode root) {
        if (root == null)
            return 0;
        int left = Math.max(maxPathDown(root.left), 0);
        int right = Math.max(maxPathDown(root.right), 0);
        max = Math.max(max, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
