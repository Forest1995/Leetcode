import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
 *
 * https://leetcode.com/problems/validate-binary-search-tree/description/
 *
 * algorithms
 * Medium (25.22%)
 * Total Accepted:    360.3K
 * Total Submissions: 1.4M
 * Testcase Example:  '[2,1,3]'
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * 
 * The left subtree of a node contains only nodes with keys less than the
 * node's key.
 * The right subtree of a node contains only nodes with keys greater than the
 * node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * ⁠   2
 * ⁠  / \
 * ⁠ 1   3
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * ⁠   5
 * ⁠  / \
 * ⁠ 1   4
 * / \
 * 3   6
 * Output: false
 * Explanation: The input is: [5,1,4,null,null,3,6]. The root node's
 * value
 * is 5 but its right child's value is 4.
 * 
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 * 
 * 
 * 思路： 由于验证BSF涉及到两个不相邻 node的比较，所以必须引入2个参数 最大和最小来验证， 一次只验证一个节点的正确性
 * 与自己的左右节点的比较放到下轮来验证
 * 
 * 思路2： tree inorder traversal 利用stack找到理应最小的值，在tree的最左下角 找到后，利用其理应最小的性质，与其右下角
 * 或者上边的进行比较 都必须小于它们才行
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        // return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
        // }

        // private boolean helper(TreeNode root, long Max, long Min) {
        // if (root == null)
        // return true;
        // else if (root.val >= Max || root.val <= Min)
        // return false;
        // else
        // return helper(root.left, root.val, Min) && helper(root.right, Max, root.val);

        if (root == null)
            return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prenode = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prenode != null && prenode.val >= root.val) {
                return false;
            }
            prenode = root;
            root = root.right;
        }
        return true;
    }
}
