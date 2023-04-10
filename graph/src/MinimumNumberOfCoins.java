import java.util.*;
//Given an infinite supply of each denomination of Indian currency { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 }
// and a target value N.
//Find the minimum number of coins and/or notes needed to make the change for Rs N.
// You must return the list containing the value of coins required.
public class MinimumNumberOfCoins {


        static List<Integer> minPartition(int N)
        {
            // code here
            int[] dp = new int[N+1];
            HashSet<Integer> s = new HashSet<>();
            s.add(1);
            s.add(2);
            s.add(5);
            s.add(10);
            s.add(20);
            s.add(50);
            s.add(100);
            s.add(200);
            s.add(500);
            s.add(2000);
            int[] f = {1,2,5,10,20,50,100,200,500,2000};
            List<Integer> l = new ArrayList<>();
            if(s.contains(N)){
                l.add(N);
                return l;
            }
            for(int i = 1; i <= N-1; i++){
                if(s.contains(i))
                    dp[i] = 1;
                else{
                    int c = 2001;
                    for(int j = 0; j < f.length && f[j] < i; j++){
                        c = Math.min(c,dp[i-f[j]]);
                    }
                    dp[i] = c+1;
                }
            }
            int a = N;
            Stack<Integer> q = new Stack<>();
            while(!s.contains(a)){
                int c = 2001;
                int t = 0;
                for(int j = 0; j < f.length && f[j] < N; j++){
                    if(c > dp[a-f[j]]){
                        c = dp[a-f[j]];
                        t = j;
                    }
                }
                q.push(f[t]);
                a = a-f[t];
            }
            q.push(a);
            int r = q.size();
            for(int i = 1; i <= r; i++){
                l.add(q.pop());
            }
            return l;}

}
