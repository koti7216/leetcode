import java.util.*;
public class MyStack {

    // time complexity is O(n) for pop and top and O(1) for remaining and space complexity is O(n)
    Queue<Integer> q = new LinkedList<>();
    Queue<Integer> q1 = new LinkedList<>();

    public MyStack() {

    }

    public void push(int x) {
        if (!q1.isEmpty())
            q.offer(q1.poll());
        q1.offer(x);
    }

    public int pop() {
        if (q1.isEmpty()) {
            while (q.size() > 1) {
                q1.offer(q.poll());
            }
            int a = q.poll();
            while (!q1.isEmpty()) {
                q.offer(q1.poll());
            }
            q1.offer(a);

        }

        return q1.poll();
    }

    public int top() {
        if (q1.isEmpty()) {
            while (q.size() != 1) {
                q1.offer(q.poll());
            }
            int a = q.poll();
            while (!q1.isEmpty()) {
                q.offer(q1.poll());
            }
            q1.offer(a);
        }
        return q1.peek();
    }

    public boolean empty() {
        if (q.isEmpty() && q1.isEmpty())
            return true;
        return false;
    }

/*
    Queue<Integer> q = new LinkedList<>();
    Queue<Integer> q1 = new LinkedList<>();
    int b;
// time complexity is O(n) for pop and for remaining O(1) and space complexity is O(1)
    public MyStack() {

    }

    public void push(int x) {
        q.offer(x);
        b = x;
    }

    public int pop() {
        while (q.size() > 1) {
            b = q.peek();
            q1.offer(q.poll());
        }
        int a = q.poll();
        while (!q1.isEmpty()) {
            q.offer(q1.poll());
        }
        q1.offer(a);
        return q1.poll();
    }

    public int top() {
        return b;
    }

    public boolean empty() {
        if (q.isEmpty())
            return true;
        return false;
    }

*/
    /*
    Queue<Integer> q = new LinkedList<>();
// time complexity is O(n) for push and remaining operations O(1) and space complexity is O(n)
    public MyStack() {

    }

    public void push(int x) {
        q.offer(x);
        int a = q.size();
        while (a > 1) {
            q.offer(q.poll());
            a--;
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        if (q.isEmpty())
            return true;
        return false;
    }*/
}