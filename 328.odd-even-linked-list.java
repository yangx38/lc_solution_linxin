/*
 * @lc app=leetcode id=328 lang=java
 *
 * [328] Odd Even Linked List
 *
 * https://leetcode.com/problems/odd-even-linked-list/description/
 *
 * algorithms
 * Medium (50.40%)
 * Likes:    904
 * Dislikes: 241
 * Total Accepted:    167.4K
 * Total Submissions: 332K
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
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddDummy = new ListNode(-1);
        ListNode oddTail = oddDummy;
        ListNode evenDummy = new ListNode(-1);
        ListNode evenTail = evenDummy;

        boolean odd = true;
        while (head != null) {
            if (odd) {
                oddTail.next = head;
                oddTail = oddTail.next;
            }else {
                evenTail.next = head;
                evenTail = evenTail.next;
            }
            head = head.next;
            odd =  !odd;
        }

        oddTail.next = evenDummy.next;
        evenTail.next = null;
        return oddDummy.next;
    }
}

