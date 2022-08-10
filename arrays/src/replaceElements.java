public class replaceElements {
       /* public static int[] replaceElements1(int[] arr) {
            for(int i = 0; i < arr.length; i++){
                int t = 0;
                int h = 0;
                if(i == arr.length - 1)
                    arr[i] = -1;
                else{
                    for(int j = i + 1; j < arr.length; j++){
                        if(t < arr[j]){
                            t = arr[j];
                            h = j;
                        }
                    }
                    while(i < h){
                        arr[i] = t;
                        i++;
                    }
                    i--;
                }
            }
            return arr;
        }*/
        public static int[] replaceElements1(int[] arr) { // this is another approach
        int max = arr[arr.length-1];
        if(arr.length == 1)
            arr[0] = -1;
        else{
        for(int i = arr.length - 2; i >= 0; i--){
            int m = arr[i];
            max = Math.max(max,arr[i+1]);
            arr[i] = max;
            max = m;
        }
        }
        arr[arr.length - 1] = -1;
       return arr;
    }
        public static void main(String[] args){
            int[] arr = {1,2,3,4,5,6};
            arr = replaceElements1(arr); // it returns the array with replaced items with largest integer from right side
            for(int num : arr){
                System.out.print(num);
            }
        }
}
