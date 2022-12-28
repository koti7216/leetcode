//Given an encoded string, return its decoded string.
//The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being
// repeated exactly k times. Note that k is guaranteed to be a positive integer.
//You may assume that the input string is always valid; there are no extra white spaces,
// square brackets are well-formed, etc. Furthermore, you may assume that the original data
// does not contain any digits and that digits are only for those repeat numbers, k.
// For example, there will not be input like 3a or 2[4].
//The test cases are generated so that the length of the output will never exceed 105.

import java.util.*;
public class Decoder {
    public static String decodeString(String s) {
        // time complexity is O(output length) and space complexity is O(m) where m is largest repeated string in the output
        Stack<Character> temp1 = new Stack<>();
        Stack<Character> temp = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ']'){
                temp1.push(s.charAt(i));
            }
            else{
                while(temp1.peek() != '[')
                    temp.push(temp1.pop());
                temp1.pop();
                double a = 0;
                int t = 0;
                while(!temp1.empty() && Character.isDigit(temp1.peek())){
                    a = a + Math.pow(10,t) *Character.getNumericValue(temp1.pop());
                    t++;
                }
                while(a > 0){
                    Stack<Character> temp2 = (Stack<Character>)temp.clone();
                    while(!temp2.empty()){
                        temp1.push(temp2.pop());
                    }
                    a--;
                }
                temp.clear();
            }
        }
        StringBuilder w = new StringBuilder();
        while(!temp1.empty()){
            w.append(temp1.pop());
        }
        return w.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
    }
}