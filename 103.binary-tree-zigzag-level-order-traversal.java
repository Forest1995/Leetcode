import java.util.Queue;

/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * algorithms
 * Medium (40.78%)
 * Total Accepted:    204.8K
 * Total Submissions: 499.8K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
 * 
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 
 * return its zigzag level order traversal as:
 * 
 * [
 * ⁠ [3],
 * ⁠ [20,9],
 * ⁠ [15,7]
 * ]
 * 
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 * 
 * 和102一样，只不过在最后加一个判断， 每当奇数行的时候将当前level reverse一下即可 
 * 1实现：用一个boolean 每次循环后用colllection翻转一下
 * 2实现: 每次加的时候直接用add(0,root.val)
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, result, 0);
        return result;
    }

    public void helper(TreeNode root, List<List<Integer>> result, int level) {
        if (root == null)
            return;
        if (level == result.size())
            result.add(new ArrayList<Integer>());
        if ((level & 1) == 1)
            result.get(level).add(0, root.val);
        else
            result.get(level).add(root.val);
        helper(root.left, result, level + 1);
        helper(root.right, result, level + 1);
    }
}
// List<List<Integer>> result = new ArrayList<>();
// if (root == null)
// return result;
// Queue<TreeNode> q = new LinkedList<>();
// q.add(root);
// boolean reverse = false;
// while (!q.isEmpty()) {
// List<Integer> thisLevel = new ArrayList<>();
// int size = q.size();
// for (int i = 0; i < size; i++) {
// root = q.poll();
// thisLevel.add(root.val);
// if (root.left != null)
// q.add(root.left);
// if (root.right != null)
// q.add(root.right);
// }
// if (reverse)
// Collections.reverse(thisLevel);
// result.add(thisLevel);
// reverse = !reverse;
// }
// return result;
// }
// }
