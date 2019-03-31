/*
 * @lc app=leetcode id=160 lang=java
 *
 * [160] Intersection of Two Linked Lists
 *
 * https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 *
 * algorithms
 * Easy (32.72%)
 * Total Accepted:    284.3K
 * Total Submissions: 865.7K
 * Testcase Example:  '8\n[4,1,8,4,5]\n[5,0,1,8,4,5]\n2\n3'
 *
 * Write a program to find the node at which the intersection of two singly
 * linked lists begins.
 * 
 * For example, the following two linked lists:
 * 
 * 
 * begin to intersect at node c1.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA =
 * 2, skipB = 3
 * Output: Reference of the node with value = 8
 * Input Explanation: The intersected node's value is 8 (note that this must
 * not be 0 if the two lists intersect). From the head of A, it reads as
 * [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2
 * nodes before the intersected node in A; There are 3 nodes before the
 * intersected node in B.
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3,
 * skipB = 1
 * Output: Reference of the node with value = 2
 * Input Explanation: The intersected node's value is 2 (note that this must
 * not be 0 if the two lists intersect). From the head of A, it reads as
 * [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes
 * before the intersected node in A; There are 1 node before the intersected
 * node in B.
 * 
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * 
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB =
 * 2
 * Output: null
 * Input Explanation: From the head of A, it reads as [2,6,4]. From the head of
 * B, it reads as [1,5]. Since the two lists do not intersect, intersectVal
 * must be 0, while skipA and skipB can be arbitrary values.
 * Explanation: The two lists do not intersect, so return null.
 * 
 * 
 * 
 * 
 * Notes:
 * 
 * 
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function
 * returns.
 * You may assume there are no cycles anywhere in the entire linked
 * structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * 
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } } 
 * 思路1: 找到2个list长度
 * 长的先跑长度差，然后和短的一起跑 有相等的话则输出那个node 否则没有相交 （while永远会退出） ，返回1指针即可
 * 
 * 思路2： 用hashset从第一个list的所有点 然后跑第二个list，如果碰到在hashset里的点，则它是第一个相交点 返回其即可
 * 
 * 思路3： 一直跑2个list，当跑到结尾时将指针指回另一个list的起点， 这样如果有相遇的点的话会同时到达，则返回那个点即可 没有相遇的话则输出null
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {// 如果没有相交，他们也会同时到达终点，同时为NULL，所以循环会跳出
            p1 = (p1 == null) ? headB : p1.next;
            p2 = (p2 == null) ? headA : p2.next;
        }
        return p1;
    }
}
// int len1 = 0;
// int len2 = 0;
// ListNode p1 = headA;
// ListNode p2 = headB;
// while (p1 != null) {
// len1++;
// p1 = p1.next;
// }
// while (p2 != null) {
// len2++;
// p2 = p2.next;
// }
// while (len1 > len2) {
// headA = headA.next;
// len1--;
// }
// while (len2 > len1) {
// headB = headB.next;
// len2--;
// }
// while (headA != headB) { // 如果没有相交，他们也会同时到达终点，同时为NULL，所以循环会跳出
// headA = headA.next;
// headB = headB.next;
// }
// return headA;
// }
// }
