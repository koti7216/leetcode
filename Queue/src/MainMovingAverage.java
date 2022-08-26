public class MainMovingAverage {
    public static void main(String[] args) {
        MovingAverage avg = new MovingAverage(2);
        avg.next(2);
        avg.next(4);
        System.out.println(avg.next(6));
    }
}
