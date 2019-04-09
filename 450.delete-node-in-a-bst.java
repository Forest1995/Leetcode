/*
 * @lc app=leetcode id=450 lang=java
 *
 * [450] Delete Node in a BST
 *
 * https://leetcode.com/problems/delete-node-in-a-bst/description/
 *
 * algorithms
 * Medium (39.41%)
 * Total Accepted:    60.9K
 * Total Submissions: 154.1K
 * Testcase Example:  '[5,3,6,2,4,null,7]\n3'
 *
 * Given a root node reference of a BST and a key, delete the node with the
 * given key in the BST. Return the root node reference (possibly updated) of
 * the BST.
 * 
 * Basically, the deletion can be divided into two stages:
 * 
 * Search for a node to remove.
 * If the node is found, delete the node.
 * 
 * 
 * 
 * Note: Time complexity should be O(height of tree).
 * 
 * Example:
 * 
 * root = [5,3,6,2,4,null,7]
 * key = 3
 * 
 * ⁠   5
 * ⁠  / \
 * ⁠ 3   6
 * ⁠/ \   \
 * 2   4   7
 * 
 * Given key to delete is 3. So we find the node with value 3 and delete it.
 * 
 * One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
 * 
 * ⁠   5
 * ⁠  / \
 * ⁠ 4   6
 * ⁠/     \
 * 2       7
 * 
 * Another valid answer is [5,2,6,null,4,null,7].
 * 
 * ⁠   5
 * ⁠  / \
 * ⁠ 2   6
 * ⁠  \   \
 * ⁠   4   7
 * 
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 * 首先，找到这个node
 * 然后有四种情况 
 * 1 如果左右子树都是空 返回null
 * 2 如果一边为空，返回另一边即可
 * 3 都不为空，找到大于它的最小的那个节点，它的右子树 最最最左边的那个节点
 * 将这个被删除的node的左节点赋给 这个大于它的最小节点的左边，以确保数据不会丢失
 * 然后返回这个被删除节点的右节点即可
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
        return null;
        if(key<root.val)
        root.left = deleteNode(root.left, key);
        else if(key>root.val)
        root.right = deleteNode(root.right,key);
        else{
            //判断前2种情况
            if(root.left==null)
            return root.right;
            if(root.right==null)
            return root.left;
            //找到右边最小值
            TreeNode RightSmallest = root.right ;
            while(RightSmallest.left!=null)
            RightSmallest=RightSmallest.left;
            //将被删除节点 左边的信息 赋给右边最小值，这样符合条件
            RightSmallest.left=root.left;
            //返回 被删除节点 的右节点，相当于进来时 root 返回的时root.right，
            // root和其左半边都被删除，但是左半边之前已经被保存，所以被删除的只有root
            return root.right;
        }
        return root;
    }
}
