public class SortByParity {
    // Given an integer array nums, move all the even integers at the beginning of
    // the array followed by all the odd integers.//


        public static int[] sortArrayByParity(int[] nums) {
            int i = 0;
            int j = nums.length - 1;
            while(i < j){
                if(nums[i] % 2 == 0)
                    i++;
                if(nums[j] % 2 != 0)
                    j--;
                if(i < j && nums[j] % 2 == 0 && nums[i] % 2 != 0){
                    int k = nums[i];
                    nums[i] = nums[j];
                    nums[j] = k;
                    i++;
                    j--;
                }
            }
            return nums;
        }
        public static void main(String[] args){
            int[] nums = {2,3,5,6};
            int[] result = sortArrayByParity(nums);
            for(int i = 0; i < nums.length; i++){
                System.out.println(result[i]);
            }
        }
    }

