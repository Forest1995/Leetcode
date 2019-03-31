/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
 *
 * https://leetcode.com/problems/reorder-list/description/
 *
 * algorithms
 * Medium (30.07%)
 * Total Accepted:    146.5K
 * Total Submissions: 486.4K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * Example 1:
 * 
 * 
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * 
 * Example 2:
 * 
 * 
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 * 
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 * 
 * 思路：
 * 1.先找到list的中点， 注意找准中点的位置
 * 2.然后将后半部分list reverse   
 * 3.最后将2部分融合 
 * 直接融合，判断条件是前半部分的指针   是否与后半部分的前头相等
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null)
            return;
        // find the start of second half
        ListNode fast = head;
        ListNode preSecondHalf = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            preSecondHalf = preSecondHalf.next;
        }

        // reverse second half
        ListNode current = preSecondHalf.next;
        while (current != null && current.next != null) {
            ListNode temp = current.next;
            current.next = temp.next;
            temp.next = preSecondHalf.next;
            preSecondHalf.next = temp;
        }

        // combine two halves

        ListNode firstHalf = head;
        ListNode secondHalf = preSecondHalf.next;

        while (firstHalf != preSecondHalf) {
            preSecondHalf.next = secondHalf.next;
            secondHalf.next= firstHalf.next;
            firstHalf.next=secondHalf;
            firstHalf=firstHalf.next.next;
            secondHalf =preSecondHalf.next;
        }
    }
}
