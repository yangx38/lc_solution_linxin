public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) return true;
    ListNode middle = findMiddle(head);
    middle.next = reverse(middle.next);
    
    ListNode cur1 = head;
    ListNode cur2 = middle.next;
    while (cur2 != null) {
        if (cur1.val != cur2.val) return false;
        cur1 = cur1.next;
        cur2 = cur2.next;
    }
    return true;
}

private ListNode findMiddle(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode slow = head, fast = head;
    while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}

public ListNode reverse(ListNode head) {
    ListNode temp = null;
    while (head != null) {
        ListNode next = head.next;
        head.next = temp;
        temp = head;
        head = next;
    }
    return temp;
}