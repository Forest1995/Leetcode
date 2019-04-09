import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=107 lang=java
 *
 * [107] Binary Tree Level Order Traversal II
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
 *
 * algorithms
 * Easy (45.91%)
 * Total Accepted:    216K
 * Total Submissions: 468.8K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the bottom-up level order traversal of its
 * nodes' values. (ie, from left to right, level by level from leaf to root).
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
 * return its bottom-up level order traversal as:
 * 
 * [
 * ⁠ [15,7],
 * ⁠ [9,20],
 * ⁠ [3]
 * ]
 * 
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 * 
 * 
 * 思路： 和102类似，用level来进行dfs，每次当level与当前size相等时，多加一层
 * 不同的地方在于加的每一层都在0这个位置，所以先加的会被推倒后面， 然后再加值的时候，找到正确的位置需要用 size-level-1
 * 
 * 思路 queue BFS
 * 
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null)
            return result;
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> thisLevel = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                root = q.poll();
                thisLevel.add(root.val);
                if (root.left != null)
                    q.add(root.left);
                if (root.right != null)
                    q.add(root.right);
            }
            result.add(0, thisLevel);
        }
        return result;
    }
}
// List<List<Integer>> result = new ArrayList<>();
// helper(result, 0, root);
// return result;
// }

// public void helper(List<List<Integer>> result, int level, TreeNode root) {
// if (root == null)
// return;
// if (result.size() == level) {
// result.add(0, new ArrayList<>());
// }
// result.get(result.size() - level - 1).add(root.val);
// helper(result, level + 1, root.left);
// helper(result, level + 1, root.right);
// }
// }
