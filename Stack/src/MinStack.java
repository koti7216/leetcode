//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//Implement the MinStack class:
//MinStack() initializes the stack object.
//void push(int val) pushes the element val onto the stack.
//void pop() removes the element on the top of the stack.
//int top() gets the top element of the stack.
//int getMin() retrieves the minimum element in the stack.
//You must implement a solution with O(1) time complexity for each function.

import java.util.*;

public class MinStack {
    Stack<Integer> s = new Stack<Integer>();
    Stack<Integer> s1 = new Stack<Integer>();
    public MinStack() {
        s = new Stack<Integer>();
        s1 = new Stack<Integer>();
    }
    public void push(int val) {
        if(s1.isEmpty())
            s1.push(val);
        else{
            if(val <= s1.peek())
                s1.push(val);
        }
        s.push(val);
    }
    public void pop() {
        int m = s1.peek();
        int n = s.peek();
        if(m == n)
            s1.pop();
        s.pop();
    }
    public int top() {
        return s.peek();
    }
    public int getMin() {
        return s1.peek();
    }
}
