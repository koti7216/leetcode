public class MaxConsecutiveOnes {
    //Given a binary array nums, return the maximum number of consecutive 1's in the array
        public static int findMaxConsecutiveOnes(int[] nums) { // time complexity O(n) and space complexity O(1)
            int t = 0;
            int k = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == 1){
                    t++;
                }
                else t = 0;
                k = Math.max(t,k);
            }
            return k;
        }
        public static void main(String[] args){
            int[] nums = {1,0,1,1,1,0};
            System.out.print(findMaxConsecutiveOnes(nums));
        }
    }
