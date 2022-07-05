//Given a binary array nums, return the maximum number of consecutive 1's in the array if you can flip at most one 0.
// nums = [1,0,1,1,0]
// m = 1; t = 0; h = 0; max = 0;
// m = 1; t = 1; h = 0; max = 2; (h == 1; m == 0)
//m = 1; t = 1; h = 1; max = 2;
//m = 2; t = 1; h = 1; max = 2;
//m = 2; t = 1; h = 1; max = 4;(h == 2; m == 0)
// return max value

public class findMaxConsecutiveONEs {

        public static int findMaxConsecutiveOnes(int[] nums) {
            int m = 0; // m contains present 1's count
            int t = 0; // t denotes 0 in between 1's sequence
            int max = 0;
            int h = 0; // h contains prevoius 1's count
            if(nums.length == 1){
                max = 1;
            }
            else{
                for(int i = 0; i < nums.length; i++){
                    if(nums[i] == 1)
                        m++;
                    else
                        t = 1;
                    if(i != 0 && nums[i] == 0 && nums[i - 1] == 1 || i == nums.length -1){
                        max = Math.max(h+m+t,max); // h is previous 1's sequence
                        h = m;
                        m = 0;
                    }
                    if(i != nums.length - 1 && nums[i] == 0 && nums[i + 1] == 0){
                        h = 0;
                    }
                }
            }
            return max;
        }
    public static void main( String[] args){
            int[] nums = {1,0,1,1,1,0};
            System.out.print(findMaxConsecutiveOnes(nums));
    }
}
