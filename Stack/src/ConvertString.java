public class ConvertString {


// User function Template for Java
        public static int isItPossible(String S, String T, int M, int N) {
            // code here
            if(M != N)
                return 0;
            int i = 0;
            int j = 0;
            while(i<M||j<N){
                while(i<M && S.charAt(i)=='#')
                    i++;
                while(j<M && T.charAt(j)=='#')
                    j++;
                if(i>=M || j >= N )
                    break;
                if(S.charAt(i)!=T.charAt(j))
                    return 0;
                if(S.charAt(i)==T.charAt(j)){
                    i++;
                    j++;}
            }
            if(i == j)
                return 1;
            return 0;}

    public static void main(String[] args) {
        System.out.println(isItPossible("#AB#","##AB#",4,5));
    }
    }

