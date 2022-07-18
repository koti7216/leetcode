//Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.
        //In one step, you can delete exactly one character in either string.
// Solution : the idea is to find the largest common string from both strings and use its length to find min.
public class MinDistance {
    public static int minDistance(String word1, String word2) {  // time complexity O(n^2) Space complexity O(1)
        int h = 0, k, t;
        for (int i = 0; i < word1.length(); i++) {
            t = i;
            k = 0;
            for (int j = 0; j < word2.length(); j++) {

                if (t < word1.length() && word1.charAt(t) == word2.charAt(j)) {
                    k += 1;
                    t += 1;
                }
            }
            h = Math.max(k, h);
        }
        int min = word1.length() + word2.length() - 2 * (h);
        return min;
    }
    public static void main(String[] args){
     String word1 = "sea";
     String word2 = "eat";
     System.out.print(minDistance(word1, word2));  // deletes s from sea and t from eat
    }
    }
