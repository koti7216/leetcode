//moves zeros to the end of an array.In place algorithm
public class MoveZerosToEnd {
        public static int[] moveZeroes(int[] nums) { // time complexity O(n) and space complexity O(1)
            int t = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] != 0){
                    nums[t] = nums[i];
                    t++;
                }
            }
            for(int i = t; i < nums.length; i++){
                nums[i] = 0;
            }
            return nums;
        }
   /* // in below algorithm, works when we don't mind the order of the output
    public static int[] moveZeroes(int[] nums){ // time complexity O(n) and space complexity O(1)
        int i = 0, j = nums.length - 1;
        for(int t = 0; t < nums.length; t++){
            if(nums[i] == 0) {
                if(nums[j] != 0){
                 nums[i] = nums[j];
                 nums[j] = 0;
                 i++;
                }
                else
                  j--;
            }
            else i++;
        }
        return nums;
    }*/
        public static void main(String[] args){
            int[]nums = {1,2,0,3,0,4,0,5,0};
            nums = moveZeroes(nums);
            for(int i = 0; i < nums.length; i++){
                System.out.print(nums[i]);
            }
        }
}


