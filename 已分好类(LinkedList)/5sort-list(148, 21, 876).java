// 876. Middle of the Linked List
    // 停在最后一位或者null位
    while(fast != null && fast.next != null)
    // 停在倒数第二位或者最后一位
    while(fast.next != null && fast.next.next != null)

// 21. Merge Two Sorted Lists
    // iterative: 
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                cur.next = new ListNode(l2.val);
                l2= l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) cur.next = l1;
        else cur.next = l2;
        return dummy.next;
    }

    // recursive: 
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // base case: 
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        // divide: 
        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

// 148. Sort List
public ListNode sortList(ListNode head) {
    if(head == null || head.next == null) return head;
    ListNode middle = middleNode(head);
    ListNode next = middle.next;
    middle.next = null;
    return mergeTwoLists(sortList(head), sortList(next));
}