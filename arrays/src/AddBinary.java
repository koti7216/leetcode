// adding two strings of binary numbers
import java.util.*;
public class AddBinary {
        public static String addBinary(String a, String b) { // time complexity O(m) m is max length of string a and b
            // space complexity O(m), m is max length of string a and b
            StringBuilder temp = new StringBuilder();
            int m = a.length() - 1;
            int n = b.length() - 1;
            int c = 0;
            while(Math.min(m,n) >= 0){
                int h = Integer.parseInt(String.valueOf(a.charAt(m))); // changing char at m into int
                int d = Integer.parseInt(String.valueOf(b.charAt(n))); // changing char at n into int

                if(h + d + c == 3){
                    temp.append(""+1);
                }
                else if(h + d + c == 2){
                    c = 1;
                    temp.append(""+0);
                }
                else if(h + d + c == 1){
                    c = 0;
                    temp.append(""+1);}
                else if(h + d + c == 0){
                    c = 0;
                    temp.append(""+0);
                }
                m--;
                n--;
            }
            if(m > n){
                for(int i = m; i >= 0; i--){
                    int h = Integer.parseInt(String.valueOf(a.charAt(m)));
                    if(c + h == 2){
                        temp.append(""+0);
                        c = 1;
                    }
                    else if(c + h == 1){
                        temp.append(""+1);
                        c = 0;}
                    else if(c + h == 0){
                        temp.append(""+0);
                        c = 0;
                    }

                    m--;
                }
            }
            if(m < n){
                for(int j = n; j >= 0; j--){
                    int d = Integer.parseInt(String.valueOf(b.charAt(n)));
                    if(c + d == 2){
                        temp.append(""+0);
                        c = 1;
                    }
                    else if(c + d == 1){
                        temp.append(""+1);
                        c = 0;}
                    else if(c + d == 0){
                        temp.append(""+0);
                        c = 0;
                    }

                    n--;}}
            if(c == 1){
                temp.append(""+1);
            }
            temp.reverse();
            return temp.toString();
        }
       public static void main(String[] args){
            String a = "10101";
            String b = "1011111";
            System.out.print(addBinary(a,b));
       }
}
