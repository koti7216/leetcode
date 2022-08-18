public class Main {
    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(5);
        System.out.println("queue is empty" + queue.isEmpty());
        queue.enQueue(1);
        queue.enQueue(2);
        queue.deQueue();
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        System.out.println(queue.Front());
        System.out.println(queue.Rear());

    }
}
