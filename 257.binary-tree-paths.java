/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
 *
 * https://leetcode.com/problems/binary-tree-paths/description/
 *
 * algorithms
 * Easy (45.26%)
 * Total Accepted:    216.8K
 * Total Submissions: 477.5K
 * Testcase Example:  '[1,2,3,null,5]'
 *
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * 
 * Input:
 * 
 * ⁠  1
 * ⁠/   \
 * 2     3
 * ⁠\
 * ⁠ 5
 * 
 * Output: ["1->2->5", "1->3"]
 * 
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } } 思路
 * 常规递归，每次到最后一个leaf时把结果加进去即可
 * 
 * stack 双stack 另一个用来记录temp值 
 * 
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<TreeNode> treeStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String temp = "";
        treeStack.push(root);
        stringStack.push(temp);
        while (!treeStack.isEmpty()) {
            root = treeStack.pop();
            temp = stringStack.pop();
            if (root.left == null && root.right == null) {
                result.add(temp + root.val);
            }
            if (root.left != null) {
                treeStack.push(root.left);
                stringStack.push(temp+root.val+"->");
            }
            if(root.right!=null){
                treeStack.push(root.right);
                stringStack.push(temp+root.val+"->");
            }
        }
        return result;
    }
}

// List<String> result = new ArrayList<>();
// helper(result, "", root);
// return result;
// }

// public void helper(List<String> result, String temp, TreeNode root) {
// if (root == null)
// return;
// if (root.left == null && root.right == null) {
// temp = temp + root.val;
// result.add(temp);
// }
// helper(result, temp + root.val + "->", root.left);
// helper(result, temp + root.val + "->", root.right);
// }
// }
