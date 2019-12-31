/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 *
 * https://leetcode.com/problems/lru-cache/description/
 *
 * algorithms
 * Medium (27.29%)
 * Likes:    3574
 * Dislikes: 144
 * Total Accepted:    350.1K
 * Total Submissions: 1.3M
 * Testcase Example:  '["LRUCache","put","put","get","put","get","put","get","get","get"]\n' +
  '[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently
 * used item before inserting a new item.
 * 
 * The cache is initialized with a positive capacity.
 * 
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * 
 * Example:
 * 
 * 
 * LRUCache cache = new LRUCache( 2 /* capacity  );
 * 
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 * 
 * 
 * 
 * 
 */
class LRUCache {
    Node head;
    Node tail;
    int k;
    Map<Integer, Node> map;
    public LRUCache(int capacity) {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        k = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node cur = map.get(key);
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        moveToTail(cur);
        return cur.val;
    }
    
    public void put(int key, int value) {
        if (k <= 0) return;
        if (get(key) != -1) {
            map.get(key).val = value;
            return;
        }

        if (map.size() == k) {
            Node removeNode = head.next;
            head.next = removeNode.next;
            removeNode.next.prev = head;
            map.remove(removeNode.key);
        }

        Node cur = new Node(key, value);
        moveToTail(cur);
        map.put(key, cur);
    }

    private void moveToTail(Node x) {
        x.prev = tail.prev;
        tail.prev.next = x;
        x.next = tail;
        tail.prev = x;
    }
}
class Node{
    int key, val;
    Node prev, next;
    Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = this.next = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

