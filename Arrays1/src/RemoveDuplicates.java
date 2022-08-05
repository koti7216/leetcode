//Given non-decreasing Array, remove the duplicates(you can leave the elements at the end of given array)
public class RemoveDuplicates {
        public static int removeDuplicates(int[] nums) { // time complexity O(n) and O(1) space complexity
            int t = 1;
            for(int i = 1; i < nums.length; i++){
                if(nums[i] != nums[i - 1]){
                    nums[t] = nums[i];
                    t++;
                }
            }
            return t;
        }
        public static void main(String[] args){
            int[] nums = {1,1,2,3,4,4,5,5,5,6,6};
            int t = removeDuplicates(nums);
            for(int i = 0; i < t; i++){
                System.out.print(nums[i]);
            }
        }
    }
