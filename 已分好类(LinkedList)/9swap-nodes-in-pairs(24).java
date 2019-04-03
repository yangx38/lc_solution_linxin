public ListNode swapPairs(ListNode head) {
    if(head == null || head.next == null) return head;
    ListNode dummy = new ListNode(0); dummy.next = head;
    ListNode slow = dummy, fast = head;
    
    while(fast != null && fast.next != null ) {
        slow.next = fast.next; slow = slow.next;
        fast.next = fast.next.next; slow.next = fast;
        fast = fast.next; slow = slow.next;

    }
    return dummy.next;
}