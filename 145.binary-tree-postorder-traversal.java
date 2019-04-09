/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-postorder-traversal/description/
 *
 * algorithms
 * Hard (47.32%)
 * Total Accepted:    246.5K
 * Total Submissions: 518K
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * 
 * Example:
 * 
 * 
 * Input: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * Output: [3,2,1]
 * 
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } } 
 * 
 * 思路 将加值操作放在 递归的后面即可 post
 * 放在最后 pre放在之前 in 放在中间
 * 
 * stack: post 左右中 如果倒着看则是 中右左， 和pre 中左右 就差了一点，所以在stack里将左右调换一下
 * 
 * 然后将加值的操作 倒着加即可
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                result.add(0, root.val);
                root = root.right;
            }
            root = stack.pop();
            root = root.left;
        }
        return result;
    }
}
// List<Integer> result = new ArrayList<>();
// helper(result, root);
// return result;
// }

// public void helper(List<Integer> result, TreeNode root) {
// if (root == null)
// return;
// helper(result, root.left);
// helper(result, root.right);
// result.add(root.val);
// }
// }
