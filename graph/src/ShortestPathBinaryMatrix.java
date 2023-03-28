import java.util.*;
//Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix.
// If there is no clear path, return -1.
//
//A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell
// (i.e., (n - 1, n - 1)) such that:
//
//All the visited cells of the path are 0.
//All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
//The length of a clear path is the number of visited cells of this path.
public class ShortestPathBinaryMatrix {
        public int shortestPathBinaryMatrix(int[][] grid) {
            int s = grid.length;
            if(grid[0][0]==1 || grid[s-1][s-1]==1)
                return -1;
            if(s == 1)
                return 1;
            Queue<Integer> q = new LinkedList<>();
            q.offer(0);
            q.offer(0);
            grid[0][0]=-1;
            int result = 1;
            while(!q.isEmpty()){
                int a = q.size();
                result++;
                for(int i=0;i<a;i++){
                    int j = q.poll();
                    i++;
                    int k = q.poll();
                    if(j-1 >= 0 && grid[j-1][k]==0){
                        q.offer(j-1);
                        q.offer(k);
                        grid[j-1][k]=-1;
                    }
                    if(k-1 >= 0 && grid[j][k-1]==0){
                        q.offer(j);
                        q.offer(k-1);
                        grid[j][k-1]=-1;
                    }
                    if(j+1 < s && grid[j+1][k]==0){
                        if(j+1 == s-1 && k == s-1)
                            return result;
                        q.offer(j+1);
                        q.offer(k);
                        grid[j+1][k]=-1;
                    }
                    if(k+1 < s && grid[j][k+1]==0){
                        if(j == s-1 && k+1 == s-1)
                            return result;
                        q.offer(j);
                        q.offer(k+1);
                        grid[j][k+1]=-1;
                    }
                    if(j-1 >= 0 && k+1 < s && grid[j-1][k+1]==0){
                        q.offer(j-1);
                        q.offer(k+1);
                        grid[j-1][k+1]=-1;
                    }
                    if(j-1 >= 0 && k-1 >= 0 && grid[j-1][k-1]==0){
                        q.offer(j-1);
                        q.offer(k-1);
                        grid[j-1][k-1]=-1;
                    }
                    if(j+1 < s && k+1 < s && grid[j+1][k+1]==0){
                        if(j+1 == s-1 && k+1 == s-1)
                            return result;
                        q.offer(j+1);
                        q.offer(k+1);
                        grid[j+1][k+1]=-1;
                    }
                    if(j+1 < s && k-1 >= 0 && grid[j+1][k-1]==0){
                        q.offer(j+1);
                        q.offer(k-1);
                        grid[j+1][k-1]=-1;
                    }



                }
            }
            return -1;
        }
}
