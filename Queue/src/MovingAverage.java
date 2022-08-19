//Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
//Implement the MovingAverage class:
    //MovingAverage(int size) Initializes the object with the size of the window size.
//double next(int val) Returns the moving average of the last size values of the stream
import java.util.*;
    public class MovingAverage {
        int length;
        int size;
        int sum;
        Queue<Integer> q = new LinkedList();
        public MovingAverage(int size) {
            length = 0;
            sum = 0;
            this.size = size;
        }
        public double next(int val) {
            if(length == size){
                sum = sum - q.peek() + val;
                q.poll();
                q.add(val);
            }
            else{
                q.offer(val);
                sum += val;
                length++;
            }
            return (double)sum/length;
        }
}
