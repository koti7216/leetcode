//Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2), ...,
// (an, bn) such that the sum of min(ai, bi) for all i is maximized. Return the maximized sum.
 //idea : by grouping the consecutive elements in the sorted array eg : {1,3,2,4} (1,2) and (3,4)
// now sum is 1+3 = 4 maximized

import java.util.Arrays;
public class ArrayPairSum {
        public static int arrayPairSum(int[] nums) { // time complexity O(NlogN) and space complexity is O(1)
            Arrays.sort(nums);
            int sum = 0;
            for(int i = 0; i < nums.length; i+=2){
                sum = sum + nums[i];
            }
            return sum;
        }
        public static void main(String[] args){
            int[] nums = {5,3,6,2,7,1,4,8};
            System.out.print(arrayPairSum(nums));
        }
    }


