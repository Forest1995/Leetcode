import java.util.Stack;



/*
 * @lc app=leetcode id=99 lang=java
 *
 * [99] Recover Binary Search Tree
 *
 * https://leetcode.com/problems/recover-binary-search-tree/description/
 *
 * algorithms
 * Hard (34.05%)
 * Total Accepted:    113.7K
 * Total Submissions: 332.7K
 * Testcase Example:  '[1,3,null,null,2]'
 *
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,3,null,null,2]
 * 
 * 1
 * /
 * 3
 * \
 * 2
 * 
 * Output: [3,1,null,null,2]
 * 
 * 3
 * /
 * 1
 * \
 * 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,1,4,null,null,2]
 * 
 * ⁠ 3
 * ⁠/ \
 * 1   4
 * /
 * 2
 * 
 * Output: [2,1,4,null,null,3]
 * 
 * ⁠ 2
 * ⁠/ \
 * 1   4
 * /
 * ⁠ 3
 * 
 * 
 * Follow up:
 * 
 * 
 * A solution using O(n) space is pretty straight forward.
 * Could you devise a constant space solution?
 * 
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 * 
 * 思路 
 * inorder traverse 打印出的数字是sorted的 
 * 找到不符合的两个数字 例如63452 要找到6 和 2 的位置
 * 找到后将6和2的值交换即可
 * 
 */
class Solution {
    TreeNode firstElement = null;
    TreeNode secondElement = null;
    TreeNode preElement = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (firstElement == null && preElement.val >= root.val)
                firstElement = preElement;
            if (firstElement != null && preElement.val >= root.val)
                secondElement = root;
            preElement = root;
            root=root.right;
        }
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }
}

// traverse(root);
// int temp = firstElement.val;
// firstElement.val = secondElement.val;
// secondElement.val = temp;
// }

// public void traverse (TreeNode root){
// if(root==null)
// return;
// traverse(root.left);
// if(firstElement==null&&preElement.val>=root.val){
// firstElement=preElement;
// }
// if(firstElement!=null&&preElement.val>=root.val){
// secondElement=root;
// }
// preElement=root;
// traverse(root.right);
// }
// }
