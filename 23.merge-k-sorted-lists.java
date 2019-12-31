/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (36.06%)
 * Likes:    2933
 * Dislikes: 195
 * Total Accepted:    452K
 * Total Submissions: 1.3M
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return mergeSort(lists, 0, lists.length - 1);
    }
    private ListNode mergeSort(ListNode[] lists, int start, int end) {
        if (start >= end) {
            return lists[start];
        }
        int mid = start + end >> 1;
        ListNode l1 = mergeSort(lists, start, mid);
        ListNode l2 = mergeSort(lists, mid + 1, end);
        return mergeTwoSortedLinkedList(l1, l2);
    }

    private ListNode mergeTwoSortedLinkedList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            }else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        if (l1 != null) {
            tail.next = l1;
        }else if (l2 != null) {
            tail.next = l2;
        }
        return dummy.next;
    }
}

