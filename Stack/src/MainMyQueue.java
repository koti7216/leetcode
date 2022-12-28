public class MainMyQueue {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        System.out.println(q.peek());
        System.out.println(q.empty());
        q.pop();
        System.out.println(q.peek());
    }
}
