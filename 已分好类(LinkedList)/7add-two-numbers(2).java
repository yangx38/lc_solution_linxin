public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode p1 = l1, p2 = l2;
    ListNode dummy = new ListNode(0), res = dummy;
    int carry = 0;
    while(p1!= null || p2 != null) {
        if(p1!= null) {carry += p1.val; p1 = p1.next;}
        if(p2!= null) {carry += p2.val; p2 = p2.next;}
        res.next = new ListNode(carry%10); res = res.next;
        carry /=10;
    }
    if(carry ==1) res.next = new ListNode(1);
    return dummy.next;
}