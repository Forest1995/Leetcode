/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
 *
 * https://leetcode.com/problems/reverse-linked-list/description/
 *
 * algorithms
 * Easy (53.28%)
 * Total Accepted:    536.9K
 * Total Submissions: 1M
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * Reverse a singly linked list.
 * 
 * Example:
 * 
 * 
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * 
 * 
 * Follow up:
 * 
 * A linked list can be reversed either iteratively or recursively. Could you
 * implement both?
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 * 
 * 一个指针指在head前， 一个指在head上 head不用更新， 另一个指在head.next上，把这个插到最头上 最前面 不断循环即可
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
        ListNode temp = head.next;
        while (head.next != null) {
            head.next = temp.next;
            temp.next = dummyhead.next;
            dummyhead.next = temp;
            temp = head.next;
        }
        return dummyhead.next;
    }
}
