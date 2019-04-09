import java.util.Stack;


/*
 * @lc app=leetcode id=114 lang=java
 *
 * [114] Flatten Binary Tree to Linked List
 *
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
 *
 * algorithms
 * Medium (41.42%)
 * Total Accepted:    227.4K
 * Total Submissions: 546K
 * Testcase Example:  '[1,2,5,3,4,null,6]'
 *
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example, given the following tree:
 * 
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   5
 * ⁠/ \   \
 * 3   4   6
 * 
 * 
 * The flattened tree should look like:
 * 
 * 
 * 1
 * ⁠\
 * ⁠ 2
 * ⁠  \
 * ⁠   3
 * ⁠    \
 * ⁠     4
 * ⁠      \
 * ⁠       5
 * ⁠        \
 * ⁠         6
 * 
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 * 
 * 思路 递归首先将左子树和右子树分别进行flatten， 然后将右子树贴在左子树的最后，然后把左子树贴到根的右边即可
 * 
 * 思路2 
 * stack 
 * 将每次先将右子树加到stack，然后左子树
 * 然后将右子树更新 为stack的peek 因为如果左边没有的话，相当于还是更新成原来右边的子树
 * 最后记得将左子树变为null
 * 
 * s
 */
class Solution {
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null)
            return;
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            if (root.right != null)
                stack.push(root.right);  //记住，稍后处理
            if (root.left != null)
                stack.push(root.left);   
            if (!stack.isEmpty())
                root.right = stack.peek();
            root.left = null;
        }
    }
}

// if (root == null)
// return;
// flatten(root.left);
// flatten(root.right);
// if (root.left != null) {
// TreeNode leftTail = root.left;
// while (leftTail.right != null) {
// leftTail = leftTail.right;
// }
// leftTail.right = root.right;
// root.right = root.left;
// root.left=null;
// }
// }
// }
