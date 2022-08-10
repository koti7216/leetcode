import java.util.*;
public class DiagonalOrderOfMatrix { // returns the diagonal order of the given matrix
    public static int[] findDiagonalOrder(int[][] mat) { // time complexity O(n^2) space complexity O(1) if we consider return
        // array as not extra space
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m*n];
        int j;
        int c = 1;
        result[0] = mat[0][0];
        for(int t = 1; t <= m + n - 2; t++){
            if(t % 2 == 1){
                for(int i = 0; i < m; i++){
                    j = t - i;
                    if(j <= n - 1 && j >= 0){
                        result[c] = mat[i][j];
                        c++;
                    }
                }
            }
            if(t % 2 == 0){
                for(int i = m - 1; i >= 0; i--){
                    j = t - i;
                    if(j <= n - 1 && j >= 0){
                        result[c] = mat[i][j];
                        c++;
                    }
                }
            }
        }
        return result;

    }
    public static void main(String[] args){
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        int[] result = findDiagonalOrder(mat);
        for(int i = 0; i<result.length; i++){
            System.out.println(result[i]); // prints 1,2,4,7,5,3,6,8,9
        }
    }
}
