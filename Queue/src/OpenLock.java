//You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.

//The lock initially starts at '0000', a string representing the state of the 4 wheels.

//You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.

//Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.
import java.util.*;
public class OpenLock {
    public static int openLock(String[] deadends, String target) {
        // time complexity is  O(N^2 * A^N + D) n is lock dail(4) a is number of digits and d is deadends;
        // space complexity is  O( A^N + D)
        List<Integer> directions = Arrays.asList(1000,100,10,1,-1000,-100,-10,-1);
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer,Integer> t = new HashMap<>();
        for(int i = 0; i < deadends.length; i++){
            t.put(Integer.parseInt(deadends[i]),Integer.parseInt(deadends[i]));
        }
        if(t.containsKey(0))
            return -1;
        q.add(0);
        t.put(0,0);
        int x = 0;
        while(q.size() != 0){
            int a = q.size();
            for(int i = 0; i < a; i++){
                int b = q.poll();
                if(b == Integer.parseInt(target))
                    return x;
                for(int direction : directions){
                    int c = sum(b,direction);
                    if(t.containsKey(c) == true)
                        continue;
                    q.offer(c);
                    t.put(c,c);
                }
            }
            x++;
        }
        return -1;
    }
    public static int sum(int a, int b){
        if(b > 0){
            int c = a%(b*10);
            if(c/b == 9){
                return a - b*9;
            }
        }
        if(b < 0){
            int c = a%(b*10);
            if(c/b == 0){
                return a - b*9;
            }
        }

        return a + b;
    }

    public static void main(String[] args) {
         String[] deadends = {"0201","0101","0102","1212","2002"};
         String target = "0202";
        System.out.println(openLock(deadends, target)); // number of steps to open lock
    }
}
