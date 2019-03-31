/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
 *
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (34.26%)
 * Total Accepted:    183.2K
 * Total Submissions: 534.4K
 * Testcase Example:  '[1,2,3,4,5]\n2\n4'
 *
 * Reverse a linked list from position m to n. Do it in one-pass.
 * 
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * 
 * Example:
 * 
 * 
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 * 
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 * 
 * 思路：
 * 首先将指针指到m位置，然后开始交换，交换顺序如下
 * 1-2-3-4-5
 * 1-3-2-4-5
 * 1-4-3-2-5
 * current永远指在2上，然后设置一个temp指在current的下一个3上，pre指在1上
 * 设置顺序从后往前  2-4   然后  3-2（注意2这里不能用current，而是pre.next)-4  然后 1-3-2-4
 *
 * 最后返回假头
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = head;
        ListNode pre = dummy;
        int pointer = 1;
        while (current != null && current.next != null) {
            if (pointer >= m && pointer < n) {
                ListNode temp = current.next;
                current.next = temp.next;
                temp.next = pre.next;
                pre.next = temp;
            } else {
                current = current.next;
                pre = pre.next;
            }
            pointer++;
        }
        return dummy.next;
    }
}
