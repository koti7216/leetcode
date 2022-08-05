//Given an array arr of integers, check if there exists two integers N and M
// such that N is the double of M ( i.e. N = 2 * M).
import java.util.Arrays;
class CheckIfExist {
    /*public static boolean checkIfExist(int[] arr) { // time complexity O(n^2) and space complexity O(1)
        boolean result = false;
        for(int i = 1; i < arr.length; i++){
            for(int j = 0; j < i; j++){
                if(arr[i]*2 == arr[j] || arr[i] == arr[j]*2){
                    return true;
                }
            }
        }
        return result;
    }*/
    public static boolean checkIfExist(int[] arr){ // time complexity O(nlogn) and space complexity O(1)
        boolean result =  false;
        Arrays.sort(arr);  // O(nlogn)
        int first = 0;
        int last = arr.length-1;
        for(int i = 0; i < arr.length; i++){ //O(n)
            if(arr[first]*2 == arr[last])
                return true;
            else if(arr[first]*2 > arr[last])
                first++;
            else
                last--;
        }
        return result;
    }


    public static void main(String[] args){
        int[] arr = {2,4};
        System.out.print(checkIfExist(arr));
    }
}


