//Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
// find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1]
// and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
//Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
public class TwoSum {
       public static int[] twoSum(int[] numbers, int target) { // time complexity O(n) and space complexity is O(1)
            int i = 0;
            int j = numbers.length - 1;
            while(numbers[i] + numbers[j] != target){
                if(target > numbers[i] + numbers[j]){
                    i++;
                }
                else
                    j--;
            }
            int[] result = {i + 1, j + 1};
            return result;
        }

        public static void main(String[] args){
            int[] numbers = {2,7,11,15};
            int target = 9;
            int[] result = twoSum(numbers,target);
            System.out.print("result is index " + result[0] + " and " + result[1]);

        }
}
