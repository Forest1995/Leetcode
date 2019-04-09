/*
 * @lc app=leetcode id=404 lang=java
 *
 * [404] Sum of Left Leaves
 *
 * https://leetcode.com/problems/sum-of-left-leaves/description/
 *
 * algorithms
 * Easy (48.76%)
 * Total Accepted:    120.2K
 * Total Submissions: 246.2K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Find the sum of all left leaves in a given binary tree.
 * 
 * Example:
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * There are two left leaves in the binary tree, with values 9 and 15
 * respectively. Return 24.
 * 
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 * 
 * 思路 递归 看清楚题目，只要最后的leaf值 
 * 
 * 思路2 stack 2种stack方法都可以 因为顺序没啥关系
 * 
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        int sum = 0;
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                if (root.left != null && root.left.left == null && root.left.right == null)
                    sum += root.left.val;
                root = root.left;
            }
            root=s.pop();
            root=root.right;
        }
        return sum;
    }
}
// if (root == null)
// return 0;
// if (root.left != null)
// if (root.left.left == null && root.left.right == null) //只有这种情况下才加值
// return root.left.val + sumOfLeftLeaves(root.right);
// return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
// }
// }
