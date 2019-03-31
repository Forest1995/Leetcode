/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
 *
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (43.60%)
 * Total Accepted:    291.2K
 * Total Submissions: 667.7K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 * 
 * 思路： 
 * 每次开始swap需要2个指针，
 * 一个current指在需要交换位置的2个listnode之前， 
 * 另一个temp指在第二个listnode上面，
 * 1.然后先把 左边的node指到这两个node后面的node上，
 * 2.再把右边的node指导左边node上
 * 3.最后把current指到右边node上，然后更新current，要跳2个格
 * 
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode temp = current.next.next;
            current.next.next = temp.next;
            temp.next = current.next;
            current.next = temp;
            current = current.next.next;
        }
        return dummy.next;
    }
}
