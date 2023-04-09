//Given a sorted array of positive integers.
// Your task is to rearrange the array elements alternatively i.e first element should be max value,
// second should be min value, third should be second max, fourth should be second min and so on.
//Note: Modify the original array itself. Do it without using any extra space. You do not have to return anything.

public class RearrangeArrayAlternatively {
        // temp: input array
        // n: size of array
        //Function to rearrange  the array elements alternately.
        public static void rearrange(long arr[], int n){

            // Your code here
            long[] arr1 = new long[n];
            int t = 0;
            int k = n-1;
            for(int i = 0; i < n; i++){
                if(i % 2 == 0){
                    arr1[i] = arr[k];
                    k--;
                }
                else{
                    arr1[i]=arr[t];
                    t++;
                }
            }
            for(int i = 0; i < n; i++){
                arr[i]=arr1[i];
            }
            return;
        }

}
