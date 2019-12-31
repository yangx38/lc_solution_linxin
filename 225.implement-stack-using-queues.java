/*
 * @lc app=leetcode id=225 lang=java
 *
 * [225] Implement Stack using Queues
 *
 * https://leetcode.com/problems/implement-stack-using-queues/description/
 *
 * algorithms
 * Easy (40.78%)
 * Likes:    386
 * Dislikes: 465
 * Total Accepted:    142.5K
 * Total Submissions: 349.2K
 * Testcase Example:  '["MyStack","push","push","top","pop","empty"]\n[[],[1],[2],[],[],[]]'
 *
 * Implement the following operations of a stack using queues.
 * 
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * 
 * 
 * Example:
 * 
 * 
 * MyStack stack = new MyStack();
 * 
 * stack.push(1);
 * stack.push(2);  
 * stack.top();   // returns 2
 * stack.pop();   // returns 2
 * stack.empty(); // returns false
 * 
 * Notes:
 * 
 * 
 * You must use only standard operations of a queue -- which means only push to
 * back, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. You may
 * simulate a queue by using a list or deque (double-ended queue), as long as
 * you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top
 * operations will be called on an empty stack).
 * 
 * 
 */
class MyStack {
    Queue<Integer> que;
    /** Initialize your data structure here. */
    public MyStack() {
        que = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        que.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int k = que.size();
        for (int i = 1; i < k; ++i) {
            que.offer(que.poll());
        }
        return que.poll();
    }
    
    /** Get the top element. */
    public int top() {
        int k = que.size();
        int res = 0;
        for (int i = 0; i < k; ++i) {
            res = que.poll();
            que.offer(res);
        }
        return res;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return que.isEmpty();   
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

