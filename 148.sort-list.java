/*
 * @lc app=leetcode id=148 lang=java
 *
 * [148] Sort List
 *
 * https://leetcode.com/problems/sort-list/description/
 *
 * algorithms
 * Medium (34.27%)
 * Total Accepted:    174.7K
 * Total Submissions: 508.5K
 * Testcase Example:  '[4,2,1,3]'
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * Example 1:
 * 
 * 
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 * 
 * 思路
 * 
 * 
 * merge sort
 * 先找到list的中点，然后断开，分成2部分
 * 然后用recursion自己将左边和右边sort，
 * 最后将2个sorted list 合并起来（同21题merge two sorted list）
 * 
 */
class Solution {
    public ListNode sortList(ListNode head) {
        // find middle
        if (head == null||head.next==null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //断开，分成2截
        fast = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(fast);
        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode dummyhead = new ListNode(0);
        ListNode current = dummyhead;
        while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }
        current.next = (left == null) ? right : left;
        return dummyhead.next;
    }
}
