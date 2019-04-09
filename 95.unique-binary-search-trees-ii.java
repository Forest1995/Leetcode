import java.util.HashMap;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=95 lang=java
 *
 * [95] Unique Binary Search Trees II
 *
 * https://leetcode.com/problems/unique-binary-search-trees-ii/description/
 *
 * algorithms
 * Medium (35.01%)
 * Total Accepted:    132.1K
 * Total Submissions: 376.2K
 * Testcase Example:  '3'
 *
 * Given an integer n, generate all structurally unique BST's (binary search
 * trees) that store values 1 ... n.
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output:
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 * 
 * ⁠  1         3     3      2      1
 * ⁠   \       /     /      / \      \
 * ⁠    3     2     1      1   3      2
 * ⁠   /     /       \                 \
 * ⁠  2     1         2                 3
 * 
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 * 
 * 思路 1到n是这个BST的正序遍历
 * 为了避免重复，将每个点作为root的情况都考虑一遍，总共有这么多种情况，g(n)=f(1,n)+....+f(n,n);
 * 
 * 再考虑， 当计算(3,n)的时候，左边的可能性为 g(2) 右边的可能性为 g(4)因为连续4数字 1234 和4567可能数一样的 所以只要
 * 用recursion来计算左边和右边的可能情况，最后把它们的每个结果都 当作当前节点的左子和右子 加入到result即可。
 * 
 * 优化：用hashmap记住已经计算过的结果
 */
class Solution {
    HashMap<String, List<TreeNode>> map = new HashMap<>();
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<TreeNode>();
        return helper(1, n);
    }
    public List<TreeNode> helper(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        String key = start + "-" + end;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = helper(start, i - 1);
            List<TreeNode> rightTrees = helper(i + 1, end);
            for (TreeNode leftnode : leftTrees) {
                for (TreeNode rightnode : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftnode;
                    root.right = rightnode;
                    result.add(root);
                }
            }
        }
        map.put(key, result);
        return result;
    }

}
