/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
 *
 * https://leetcode.com/problems/partition-list/description/
 *
 * algorithms
 * Medium (36.55%)
 * Total Accepted:    155.9K
 * Total Submissions: 426.5K
 * Testcase Example:  '[1,4,3,2,5,2]\n3'
 *
 * Given a linked list and a value x, partition it such that all nodes less
 * than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * Example:
 * 
 * 
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 * 
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 * 
 * 思路： 分别设置2个list头和指针 
 * 按照大小将当前node分配到2个list中 
 * 最后将左右2个list连接起来
 * 
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyhead1 = new ListNode(0);
        ListNode dummyhead2 = new ListNode(0);
        ListNode cur1 = dummyhead1;
        ListNode cur2 = dummyhead2;
        ListNode current = head;
        while (current != null) {
            if (current.val < x) {
                cur1.next = current;
                cur1 = cur1.next;
            } else {
                cur2.next = current;
                cur2 = cur2.next;
            }
            current = current.next;
        }
        cur2.next = null;
        cur1.next = dummyhead2.next;
        return dummyhead1.next;
    }
}
