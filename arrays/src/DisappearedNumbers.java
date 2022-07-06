import java.util.List;
import java.util.ArrayList;
//Given an array nums of n integers where nums[i] is in the range [1, n],
// return an array of all the integers in the range [1, n] that do not appear in nums.
public class DisappearedNumbers {

        /*public static List<Integer> findDisappearedNumbers(int[] nums) {  // time complexity O(n^2)
            // space complexity O(1) if considering returned list does not count as additional space
            ArrayList<Integer> result  = new ArrayList<>();
            for(int i = 0; i < nums.length; i++){
                result.add(nums[i]);
            }
            for(int i = 0; i < nums.length; i++){
                if(result.indexOf(i+1) == -1) // here indexOf is O(n) operation
                    result.add(i+1);
            }
            for(int i = 0; i < nums.length; i++){
                result.remove(0);
            }

            return result;
        }
*/


    /*   public static List<Integer> findDisappearedNumbers(int[] nums) { // time complexity O(n^2)
            // space complexity O(n) if considering returned list does not count as additional space
            ArrayList<Integer> result  = new ArrayList<>();
            ArrayList<Integer> result1  = new ArrayList<>();
            for(int i = 0; i < nums.length; i++){
                result.add(nums[i]);
            }
            for(int i = 0; i < nums.length; i++){
                if(result.indexOf(i+1) == -1)
                    result1.add(i+1);
            }
            return result1;
        }

*/


        public static List<Integer> findDisappearedNumbers(int[] nums) {// time complexity O(n)
            // space complexity O(1) if considering returned list does not count as additional space
            // here we mark the index value by multiplying with -1, use this to find unmarked index.
            ArrayList<Integer> result  = new ArrayList<>();
            for(int i = 0; i < nums.length; i++){
                if(nums[abs(nums[i]) - 1] > 0)
                    nums[abs(nums[i]) - 1] = nums[abs(nums[i]) - 1] * -1;
            }
            for(int i = 0; i < nums.length; i++){
                if(nums[i] > 0)
                    result.add(i+1);
            }
            return result;
        }
        public static int abs(int i){ // we can use Math.abs also.
            int x;
            if(i >= 0)
                x = i;
            else
                x = -i;
            return x;
        }

    public static void main(String[] args){
        int[] nums = {1,2,2,3,4,5,5};
        System.out.print(findDisappearedNumbers(nums));
    }
}
