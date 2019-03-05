/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
 *
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (45.64%)
 * Total Accepted:    504.6K
 * Total Submissions: 1.1M
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * Example:
 * 
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * 
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 * 
 * 思路
 * 和普通的merge array一样，先比较值的大小
 * 然后将小的list贴在后面
 * 如果有一个list走到尽头，将另一个List贴在后面即可
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // ListNode prehead=new ListNode(0);
        // ListNode current=prehead;
        // while(l1!=null&&l2!=null){
        // if(l1.val<l2.val){
        // current.next=l1;
        // l1=l1.next;
        // }
        // else{
        // current.next=l2;
        // l2=l2.next;
        // }
        // current=current.next;
        // }
        // current.next=(l1==null)?l2:l1;
        // return prehead.next;
        // }

        // method 2
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
