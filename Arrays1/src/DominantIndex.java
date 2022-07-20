//You are given an integer array nums where the largest integer is unique.
//Determine whether the largest element in the array is at least twice as much as every other number in the array.
// If it is, return the index of the largest element, or return -1 otherwise.

import java.util.*;
class DominantIndex {
    /*public static int dominantIndex(int[] nums) { // time complexity O(nlogn) for sorting and space complexity is O(1)
        int t = 0, max = 0;
        for(int i = 0; i < nums.length; i++){
            if(max < nums[i])
            {
                max = nums[i];
                t = i;   // index of max value
            }
        }
        Arrays.sort(nums);
        int n = nums.length;
        int l = nums[n - 1];
        if(n == 1){
            return 0;
        }
        if(nums[n - 2] <= nums[n - 1]/2 && n > 1){
            return t;
        }
        else
        {
            return -1;
        }
    }*/
    /*public static int dominantIndex(int[] nums){ // time complexity O(n) space complexity O(1)
        int max = 0;
        int t = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++){ // for finding max value
            if(nums[i] > max){
                max = nums[i];
                t = i;
            }
        }
        for(int i = 0; i < nums.length; i++){ // checking all values and keeping the count
            if(max >= 2*nums[i])
                count++;
        }
        if(count == nums.length-1) // max value is greater than nums.length -1 values
            return t;
        return -1;
    }*/
    public static int dominantIndex(int[] nums){ // time complexity O(n) space complexity O(1)
        int[] temp = new int[2];
        temp[0] = nums[0];
        temp[1] = 0;
        int t = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > temp[0]){
                temp[1] = temp[0];
                temp[0] = nums[i];
                t = i;
            }
            else{
                temp[1] = Math.max(temp[1],nums[i]);
            }
        }
        if(temp[0]>=2*temp[1])
            return t;
        return -1;
    }
    public static void main(String[] args){
        int[] nums = {1,2,3,2,3,6};
        System.out.print(dominantIndex(nums)); // here max value is 6, since 6 is greater than or equals to twice of
        //remaining values. it returns index of 6.
    }
}
