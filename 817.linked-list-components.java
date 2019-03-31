import java.util.HashSet;

/*
 * @lc app=leetcode id=817 lang=java
 *
 * [817] Linked List Components
 *
 * https://leetcode.com/problems/linked-list-components/description/
 *
 * algorithms
 * Medium (54.05%)
 * Total Accepted:    21.9K
 * Total Submissions: 40.5K
 * Testcase Example:  '[0,1,2,3]\n[0,1,3]'
 *
 * We are given head, the head node of a linked list containing unique integer
 * values.
 * 
 * We are also given the list G, a subset of the values in the linked list.
 * 
 * Return the number of connected components in G, where two values are
 * connected if they appear consecutively in the linked list.
 * 
 * Example 1:
 * 
 * 
 * Input: 
 * head: 0->1->2->3
 * G = [0, 1, 3]
 * Output: 2
 * Explanation: 
 * 0 and 1 are connected, so [0, 1] and [3] are the two connected components.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 
 * head: 0->1->2->3->4
 * G = [0, 3, 1, 4]
 * Output: 2
 * Explanation: 
 * 0 and 1 are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the
 * two connected components.
 * 
 * 
 * Note: 
 * 
 * 
 * If N is the length of the linked list given by head, 1 <= N <= 10000.
 * The value of each node in the linked list will be in the range [0, N -
 * 1].
 * 1 <= G.length <= 10000.
 * G is a subset of all values in the linked list.
 * 
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 * 
 * 思路 关键是理解题意，题意是connecnt component的个数， 用hashset记录所有的值 所以如果当前val在set里，判断下一个 node
 * 如果是 null或者 它的值不在 hashset里，则说明它是一个独立的component，让结果加1
 * 如果在hashset里，说明这个component还可以扩大，有2个以上，暂时不加result，等到最后一个node的时候再加
 * 
 */
class Solution {
    public int numComponents(ListNode head, int[] G) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < G.length; i++) {
            set.add(G[i]);
        }
        int result = 0;
        while (head != null) {
            if (set.contains(head.val)) {
                if (head.next == null || !set.contains(head.next.val))
                    result++;
            }
            head = head.next;
        }
        return result;
    }
}
