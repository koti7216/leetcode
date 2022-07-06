
    //Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.
// a is for first max value
// b is for second max value
// c is for third max value


    public class thirdMaxNumber {
        public static int thirdMax(int[] nums) { // time complexity O(n) space complexity O(1)
            Integer a = Integer.MIN_VALUE; // for finding first max value
            Integer b = Integer.MIN_VALUE; // for finding second max value
            Integer c = Integer.MIN_VALUE; // for finding third max value
            int s = 0;
            int result;
            if(nums.length == 1)
                result = nums[0];
            else if(nums.length == 2)
                result = Math.max(nums[0],nums[1]);
            else{
                for(int i = 0; i<nums.length; i++){
                    a = Math.max(a,nums[i]);
                }
                for(int i = 0; i<nums.length; i++){
                    if(nums[i] != a){
                        b = Math.max(b,nums[i]);}
                }
                for(int i = 0; i<nums.length; i++){
                    if(nums[i] != a && nums[i] != b){
                        c = Math.max(c,nums[i]);
                        s++;
                    }      }
                result = c;
                if(s == 0)
                    result = a;
            }
            return result;
        }
    public static void main(String[] args){
            int[] nums = {1,2,3,10,11,5};
            thirdMaxNumber third = new thirdMaxNumber();
            System.out.print(third.thirdMax(nums));
    }
}
