/*
 * @lc app=leetcode id=538 lang=java
 *
 * [538] Convert BST to Greater Tree
 *
 * https://leetcode.com/problems/convert-bst-to-greater-tree/description/
 *
 * algorithms
 * Easy (50.18%)
 * Total Accepted:    73.2K
 * Total Submissions: 145.3K
 * Testcase Example:  '[5,2,13]'
 *
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that
 * every key of the original BST is changed to the original key plus sum of all
 * keys greater than the original key in BST.
 * 
 * 
 * Example:
 * 
 * Input: The root of a Binary Search Tree like this:
 * ⁠             5
 * ⁠           /   \
 * ⁠          2     13
 * 
 * Output: The root of a Greater Tree like this:
 * ⁠            18
 * ⁠           /   \
 * ⁠         20     13
 * 
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 * 
 * 反向traversal 这个树     12 11 10 9 8 7 2 1 从大到小
 * 第一个不用变，后面的每次加上前面所有之和，用sum来表示
 * 
 * stack 必循用顺序要求版本
 * 
 */
class Solution {
   // private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        Stack <TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int sum =0;
        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.right;
            }
            cur=stack.pop();
            sum+=cur.val;
            cur.val=sum;
            cur=cur.left;
        }
        return root;
    }
}
//         if (root == null)
//             return null;
//         convertBST(root.right);
//         sum += root.val;
//         root.val = sum;
//         convertBST(root.left);
//         return root;
//     }
// }
