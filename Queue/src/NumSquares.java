import java.util.*;
    //Given an integer n, return the least number of perfect square numbers that sum to n.
//A perfect square is an integer that is the square of an integer; in other words,
// it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
    public class NumSquares {
        public static int numSquares(int n) {
            //time complexity is O(n^3/2)
            // time complexity O(n)
            int[] dp = new int[n+1];
            Arrays.fill(dp,100000);
            dp[0] = 0;
            dp[1] = 1;
            for(int i = 2; i <= n; i++){
                for(int j = 1; j <= (int)Math.sqrt(i);j++){
                    dp[i] = Math.min(dp[i],dp[i-j*j]+1);
                }
            }
            return dp[n];
        }
//Given an integer n, return the least number of perfect square numbers that sum to n.

//A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

/*
        public int numSquares(int n) {
         //time complexity is O(n^3/2)
            // time complexity O(n)
            int[] dp = new int[n+1];
            Arrays.fill(dp,100000);
            dp[0] = 0;
            dp[1] = 1;
            int x = 1;
            while(x*x <= n){
                dp[x*x] = 1;
                x++;
            }
            if((x-1)*(x-1) == n)
                return 1;
            for(int i = 2; i <= n; i++){
                for(int j = 1; j <= (int)Math.sqrt(i);j++){
                    if(i == j*j)
                        continue;
                    dp[i] = Math.min(dp[i],dp[i-j*j]+1);
                }
            }
            return dp[n];
        }
    */


//Given an integer n, return the least number of perfect square numbers that sum to n.

//A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

    /*
        public int numSquares(int n) {

            ArrayList<Integer> sqr= new ArrayList<>();
            int x = 1;
            while(x*x <= n){
                sqr.add(x*x);
                x++;}
            Queue<Integer> q = new LinkedList<>();
            q.offer(n);
            x = 0;
            while(q.size() != 0){
                int a = q.size();
                x++;
                for(int i = 0; i < a; i++){
                    int r = q.poll();
                    for(int sqrr : sqr){
                        if(sqrr > r)
                            break;
                        else if(r == sqrr)
                            return x;
                        else{
                            q.offer(r-sqrr);
                        }
                    }
                }
            }
            return x;
        }*/
    public static void main(String[] args) {
        System.out.println(numSquares(226));
    }
    }

