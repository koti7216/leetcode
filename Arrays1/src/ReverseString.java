public class ReverseString {
       /*public static void reverseString(char[] s) { // time complexity O(n) and space complexity O(1)
            for(int i = 0; i < s.length / 2; i++){
                char t = s[i];
                s[i] = s[s.length - 1 - i];
                s[s.length - 1 - i] = t;
            }
        }*/
    public static void reverseString(char[] s){ // time complexity O(n) and space complexity O(1)
        int i = 0;
        int j = s.length-1;
        while(j>i){
            char temp = s[j];
            s[j] = s[i];
            s[i] = temp;
            i++;
            j--;
        }
    }
        public static void main(String[] args){
            char[] s = {'h','i','i','i'};
            reverseString(s);
            for(int i = 0; i < s.length; i++){
                System.out.print(s[i]);
            }
        }
}
