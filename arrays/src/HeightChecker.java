//A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line in non-decreasing order by height. Let this ordering be represented by the integer array expected where expected[i] is the expected height of the ith student in line.

//You are given an integer array heights representing the current order that the students are standing in. Each heights[i] is the height of the ith student in line (0-indexed).

//Return the number of indices where heights[i] != expected[i].
import java.util.*;
public class HeightChecker {
    public static int heightChecker(int[] heights) { // time complexity O(nlogn) space complexity O(n)
        int[] expected = new int[heights.length];
        int result = 0;
        for(int i = 0; i < heights.length; i++){
            expected[i] = heights[i];
        }
        Arrays.sort(heights);  // time complexity O(nlogn)
        for(int i = 0; i < heights.length; i++){
            if(heights[i] != expected[i]){
                result++;
            }
        }
        return result;
    }

    public static void main( String[] args){
        int[] heights = {4,2,3,1};
        System.out.print(heightChecker(heights));
    }
}

