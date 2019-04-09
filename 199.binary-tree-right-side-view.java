/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
 *
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 *
 * algorithms
 * Medium (46.93%)
 * Total Accepted:    158.2K
 * Total Submissions: 335.5K
 * Testcase Example:  '[1,2,3,null,5,null,4]'
 *
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 * 
 * ⁠  1            <---
 * ⁠/   \
 * 2     3         <---
 * ⁠\     \
 * ⁠ 5     4       <---
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 * 
 * 
 * 思路 bfs queue
 * 
 * 思路2：dfs 递归，先右边后左边
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        helper(result, root, 0);
        return result;
    }

    public void helper(List<Integer> result, TreeNode root, int depth) {
        if (root == null)
            return;
        if (depth == result.size())
            result.add(root.val);
        helper(result, root.right, depth + 1);
        helper(result, root.left, depth + 1);

    }
}
// List<Integer> result = new ArrayList<>();
// if (root == null) {
// return result;
// }
// Queue<TreeNode> q = new LinkedList<>();
// q.add(root);
// while (!q.isEmpty()) {
// int size = q.size();
// for (int i = 0; i < size; i++) {
// root = q.poll();
// if (root.left != null)
// q.add(root.left);
// if (root.right != null)
// q.add(root.right);
// if(i==size-1)
// result.add(root.val);
// }
// }
// return result;
// }
// }
