//Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
//The distance between two adjacent cells is 1.
import java.util.*;
public class UpdateMatrix {
    public static int[][] updateMatrix(int[][] mat) {
        // time complexity is O(size of matrix)
        // space matrix is O(size of matrix)
        Queue<Integer> q = new LinkedList<>();
        int[][] dp = new int[mat.length][mat[0].length];
        List<int[]> l = Arrays.asList(new int[] {1,0}, new int[]{0,1}, new int[] {-1,0}, new int[] {0,-1});
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0){
                    q.offer(i);
                    q.offer(j);
                }
                else
                    mat[i][j] = -1;
            }
        }
        int count = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int t = 1; t <= size; t = t + 2){
                int c = q.poll();
                int d = q.poll();
                if(mat[c][d] != 0){
                    mat[c][d] = count;
                }
                for(int[] direction : l){
                    int a = c + direction[0];
                    int b = d + direction[1];
                    if(a < 0 || a >= mat.length || b < 0 || b >= mat[0].length  || dp[a][b] == 1)
                        continue;
                    q.offer(a);
                    q.offer(b);
                    dp[a][b] = 1;
                }
            }
            count++;
        }

        return mat;

    }
/*
    public static int[][] updateMatrix(int[][] mat) {
    // time complexity is O(size of matrix)
    //space complexity is O(size of matrix)
        Queue<Integer> q = new LinkedList<>();
        List<int[]> l = Arrays.asList(new int[] {1,0}, new int[]{0,1}, new int[] {-1,0}, new int[] {0,-1});
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0){
                    q.offer(i);
                    q.offer(j);
                }
                else
                    mat[i][j] = -1;
            }
        }
        int count = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int t = 1; t <= size; t = t + 2){
                int c = q.poll();
                int d = q.poll();
                if(mat[c][d] != 0){
                    mat[c][d] = count;
                }
                for(int[] direction : l){
                    int a = c + direction[0];
                    int b = d + direction[1];
                    if(a < 0 || a >= mat.length || b < 0 || b >= mat[0].length  || mat[a][b] != -1)
                        continue;
                    q.offer(a);
                    q.offer(b);
                    mat[a][b] = 1;
                }
            }
            count++;
        }

        return mat;

    }*/
public static void main(String[] args) {
    int[][]mat = {{0,3,5},{1,4,0},{7,9,0}};
    mat = updateMatrix(mat);
    for(int i = 0; i < mat.length; i++){
        for(int j = 0; j < mat[0].length; j++){
            System.out.println(mat[i][j]);
        }}
}
}