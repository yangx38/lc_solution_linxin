public Node connect(Node root) {
    Node start = root;
    while (start != null) {
        Node cur = start;
        while (cur != null) {
            if (cur.left != null) {
                cur.left.next = cur.right;
            }
            if (cur.right != null && cur.next != null) {
                cur.right.next = cur.next.left;
            }
            cur = cur.next;
        }
        start = start.left;
    }
    return root;
}