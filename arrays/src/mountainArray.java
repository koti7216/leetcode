public class mountainArray {
        public static boolean validMountainArray(int[] arr) {
            boolean koti = false;
            int i = 0;
            int m = 0;
            if(arr.length < 3){
                koti = false;
            }
            else{
                while(i < arr.length - 1 && arr[i] < arr[i + 1])
                    i++;

                int j = i;
                while(j < arr.length - 1 && arr[j] > arr[j + 1]){
                    j++;
                    m++;
                }
                if(i + m == arr.length - 1 && i>0 && m > 0)
                    koti = true;
            }
            return koti;
        }
        public static void main(String[] args){
            int[] arr = {1,2,3,4,2,1}; // mountain Array
            int[] arr1 = {1,2,3,3,2,1};//not a mountain array
            System.out.println(validMountainArray(arr)) ;
            System.out.println(validMountainArray(arr1)) ;
        }
}
