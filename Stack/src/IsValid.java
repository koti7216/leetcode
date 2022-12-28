//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//An input string is valid if:
//Open brackets must be closed by the same type of brackets.
//Open brackets must be closed in the correct order.
import java.util.*;
public class IsValid {
    public static boolean isValid(String s) {
        // time complexity is O(n)
        //Space complexity is O(n)
        Stack<Character> s1 = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(')
                s1.push(')');
            else if(s.charAt(i) == '{')
                s1.push('}');
            else if(s.charAt(i) == '[')
                s1.push(']');
            else{
                if(s1.size() == 0)
                    return false;
                else if(s1.peek()==s.charAt(i))
                    s1.pop();
                else
                    return false;
            }}
        return s1.empty();
    }

    public static void main(String[] args) {
        String s= "({[({})]{)";
        System.out.println(isValid(s)); // returns valid or not since { hasn't closed it is false
    }
}
