public Node connect(Node root) {
    if(root == null) return null;
    
    Node head = root;
    while (head != null) {
        head = linkNextLevel(head);
    }
    return root;
}

private Node linkNextLevel(Node preHead){
    Node curHead = new Node(0);
    Node cur = curHead;
    
    while(preHead != null){
        if(preHead.left == null && preHead.right == null) preHead = preHead.next;
        else break;
    }
    
    while(preHead != null){
        if(preHead.left != null){
            cur.next = preHead.left;
            cur = cur.next;
        }
        if(preHead.right != null){
            cur.next = preHead.right;
            cur = cur.next;
        }
        preHead = preHead.next;
    }
    return curHead.next;
}