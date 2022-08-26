public class MainMinStack {
    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(3);
        s.push(4);
        s.push(1);
        s.push(7);
        System.out.println(s.getMin());
        s.pop();
        s.pop();
        System.out.println(s.getMin());
    }
}
