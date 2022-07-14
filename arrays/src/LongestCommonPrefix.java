//Write a function to find the longest common prefix string amongst an array of strings.
//
//If there is no common prefix, return an empty string "".
public class LongestCommonPrefix {
        public static String longestCommonPrefix(String[] strs) { // Time complexity is O(m*n), here m = length of common prefix
            // n is length of String Array
            // Space complexity is O(m)
            int i = 0;
            StringBuilder temp = new StringBuilder();
            int h = 0; // h is used for common prefix ending point
            if(strs.length == 1){
                temp.append(strs[0]);
            }
            else if(strs[0].length() == 0){

            }
            else{
                while(h == 0){
                    int t = 0;  // it is used for count (counting the all strings in a string array)
                    for(int j = 1; j < strs.length; j++){
                        if(strs[j].length() > 0 && i < strs[j].length() && i < strs[0].length()){
                            if(strs[0].charAt(i) == strs[j].charAt(i))
                                t = t + 1;}
                    }
                    if(t == strs.length - 1){
                        temp.append(strs[0].charAt(i));
                        i++;
                    }
                    else{
                        h = -1;
                    }
                }
            }
            if(temp.length() == 0){
                temp.append("");
            }
            String result = temp.toString();
            return result;
        }
        public static void main(String[] args){
            String[] strs = {"flow","flaw"};
            System.out.print(longestCommonPrefix(strs));

        }

}
