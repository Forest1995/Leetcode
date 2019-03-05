/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 *
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (30.51%)
 * Total Accepted:    768.4K
 * Total Submissions: 2.5M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example:
 * 
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * 
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
/*
思路
从头开始将两个List的值相加，并存入一个新的list里
加得时候注意
carry=sum/10;
val=sum%10;
新建一个list:current.next= new ListNode(x)
*/
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode prehead = new ListNode(0);
        ListNode current = prehead;
        while (l1 != null || l2 != null || carry == 1) {
            int sum = (l1 == null) ? 0 : l1.val;
            sum += (l2 == null) ? 0 : l2.val;
            sum += carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
            current=current.next;
        }
        return prehead.next;
    }
}
