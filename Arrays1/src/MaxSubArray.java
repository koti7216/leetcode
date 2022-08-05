//FIND MAX SUB-ARRAY OF NON NEGATIVE NUMBERS FROM THE ARRAY
import java.util.ArrayList;
// TIME COMPLEXITY O(N*K) N IS LENGTH OF THE ARRAY AND K IS THE MAX.LENGTH OF SUBARRAY
// SPACE COMPLEXITY IS O(N)
public class MaxSubArray {
    public static void main(String[] args){
        Integer[] k = {6, 0, 7, 3, -3, 5, 4, 7, 3};
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<Integer> temp1 = new ArrayList<>();
        int sum = 0, max = 0;
        for (int i = 0; i < k.length; i++) {
            if (k[i] >= 0) {
                sum += k[i];
                temp.add(k[i]);
            }
            if (k[i] < 0 || i == k.length - 1) {
                if (max < sum || (max == sum && temp.size() > temp1.size())) {
                    temp1 = new ArrayList<>(temp);
                    max = sum;
                }
                temp.clear();
                sum = 0;
            }
        }
        if (temp1.size() == 0 && k.length != 0) {
            temp1.add(-1);
            temp1.add(-1);
        }
        System.out.print(temp1);
    }
}
