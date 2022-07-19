//Given an array of integers nums, calculate the pivot index of this array.
//The pivot index is the index where the sum of all the numbers strictly to the left of the index
// is equal to the sum of all the numbers strictly to the index's right.
//If the index is on the left edge of the array, then the left sum is 0 because
// there are no elements to the left. This also applies to the right edge of the array.
//Return the leftmost pivot index. If no such index exists, return -1.
import java.util.*;
public class PivotIndex {
   /* public static int pivotIndex(int[] nums) { // time complexity O(n^2) Space complexity O(n)
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i <= nums.length - 1; i++){
            if(sum(nums, 0, i - 1) == sum(nums, i + 1, nums.length - 1)){
                result.add(i);
            }
        }
        if(result.size() == 0)
            return -1;
        else{
            return result.get(0);
        }
    }

    public static int sum(int[] nums, int i, int j){
        int l = 0;
        if(i == 0 && j == -1){
            return 0;
        }
        if(i == nums.length && j == nums.length - 1){
            return 0;
        }
        for (int k = i; k <= j; k++) {
            l = l + nums[k];
        }
        return l;
    }*/
   public static int pivotIndex(int[] nums){  // time complexity O(n) and space complexity O(1)
       int sum = 0;
       int leftsum = 0;
       for(int i = 0; i < nums.length; i++){
           sum = sum + nums[i];
       }
       for(int i = 0; i < nums.length; i++){
           if(sum - nums[i] == leftsum){
               return i;
           }
           sum = sum - nums[i];
           leftsum += nums[i];
       }
       return -1;
   }
    public static void main(String[] args){
        int[] nums = {6,5,4,3,7,1};    // here  6 + 5 = 11 and 3 + 7 + 1 = 11, therefore index is 2
        System.out.print(pivotIndex(nums));
    }
}
