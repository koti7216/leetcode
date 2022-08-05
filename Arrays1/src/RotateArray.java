// Given an array, rotate the array to the right by k steps, where k is non-negative.
public class RotateArray {

        public static void rotate(int[] nums, int k) { // time complexity O(n) and space complexity O(n)
            while(k > nums.length){
                k = k - nums.length;   // for making k within nums length range
            }
            int[] temp = new int[nums.length];
            for(int i = 0; i < nums.length; i++){
                int j = index(nums,i,k);
                temp[j] = nums[i];
            }
            for(int m = 0; m < nums.length; m++){
                nums[m] = temp[m];
            }


        }
        public static int index(int[] nums, int i, int k){
            int m = 0;
            if(i + k <= nums.length - 1)
                m = i + k;
            if(i + k > nums.length - 1)
                m = i + k - nums.length;
            return m;
        }



        public static void main(String[] args){
            int[] nums = {1,2,3,4,5,6,7};
            int k = 3;
            rotate(nums,k);
            for(int i = 0; i < nums.length; i++){
                System.out.print(nums[i]);
            }
        }
    }


