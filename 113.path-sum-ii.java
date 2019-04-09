
/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
 *
 * https://leetcode.com/problems/path-sum-ii/description/
 *
 * algorithms
 * Medium (39.74%)
 * Total Accepted:    220.7K
 * Total Submissions: 552.8K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,5,1]\n22'
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given the below binary tree and sum = 22,
 * 
 * 
 * ⁠     5
 * ⁠    / \
 * ⁠   4   8
 * ⁠  /   / \
 * ⁠ 11  13  4
 * ⁠/  \    / \
 * 7    2  5   1
 * 
 * 
 * Return:
 * 
 * 
 * [
 * ⁠  [5,4,11,2],
 * ⁠  [5,8,4,5]
 * ]
 * 
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 * 
 * 
 * 思路：
 * 每次向下 左边，找sum-自己的值 ， 右边，sum-自己的值 
 * 截至条件 如果root是空，则返回
 * 如果root不为空    且root和sum相等且左右子树都为空 则符合条件，将其加入result
 * 
 * 注意 记得删除temp里的最后一个值，这样才不影响后面的判断
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), root, sum);
        return result;
    }
    
    public void helper(List<List<Integer>> result, List<Integer> temp, TreeNode root, int sum) {
        if (root == null)
            return;
        temp.add(root.val);
        if (root.val == sum && root.left == null && root.right == null) {
            result.add(new ArrayList(temp));
            temp.remove(temp.size()-1);
            return;
        }
        helper(result, temp, root.left, sum-root.val);
        helper(result, temp, root.right, sum-root.val);
        temp.remove(temp.size()-1);
    }
}
