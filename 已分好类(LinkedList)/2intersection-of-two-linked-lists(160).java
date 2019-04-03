public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) return null;
    int lenA = len(headA);
    int lenB = len(headB);
    if (lenA > lenB) {
        while (lenA != lenB) {
            headA = headA.next;
            lenA--;
        }
    } else {
        while (lenA != lenB) {
            headB = headB.next;
            lenB--;
        }
    }
    while (headA != headB) {
        headA = headA.next;
        headB = headB.next;
    }
    return headA;
}

private int len(ListNode head) {
    int len = 1;
    while (head != null) {
        head = head.next;
        len++;
    }
    return len;
}