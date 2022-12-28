//You are given an integer array nums and an integer target.
//You want to build an expression out of nums by adding one of the symbols '+' and '-'
// before each integer in nums and then concatenate all the integers.
//For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and
// concatenate them to build the expression "+2-1".
//Return the number of different expressions that you can build, which evaluates to target.
import java.util.*;
public class FindTargetSumWays {

    static int total;
    public static int findTargetSumWays(int[] nums, int target) {
        // time complexity is O(nums.length*sum of values)
        // space complexity is O(nums.length*sum of values)
        total =  Arrays.stream(nums).sum();
        int[][] memo = new int[nums.length][2 * total + 1];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        if(Math.abs(target) > total || (total - target)%2 != 0)
            return 0;
        int s = (total - target)/2;
        return find(nums,0,0,s,memo);
    }
    public static int find(int[] nums, int i, int sum, int target,int[][] memo){
        if(i == nums.length){
            if(sum == target)
                return 1;
            else
                return 0;}
        if(memo[i][sum+total] != Integer.MIN_VALUE)
            return memo[i][sum+total];
        int a = find(nums,i+1,sum+nums[i],target,memo);
        int b = find(nums,i+1,sum,target,memo);
        memo[i][sum+total] = a + b;
        return memo[i][sum+total];
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        System.out.println(findTargetSumWays(nums,3));
    }
/*    public int findTargetSumWays(int[] nums, int target) {
// time complexity is O(nums.length*sum of values)
// space complexity is O(nums.length*sum of values)
        int total =  Arrays.stream(nums).sum();
        int[][] dp = new int[nums.length][total + 1];
        dp[0][nums[0]] = 1;
        dp[0][0] += 1;
        if(Math.abs(target) > total || (total - target)%2 != 0)
            return 0;
        int s = (total - target)/2;
        for(int i = 1; i < nums.length; i++){
            for(int sum = 0; sum <= total; sum++){
                if(dp[i - 1][sum] > 0) {
                    dp[i][sum + nums[i]] += dp[i - 1][sum];
                    dp[i][sum] += dp[i - 1][sum];
                }
            }
        }
        return dp[nums.length-1][s];
    }*/
}
