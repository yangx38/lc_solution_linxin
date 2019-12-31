/*
 * @lc app=leetcode id=460 lang=java
 *
 * [460] LFU Cache
 *
 * https://leetcode.com/problems/lfu-cache/description/
 *
 * algorithms
 * Hard (30.05%)
 * Likes:    822
 * Dislikes: 90
 * Total Accepted:    47.2K
 * Total Submissions: 157.1K
 * Testcase Example:  '["LFUCache","put","put","get","put","get","get","put","get","get","get"]\n' +
  '[[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]'
 *
 * Design and implement a data structure for Least Frequently Used (LFU) cache.
 * It should support the following operations: get and put.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reaches its capacity, it should invalidate the least
 * frequently used item before inserting a new item. For the purpose of this
 * problem, when there is a tie (i.e., two or more keys that have the same
 * frequency), the least recently used key would be evicted.
 * 
 * Note that the number of times an item is used is the number of calls to the
 * get and put functions for that item since it was inserted. This number is
 * set to zero when the item is removed.
 * 
 * 
 * 
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * 
 * 
 * 
 * Example:
 * 
 * 
 * LFUCache cache = new LFUCache( 2 /* capacity  );
 * 
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.get(3);       // returns 3.
 * cache.put(4, 4);    // evicts key 1.
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 * 
 * 
 * 
 * 
 */
class LFUCache {
    Map<Integer, Node> locationMap;
    Map<Integer, Node[]> freqMap;
    int minFreq;
    int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        minFreq = 0;
        freqMap = new HashMap<>();
        locationMap = new HashMap<>();    
    }

    private void update(Node cur) {
        cur.next.prev = cur.prev;
        cur.prev.next = cur.next;

        Node head = freqMap.get(cur.freq)[0];
        if (cur.freq == minFreq && head.next.next == null) {
            minFreq++;
        }

        cur.freq++;
        if (!freqMap.containsKey(cur.freq)) {
            createFreqList(cur.freq);
        }

        Node[] pair = freqMap.get(cur.freq);
        moveToTail(cur, pair[1]);
    }

    private void createFreqList(int freq) {
        Node head = new Node(-1, -1, freq);
        Node tail = new Node(-1, -1, freq);
        head.next = tail;
        tail.prev = head;
        freqMap.put(freq, new Node[]{head, tail});
    }

    private void moveToTail(Node x, Node tail) {
        tail.prev.next = x;
        x.prev = tail.prev;
        x.next = tail;
        tail.prev = x;
    }
    
    public int get(int key) {
        if (!locationMap.containsKey(key)) {
            return -1;
        }

        Node cur = locationMap.get(key);
        update(cur);
        return cur.val;
    }
    
    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }

        if (locationMap.containsKey(key)) {
            Node cur = locationMap.get(key);
            cur.val = value;
            update(cur);
            return;
        }

        Node cur = new Node(key, value, 1);
        if (locationMap.size() == capacity) {
            Node[] pair = freqMap.get(minFreq);
            Node head = pair[0];
            Node removeNode = head.next;
            //deleteNode
            head.next = removeNode.next;
            removeNode.next.prev = head;
            locationMap.remove(removeNode.key);
        }

        if (!freqMap.containsKey(1)) {
            createFreqList(1);
        }
        moveToTail(cur, freqMap.get(1)[1]);
        minFreq = 1;
        locationMap.put(key, cur);
    }
}
class Node{
    int key, val, freq;
    Node prev, next;
    Node(int key, int val, int freq) {
        this.key = key;
        this.val = val;
        this.freq = freq;
        this.prev = this.next = null;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

