public class DuplicateZeros {
       /* public static void duplicateZeros(int[] arr) { // time complexity O(n^2) and space complexity O(1)
            for(int i = 0; i < arr.length; i++){
                if(arr[i] == 0){
                    for(int j = arr.length - 2; j >= i; j--){
                        arr[j + 1] = arr[j];
                    }
                    i++;
                }

            }
        }*/
       public static void duplicateZeros(int[] arr){ // time complexity O(n) and space complexity O(1)
           int t = 0;
           int m = arr.length - 1;
           for(int i = 0; i< arr.length; i++){
               if(arr[i] == 0 && i + t < m){

                   t++;
               }
               else if(arr[i] == 0 && i + t == m){
                   arr[m] = 0;
                   m--;
                   break;
               }
           }
           for(int i = m; i >= 0; i--){
               if(arr[i - t] != 0){
                   arr[i] = arr[i-t];
               }
               else{
                   arr[i] = 0;
                   i--;
                   arr[i] = 0;
                   t--;
               }
           }
       }

        public static void main(String[] args){
            int[] arr = {1,2,0,0,2,3,4};
            duplicateZeros(arr);
            for(int i = 0; i < arr.length; i++){ // prints 1200002
                System.out.print(arr[i]);
            }
        }
    }

