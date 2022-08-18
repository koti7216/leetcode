//Design your implementation of the circular queue. The circular queue is a linear data structure in
// which the operations are performed based on FIFO (First In First Out) principle and the last position
// is connected back to the first position to make a circle. It is also called "Ring Buffer".
//One of the benefits of the circular queue is that we can make use of the spaces in front of the queue.
// In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space
// in front of the queue. But using the circular queue, we can use the space to store new values.
public class MyCircularQueue {
 /*       int[] array;
        int start;
        int end;
        int l;
        int h;
        public MyCircularQueue(int k) {
            array = new int[k];
            start = 0;
            end = 0;
            l = k;
            h = 0;
        }

        public boolean enQueue(int value) {
            boolean result = true;
            if(h == 0){
                array[end] = value;
                h = -1;
            }
            else if(end + 1 != start && end < l-1){
                end++;
                array[end] = value;
            }
            else if(end == l-1 && start != 0){
                array[0] = value;
                end = 0;
            }
            else{
                result = false;
            }
            return result;
        }

        public boolean deQueue() {
            boolean result = true;
            if(h != 0 && end == start){
                h = 0;
            }
            else if(h == 0 && end == start){
                return false;
            }
            else if(start != l-1){
                start++;
            }
            else{
                start = 0;
            }
            return result;
        }

        public int Front() {
            if(h == 0)
                return -1;
            return array[start];
        }

        public int Rear() {
            if(h == 0)
                return -1;
            return array[end];
        }

        public boolean isEmpty() {
            if(h == 0)
                return true;
            return false;
        }

        public boolean isFull() {
            if(start == end+1 || (start == 0 && end == l-1))
                return true;
            return false;
        }*/
 int[] array;
    int start;
    int size;
    int l;
    public MyCircularQueue(int k) {
        array = new int[k];
        start = 0;
        l = 0;
        size = k;
    }

    public boolean enQueue(int value) {
        boolean result = true;
        if(start + l <= size - 1){
            array[start+l] = value;
            l++;
        }
        else if(l != size){
            array[start+l-size] = value;
            l++;
        }
        else
            return false;
        return result;
    }

    public boolean deQueue() {
        boolean result = true;
        if(l == 0){
            return false;
        }
        else{
            if(start == size - 1)
                start = 0;
            else
                start++;
            l--;
        }
        return result;
    }

    public int Front() {
        if(l == 0)
            return -1;
        return array[start];
    }

    public int Rear() {
        if(l == 0)
            return -1;
        else if(start + l > size){
            return array[start + l - size - 1];
        }
        else{
            return array[start + l - 1];
        }
    }

    public boolean isEmpty() {
        if(l == 0)
            return true;
        return false;
    }

    public boolean isFull() {
        if(l == size)
            return true;
        return false;
    }
    }
