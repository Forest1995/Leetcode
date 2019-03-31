/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
 *
 * https://leetcode.com/problems/palindrome-linked-list/description/
 *
 * algorithms
 * Easy (35.49%)
 * Total Accepted:    241.1K
 * Total Submissions: 678.2K
 * Testcase Example:  '[1,2]'
 *
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->2
 * Output: false
 * 
 * Example 2:
 * 
 * 
 * Input: 1->2->2->1
 * Output: true
 * 
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } } 
 * 思路 找到中点，然后reverse后半个list 
 * 然后双指针，一头
 * 一中间，比较2个值是否相等 
 * 一旦不等返回false，while loop 结束条件是一方已走到头
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // reverse second half
        ListNode cur = slow.next;
        ListNode temp = cur.next;
        while (cur.next != null) {
            cur.next = temp.next;
            temp.next = slow.next;
            slow.next = temp;
            temp = cur.next;
        }

        ListNode p1 = head;
        ListNode p2 = slow.next;
        while (p1 != null && p2 != null) {
            if (p1.val != p2.val)
                return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }
}
