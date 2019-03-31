/*
 * @lc app=leetcode id=445 lang=java
 *
 * [445] Add Two Numbers II
 *
 * https://leetcode.com/problems/add-two-numbers-ii/description/
 *
 * algorithms
 * Medium (49.49%)
 * Total Accepted:    84.3K
 * Total Submissions: 170.1K
 * Testcase Example:  '[7,2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The most significant digit comes first and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the
 * lists is not allowed.
 * 
 * 
 * 
 * Example:
 * 
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 * 
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } } 思路1： 先把2个list都reverse一下
 * 然后加起来，最后把结果在reverse一下
 * 
 * 思路2： 双stack 把值都存到stack里，然后依次加，因为个位的数在最上面
 * 每次更新当前node的值，然后新建一个prenode指向它，同时把cur指向这个prenode
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode cur = new ListNode(0);
        while (!s1.isEmpty() || !s2.isEmpty() || carry == 1) {
            int sum = 0;
            if (!s1.isEmpty())
                sum += s1.pop();
            if (!s2.isEmpty())
                sum += s2.pop();
            sum += carry;
            cur.val = sum % 10;
            carry = sum / 10;
            ListNode pre = new ListNode(0);
            pre.next = cur;
            cur = pre;
        }
        return cur.next;
    }
}

// l1 = reverse(l1);
// l2 = reverse(l2);
// int carry = 0;
// ListNode dummyhead = new ListNode(0);
// ListNode cur = dummyhead;
// while (l1 != null || l2 != null||carry==1) {
// int sum = (l1 == null) ? 0 : l1.val;
// sum += (l2 == null) ? 0 : l2.val;
// sum += carry;
// cur.next = new ListNode(sum % 10);
// cur = cur.next;
// carry = sum / 10;
// if (l1 != null)
// l1 = l1.next;
// if (l2 != null)
// l2 = l2.next;
// }
// return reverse(dummyhead.next);

// }

// public ListNode reverse(ListNode head) {
// ListNode dummyhead = new ListNode(0);
// dummyhead.next = head;
// while (head.next != null) {
// ListNode temp = head.next;
// head.next = temp.next;
// temp.next = dummyhead.next;
// dummyhead.next = temp;
// }
// return dummyhead.next;
// }
// }
