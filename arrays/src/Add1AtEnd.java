// add 1 to the number
public class Add1AtEnd {
        public static int[] plusOne(int[] digits) { // O(n) time complexity O(n) space complexity
            int t = 0, m = 0;
            int[] result = new int[digits.length + 1];
            for(int i = 0; i < digits.length; i++){
                if(digits[i] == 9){
                    t = t + 1;
                }
            }
            if(t == digits.length){
                result[0] = 1;
                for(int j = 1; j <= digits.length; j++){
                    result[j] = 0;
                }

            }
            else{
                sum(digits, digits.length - 1);
            }
            if(t == digits.length)
                return result;
            else
                return digits;
        }
        public static void sum(int[] digits, int l){
            if(digits[l] != 9)
                digits[l]++;
            else{
                sum(digits, l - 1);
                digits[l] = 0;
            }
        }
        public static void main(String[] args){
            int[] digits = {9,9,9,9};  // 9999 + 1 = 10000
            int[] result = plusOne(digits);
            for(int i = 0; i < result.length; i++){
                System.out.print(result[i]);
            }
        }
    }


