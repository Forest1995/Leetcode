/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
 *
 * https://leetcode.com/problems/rotate-list/description/
 *
 * algorithms
 * Medium (26.68%)
 * Total Accepted:    181.9K
 * Total Submissions: 681.5K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given a linked list, rotate the list to the right by k places, where k is
 * non-negative.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 * 
 * 思路： 
 * 关键是找到旋转后list的头部，所以还是双指针一快一慢， 
 * 找到头部后将尾部与之前的头部连接起来， 并把之前头部断开 最后返回新的头部即可
 * 
 * 注意：
 * 1.len小于等于1可直接返回head
 * 2.k==0时也可直接返回head
 * 
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        int len = 0;
        while (fast != null) {
            fast = fast.next;
            len++;
        }
        if (len <= 1)
            return head;
        k = k % len;
        if (k == 0)
            return head;
        fast = head;
        while (fast.next != null) {
            fast = fast.next;
            k--;
            if (k < 0)
                slow = slow.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }
}
