import java.util.ArrayList;

/*
 * @lc app=leetcode id=501 lang=java
 *
 * [501] Find Mode in Binary Search Tree
 *
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/description/
 *
 * algorithms
 * Easy (39.05%)
 * Total Accepted:    53.2K
 * Total Submissions: 136K
 * Testcase Example:  '[1,null,2,2]'
 *
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the
 * most frequently occurred element) in the given BST.
 * 
 * Assume a BST is defined as follows:
 * 
 * 
 * The left subtree of a node contains only nodes with keys less than or equal
 * to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or
 * equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * 
 * 
 * 
 * For example:
 * Given BST [1,null,2,2],
 * 
 * 
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  2
 * 
 * 
 * 
 * 
 * return [2].
 * 
 * Note: If a tree has more than one mode, you can return them in any order.
 * 
 * Follow up: Could you do that without using any extra space? (Assume that the
 * implicit stack space incurred due to recursion does not count).
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } } 
 * 这题就是把所有node扫一遍， 1.可以用hashmap存，值是key value是出现次数，最后找到所有mode 
 * 
 * 2. 用全局变量来记录每一个的次数，因为是BST，如果用inorder traversal，相同的值会连续出现，
 * 
 * 所以一旦和前一个数不等，可以立即从1重新开始数
 */
class Solution {
    private int count = 1;
    private Integer preNum;
    private int max = 0;
    private ArrayList<Integer> result;

    public int[] findMode(TreeNode root) {
        result = new ArrayList<>();
        Inorder(root);
        int [] res = new int[result.size()];
        for(int i=0;i<result.size();i++){
            res[i]=result.get(i);
        }
        return res;
    }

    private void Inorder(TreeNode root) {
        if (root == null)
            return;
        Inorder(root.left);
        if (preNum != null) {
            if (root.val == preNum)
                count++;
            else
                count = 1;
        }
        if (count > max) {
            max = count;
            result.clear();
            result.add(root.val);
        } else if (count == max) {
            result.add(root.val);
        }
        preNum=root.val;
        Inorder(root.right);
    }
}
