/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (38.31%)
 * Total Accepted:    145.8K
 * Total Submissions: 378.7K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * 
 * Return the following binary tree:
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } } 
 * 
 * 思路 postoder
 * 从后往前看，先是root，然后是右子树， 所以相当于preorder反过来写
 */
class Solution {
    int postEnd;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        postEnd = postorder.length - 1;
        return helper(postorder, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] postorder, int inStart, int inEnd) {
        if (postEnd < 0 || inStart > inEnd)
            return null;
        int inIndex = map.get(postorder[postEnd]);
        TreeNode root = new TreeNode(postorder[postEnd--]);
        root.right = helper(postorder, inIndex + 1, inEnd);
        root.left = helper(postorder, inStart, inIndex - 1);
        return root;
    }
}
