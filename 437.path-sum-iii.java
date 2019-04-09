/*
 * @lc app=leetcode id=437 lang=java
 *
 * [437] Path Sum III
 *
 * https://leetcode.com/problems/path-sum-iii/description/
 *
 * algorithms
 * Easy (42.16%)
 * Total Accepted:    98.3K
 * Total Submissions: 232.4K
 * Testcase Example:  '[10,5,-3,3,2,null,11,3,-2,null,1]\n8'
 *
 * You are given a binary tree in which each node contains an integer value.
 * 
 * Find the number of paths that sum to a given value.
 * 
 * The path does not need to start or end at the root or a leaf, but it must go
 * downwards
 * (traveling only from parent nodes to child nodes).
 * 
 * The tree has no more than 1,000 nodes and the values are in the range
 * -1,000,000 to 1,000,000.
 * 
 * Example:
 * 
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * 
 * ⁠     10
 * ⁠    /  \
 * ⁠   5   -3
 * ⁠  / \    \
 * ⁠ 3   2   11
 * ⁠/ \   \
 * 3  -2   1
 * 
 * Return 3. The paths that sum to 8 are:
 * 
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 * 
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 * 
 * 思路：
 * 双递归 首先以自己为start 判断一下有没有符合的 这部分和112相同
 * 然后 判断以左右两个子节点为start的 是否有符合的。
 */
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if(root==null)
        return 0;
        return pathSum(root.left,sum)+pathSum(root.right,sum)+helper(root,sum);
    }
    public int helper(TreeNode root, int sum) {
        if (root == null)
            return 0;
        if (root.val == sum)
            return 1+helper(root.left, sum-root.val)+helper(root.right,sum-root.val);
        return helper(root.left, sum-root.val)+helper(root.right,sum-root.val);
    }
}
