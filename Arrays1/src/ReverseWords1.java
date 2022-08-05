public class ReverseWords1 {
        public static String reverseWords(String s) { //O(N^2) time complexity and space complexity is O(N)
            StringBuilder result = new StringBuilder();
            StringBuilder temp = new StringBuilder();
            if(s.length() == 1)
                return s;
            for(int i = 0; i < s.length(); i++){ // O(N)
                if(s.charAt(i) != ' '){
                    temp.append(s.charAt(i));
                }
                if(s.charAt(i) == ' ' || i == s.length() - 1){
                    temp.reverse(); // O(N) time complexity for reverse string builder method
                    result.append(temp);
                    temp.delete(0,temp.capacity());
                    if(i != s.length() - 1)
                        result.append(' ');
                }
            }
            return result.toString();
        }
        public static void main(String[] args){
            String s = "Hii, this is koti";
            System.out.print(reverseWords(s)); // it reverses the every word in the string
        }
}
