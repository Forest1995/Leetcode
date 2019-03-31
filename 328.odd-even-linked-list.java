/*
 * @lc app=leetcode id=328 lang=java
 *
 * [328] Odd Even Linked List
 *
 * https://leetcode.com/problems/odd-even-linked-list/description/
 *
 * algorithms
 * Medium (48.39%)
 * Total Accepted:    138.4K
 * Total Submissions: 285.5K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * Given a singly linked list, group all odd nodes together followed by the
 * even nodes. Please note here we are talking about the node number and not
 * the value in the nodes.
 * 
 * You should try to do it in place. The program should run in O(1) space
 * complexity and O(nodes) time complexity.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 * 
 * 
 * Note:
 * 
 * 
 * The relative order inside both the even and odd groups should remain as it
 * was in the input.
 * The first node is considered odd, the second node even and so on ...
 * 
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 * 思路：
 * 将oddlist和evenlist分别生成    每次更新2步即可
 * 然后把evenlist贴在oddlist的后面即可
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode oddList = head;
        ListNode evenList = head.next;
        ListNode dummyhead1 = new ListNode(0);
        dummyhead1.next = oddList;
        ListNode dummyhead2 = new ListNode(0);
        dummyhead2.next = evenList;
        while (evenList != null && evenList.next != null) {// 只check even因为even永远比odd快
            oddList.next = oddList.next.next;
            evenList.next = evenList.next.next;
            oddList = oddList.next;
            evenList = evenList.next;
        }
        oddList.next = dummyhead2.next;
        return dummyhead1.next;

    }
}
