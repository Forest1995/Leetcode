import javax.lang.model.util.ElementScanner6;

/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
 *
 * algorithms
 * Medium (32.38%)
 * Total Accepted:    172K
 * Total Submissions: 531.2K
 * Testcase Example:  '[1,2,3,3,4,4,5]'
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 1->1->1->2->3
 * Output: 2->3
 * 
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 * 
 * 思路：
 * 双指针
 * 首先用一个while loop将重复的元素略过，指向最后一个重复的元素
 * 将这最后一个重复的元素与pre.next比较， 
 * 如果二者相同，则说明 while loop没有起作用，说明没有重复元素，则这个node可以要，将pre更新
 * 如果二者不同，则说明while loop 起到作用，说明有重复元素，
 * 则将pre.next指向当前重复node的下一个node，但不能确定下个node是否重复，所以不更新pre
 * 最后更新current指向下一个node
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head ;
        ListNode pre = dummy;
        ListNode current = head;
        while (current != null) {
            while (current.next != null && current.val == current.next.val) {
                current = current.next;
            }
            if (pre.next == current) {//比较的是node而不是值
                pre=pre.next;
            } else {
                pre.next=current.next;
            }
            current=current.next;
        }
        return dummy.next;
    }
}
