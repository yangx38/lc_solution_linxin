public ListNode reverseKGroup(ListNode head, int k) {
    if(head == null || head.next == null) return head;
    int count = 0;
    ListNode cur = head;
    while(cur != null && count != k) {
        cur = cur.next;
        count++;
    }
    if(count == k) {
        cur = reverseKGroup(cur, k);
        while (count > 0) {
            ListNode next = head.next;
            head.next = cur;
            cur = head;
            head = next;
            count--;
        }
        head = cur;
    }
    return head;
}