//Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should
// support all the functions of a normal queue (push, peek, pop, and empty).
import java.util.*;
public class MyQueue {
    Stack<Integer> s = new Stack<>();
    Stack<Integer> s1 = new Stack<>();
    public MyQueue() {
    }
    public void push(int x) {
        s.push(x);
    }

    public int pop() {
        if(s1.empty()){
            while(!s.empty()){
                s1.push(s.pop());
            }}
        return s1.pop();
    }
    public int peek() {
        if(!s1.empty())
            return s1.peek();
        else{
            while(!s.empty()){
                s1.push(s.pop());
            }
        }
        return s1.peek();
    }

    public boolean empty() {
        if(s1.empty() && s.empty())
            return true;
        return false;
    }
}

