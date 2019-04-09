import java.util.List;

/*
 * @lc app=leetcode id=513 lang=java
 *
 * [513] Find Bottom Left Tree Value
 *
 * https://leetcode.com/problems/find-bottom-left-tree-value/description/
 *
 * algorithms
 * Medium (58.01%)
 * Total Accepted:    68K
 * Total Submissions: 117K
 * Testcase Example:  '[2,1,3]'
 *
 * 
 * Given a binary tree, find the leftmost value in the last row of the tree. 
 * 
 * 
 * Example 1:
 * 
 * Input:
 * 
 * ⁠   2
 * ⁠  / \
 * ⁠ 1   3
 * 
 * Output:
 * 1
 * 
 * 
 * 
 * ⁠ Example 2: 
 * 
 * Input:
 * 
 * ⁠       1
 * ⁠      / \
 * ⁠     2   3
 * ⁠    /   / \
 * ⁠   4   5   6
 * ⁠      /
 * ⁠     7
 * 
 * Output:
 * 7
 * 
 * 
 * 
 * Note:
 * You may assume the tree (i.e., the given root node) is not NULL.
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } } bfs找到每一行第一个节点的情况
 * 返回最后一行第一个即可
 * 
 * 递归 记录当前的深度，如果比之前的最大深度深，则更新深度和结果 这题 inorder 左中右 pre 中左右 post都可以 左右中，
 * 因为只要左边先于右边即可，这样更新时左边的值会先更新
 */
class Solution {
    int depth = 0;
    int result;

    public int findBottomLeftValue(TreeNode root) {
        result = root.val;
        helper(root, 0);
        return result;
    }

    public void helper(TreeNode root, int curDepth) {
        if (root == null)
            return;
        helper(root.left, curDepth + 1);
        if (depth < curDepth) {
            depth = curDepth;
            result = root.val;
        }
        helper(root.right, curDepth + 1);
    }
}
// Queue<TreeNode> q = new LinkedList<>();
// q.add(root);
// int result =root.val;
// while (!q.isEmpty()) {
// int size = q.size();
// for (int i = 0; i < size; i++) {
// root = q.poll();
// if (i == 0)
// result = root.val;
// if (root.left != null)
// q.add(root.left);
// if (root.right != null)
// q.add(root.right);
// }
// }
// return result;
// }
// }
