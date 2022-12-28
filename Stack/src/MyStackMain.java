public class MyStackMain {
    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(1);
        s.push(2);
        System.out.println(s.empty());
        s.pop();
        System.out.println(s.top());
    }
}
