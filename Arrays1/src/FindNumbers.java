// find number of even digit numbers in given array
public class FindNumbers {
        public static int findNumbers(int[] nums) { // O(m*n) m is largest digits of a number and n is length of array
            // space complexity is O(1)
            int count = 0;
            for(int i = 0; i < nums.length; i++){
                int digits = 1;
                while(nums[i]/10 != 0){
                    nums[i] = nums[i]/10;
                    digits++;
                }
                if(digits % 2 == 0)
                    count++;
            }
            return count;
        }
        public static void main(String[] args){
            int[] nums = {1,2436,3};
            System.out.print(findNumbers(nums)); // here 2436 is only even digit number , So returns 1
        }
}
