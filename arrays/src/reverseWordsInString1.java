public class reverseWordsInString1 {
        public static  String reverseWords(String s) {
            StringBuilder koti = new StringBuilder();
            StringBuilder temp = new StringBuilder();
            int i = s.length() - 1;
            if(s.length() == 1){
                return s;
            }
            while(s.charAt(i) == ' '){
                i--;
            }
            for(int j = i; j >= 0; j--){
                if(s.charAt(j) != ' ')
                    temp.append(s.charAt(j));
                if((s.charAt(j) == ' '  && s.charAt(j+1) != ' ') || j == 0){
                    temp.reverse();
                    koti.append(temp);
                    temp.delete(0,temp.capacity());
                }
                if(j != 0 && s.charAt(j) == ' ' && s.charAt(j-1) != ' '){
                    koti.append(' ');
                }
            }
            String result1 = koti.toString();
            return result1;
        }
    public static void main(String[] args){
            String s = " I am   Groot! ";
            reverseWordsInString1 result = new reverseWordsInString1();
            System.out.print(result.reverseWords(s));
    }
}
