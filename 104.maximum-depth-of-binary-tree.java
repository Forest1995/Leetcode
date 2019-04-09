import java.util.Stack;

/*
 * @lc app=leetcode id=104 lang=java
 *
 * [104] Maximum Depth of Binary Tree
 *
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (59.55%)
 * Total Accepted:    477K
 * Total Submissions: 798.5K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the
 * root node down to the farthest leaf node.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * return its depth = 3.
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } } 
 * 
 * 思路： 递归简单。。。 
 * 
 * stack 双stack
 * 一个村node 一个存当前depth 先弹出最上面一个node和depth，更新最大值，然后判断左子树和右子树有没有
 * 有的话加入stack，要先加右子树，这样的话就相当于从左边开始遍历的
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int max = 0;
        int level = 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> value = new Stack<>();
        stack.push(root);
        value.push(1);
        while (!stack.isEmpty()) {
            root = stack.pop();
            int temp = value.pop();
            max = Math.max(temp, max);
            if (root.right != null) {
                stack.push(root.right);
                value.push(temp + 1);
            }
            if (root.left != null) {
                stack.push(root.left);
                value.push(temp + 1);
            }
        }
        return max;
    }
}
// if (root == null)
// return 0;
// return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
// }
// }
