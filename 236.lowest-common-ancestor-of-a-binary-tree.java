import java.util.HashMap;
import java.util.HashSet;





/*
 * @lc app=leetcode id=236 lang=java
 *
 * [236] Lowest Common Ancestor of a Binary Tree
 *
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 *
 * algorithms
 * Medium (35.93%)
 * Total Accepted:    260.3K
 * Total Submissions: 718.2K
 * Testcase Example:  '[3,5,1,6,2,0,8,null,null,7,4]\n5\n1'
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given
 * nodes in the tree.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes p and q as the lowest node in T that has both p
 * and q as descendants (where we allow a node to be a descendant of itself).”
 * 
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant
 * of itself according to the LCA definition.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the binary tree.
 * 
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 思路
 * 先用stack 找到2个node的位置首先 用一个hashmap记录每个节点和它的父亲
 * while 循环截至条件为2个节点pq都已在map里
 * 
 * 找到2个节点后，将其中一个节点以及它的所有父亲节点全部加入到一个hashset中，以供后一个节点进行判断
 * 然后判断另一个节点是否在 这个set里，
 * 如果没有，就持续将它更新成自己的父亲继续判断，直到找到，那么这个节点就是最低公共祖先。
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack <TreeNode> s = new Stack<>();
        HashMap <TreeNode, TreeNode> parentMap = new HashMap<>();
        parentMap.put(root,null);
        s.push(root);
        while(!parentMap.containsKey(p)||!parentMap.containsKey(q)){
            root=s.pop();
            if(root.left!=null){
                parentMap.put(root.left,root);
                s.push(root.left);
            }
            if(root.right!=null){
                parentMap.put(root.right,root);
                s.push(root.right);
            }
        }
        HashSet <TreeNode> ancestors = new HashSet<>();
        while(p!=null){
            ancestors.add(p);
            p=parentMap.get(p);
        }
        while(!ancestors.contains(q)){
            q=parentMap.get(q);
        }
        return q;
    }
}

