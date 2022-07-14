//implement strStr().
//    Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
//    or -1 if needle is not part of haystack.
public class StrStr {

        public static int strStr(String haystack, String needle) {
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
        }
        public static void main(String[] args){
            String haystack = "where are you;";
            String needle = "you";
            System.out.print(strStr(haystack,needle));
        }
    }



