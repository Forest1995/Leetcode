import java.util.Stack;

/*
 * @lc app=leetcode id=226 lang=java
 *
 * [226] Invert Binary Tree
 *
 * https://leetcode.com/problems/invert-binary-tree/description/
 *
 * algorithms
 * Easy (57.33%)
 * Total Accepted:    310.9K
 * Total Submissions: 540.5K
 * Testcase Example:  '[4,2,7,1,3,6,9]'
 *
 * Invert a binary tree.
 * 
 * Example:
 * 
 * Input:
 * 
 * 
 * ⁠    4
 * ⁠  /   \
 * ⁠ 2     7
 * ⁠/ \   / \
 * 1   3 6   9
 * 
 * Output:
 * 
 * 
 * ⁠    4
 * ⁠  /   \
 * ⁠ 7     2
 * ⁠/ \   / \
 * 9   6 3   1
 * 
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 * 
 * Google: 90% of our engineers use the software you wrote (Homebrew), but you
 * can’t invert a binary tree on a whiteboard so f*** off.
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 * 
 * 思路 递归 将当前node的左右节点互换，并且分别进行 invert递归返回当前节点即可
 * 
 * stack 写一下 2种写法都可以
 * 
 * 一种双while loop
 * 
 * 一种类似与bfs的双if写法
 */

class Solution {
    public TreeNode invertTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                TreeNode temp = cur.right;
                cur.right = cur.left;
                cur.left = temp;
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return root;
    }
}
// if (root == null)
// return null;
// Stack<TreeNode> s = new Stack<>();
// s.push(root);
// TreeNode cur = null;
// while (!s.isEmpty()) {
// cur = s.pop();
// TreeNode temp = cur.right;
// cur.right = cur.left;
// cur.left = temp;
// if (cur.right != null)
// s.push(cur.right);
// if (cur.left != null)
// s.push(cur.left);
// }
// return root;
// }
// }
// if (root == null)
// return null;
// TreeNode temp = root.right;
// root.right = invertTree(root.left);
// root.left = invertTree(temp);
// return root;
// }
// }
