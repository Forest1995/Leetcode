import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=117 lang=java
 *
 * [117] Populating Next Right Pointers in Each Node II
 *
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/
 *
 * algorithms
 * Medium (33.72%)
 * Total Accepted:    175.1K
 * Total Submissions: 517.4K
 * Testcase Example:  '{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":null,"next":null,"right":{"$id":"6","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}'
 *
 * Given a binary tree
 * 
 * 
 * struct Node {
 * ⁠ int val;
 * ⁠ Node *left;
 * ⁠ Node *right;
 * ⁠ Node *next;
 * }
 * 
 * 
 * Populate each next pointer to point to its next right node. If there is no
 * next right node, the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * 
 * 
 * Input:
 * {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":null,"next":null,"right":{"$id":"6","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
 * 
 * Output:
 * {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":null,"right":null,"val":7},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"6","left":null,"next":null,"right":{"$ref":"5"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"6"},"val":1}
 * 
 * Explanation: Given the above binary tree (Figure A), your function should
 * populate each next pointer to point to its next right node, just like in
 * Figure B.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * You may only use constant extra space.
 * Recursive approach is fine, implicit stack space does not count as extra
 * space for this problem.
 * 
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

思路
和上一题的区别在于 不是完美树
所以需要用queue来进行bfs操作
每一层操作时先加入自己的左子树和右子树
然后更新自己的next，注意当自己时这一排最后一个时，不需要更新了

思路2
优化
用while来进行bfs
每次用一个假头指在下一层的前一个位置，用另一个指针来进行连接
最后将root指回下一层开始的位置 也就是假头的下一个位置 

然后记得断开假头与下一层的连接 这样才不会一直循环下去
*/
class Solution {
    public Node connect(Node root) {
        Node result = root;
        Node dummyhead = new Node(0);
        Node cur = dummyhead;
        while (root != null) {
            if (root.left != null) {
                cur.next = root.left;
                cur = cur.next;
            }
            if (root.right != null) {
                cur.next = root.right;
                cur = cur.next;
            }
            root = root.next;
            if (root == null) {
                root = dummyhead.next;
                dummyhead.next = null; // disconnected
                cur = dummyhead;
            }
        }
        return result;
    }
}
// if (root == null)
// return root;
// Queue<Node> q = new LinkedList<>();
// Node dummyHead = root;
// q.add(root);
// while (!q.isEmpty()) {
// int size = q.size();
// for (int i = 0; i < size; i++) {
// root = q.poll();
// if (root.left != null)
// q.add(root.left);
// if (root.right != null)
// q.add(root.right);
// if (i < size - 1)
// root.next = q.peek();
// }
// }
// return dummyHead;
// }
// }
