//Due to the rise of covid-19 cases in India, this year BCCI decided to organize knock-out matches in IPL rather than a league.
//
//Today is matchday 2 and it is between the most loved team Chennai Super Kings and the most underrated team - Punjab Kings.
// Stephen Fleming, the head coach of CSK, analyzing the batting stats of Punjab.
// He has stats of runs scored by all N players in the previous season and he wants to find the maximum score
// for each and every contiguous sub-list of size K to strategize for the game.
import java.util.*;
public class IPL2021MatchDay2 {

        static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
            // Your code here
            Queue<Integer> q = new LinkedList<>();
            ArrayList<Integer> a = new ArrayList<>();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < k; i++){
                max = Math.max(max,arr[i]);
                q.offer(arr[i]);
            }
            a.add(max);
            for(int i = k; i < n; i++){
                if(q.peek() ==  max){
                    max = Integer.MIN_VALUE;
                    for(int j = i-k+1; j < i; j++){
                        max = Math.max(max,arr[j]);
                    }
                }
                max = Math.max(max,arr[i]);
                q.poll();
                q.offer(arr[i]);
                a.add(max);
            }
            return a;
        }

}
