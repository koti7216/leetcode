public class mergeStrings {
        public static  int[] merge(int[] nums1, int m, int[] nums2, int n) {
            int t = n - 1;
            int h = m - 1;
            for(int i = m + n - 1; i >= 0; i--){
                if(h >= 0 && t >= 0){
                    if(nums1[h] >= nums2[t]){
                        nums1[i] = nums1[h];
                        h--;
                    }
                    else{
                        nums1[i] = nums2[t];
                        t--;
                    }
                }
                else{
                    if(h == -1 && t != -1){
                        nums1[i] = nums2[t];
                        t--;
                    }
                    if(t == -1 && h != -1){
                        nums1[i] = nums1[h];
                        h--;
                    }
                }
            }
            return nums1;
        }
        public static void main(String[] args){
            int[] nums1 = {1,2,3,4,5,0,0,0,0};
            int m = 5;
            int[] nums2 = {2,3,4,7};
            int n = 4;
            int[] result = merge(nums1,m,nums2,n);
            for(int i = 0; i < result.length; i++){
                System.out.println(result[i]);
            }

        }
    }

