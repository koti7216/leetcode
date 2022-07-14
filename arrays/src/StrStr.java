//implement strStr().
//    Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
//    or -1 if needle is not part of haystack.
public class StrStr {

       /* public static int strStr(String haystack, String needle) {
            int m = haystack.length();
            int n = needle.length();

            int index = -1;
            if(n == 0)
                index = 0;
            else if(n > m){
                index = -1;
            }
            else{
                index = haystack.indexOf(needle); //O(n) time complexity
            }
            return index;
        }*/
       public static int strStr(String haystack, String needle) { // time complexity is O(n) n is length of haystack
           int m = haystack.length();
           int n = needle.length();
           int t = 0;
           int h;
           int index = -2;
           if(n == 0)
               index = 0;
           else if(n > m){
               index = -1;
           }
           else{
               if(haystack.indexOf(needle.charAt(0)) == -1){
                   index = -1;
               }
               else {
                   while(t <= m - n && haystack.substring(t,m).indexOf(needle.charAt(0)) != -1 && index == -2){
                       h = t + haystack.substring(t,m).indexOf(needle.charAt(0));
                       if(h <= m - n){
                           if(haystack.substring(h,h+n).compareTo(needle) == 0){
                               index = h;
                           }}
                       t = h + 1;
                   }

               }

           }
           if(index == -2)
               index = -1;


           return index;
       }

    public static void main(String[] args){
            String haystack = "where are you;";
            String needle = "you";
            System.out.print(strStr(haystack,needle));
        }
    }



