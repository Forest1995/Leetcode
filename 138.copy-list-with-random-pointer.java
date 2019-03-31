import java.util.HashMap;

/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 *
 * https://leetcode.com/problems/copy-list-with-random-pointer/description/
 *
 * algorithms
 * Medium (26.10%)
 * Total Accepted:    230.6K
 * Total Submissions: 881.6K
 * Testcase Example:  '{"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}'
 *
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input:
 * 
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 * 
 * Explanation:
 * Node 1's value is 1, both of its next and random pointer points to Node 2.
 * Node 2's value is 2, its next pointer points to null and its random pointer
 * points to itself.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * You must return the copy of the given head as a reference to the cloned
 * list.
 * 
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
思路：
存一个hashmap key是原来的node， value是新建的node，
存完之后再跑一遍nodelist，更新对应的random和nextvalue

*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap <Node, Node> map = new HashMap<>();
        Node current = head;
        while(current!=null){
            map.put(current, new Node(current.val));
            current=current.next;
        }
        current =head;
        while(current!=null){
            map.get(current).next= map.get(current.next);
            map.get(current).random= map.get(current.random);
            current=current.next;
        }
        return map.get(head);
    }
}

