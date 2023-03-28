import java.util.*;
//You are given an m x n grid where each cell can have one of three values:
//
//0 representing an empty cell,
//1 representing a fresh orange, or
//2 representing a rotten orange.
//Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
//
//Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
public class RottingOranges {
        public int orangesRotting(int[][] grid) {
            Queue<Integer> q = new LinkedList<>();
            int c = 0;
            for(int i = 0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    if(grid[i][j]==2){
                        q.offer(i);
                        q.offer(j);
                    }
                    if(grid[i][j]==1)
                        c++;
                }
            }
            if(c==0)
                return 0;
            int result =-1;
            while(!q.isEmpty()){
                int s = q.size();
                result++;
                for(int i=0;i<s;i++){
                    int j = q.poll();
                    i++;
                    int k = q.poll();
                    if(j-1>=0 && grid[j-1][k]==1){
                        q.offer(j-1);
                        q.offer(k);
                        grid[j-1][k]=2;
                        c--;
                    }
                    if(k-1>=0 && grid[j][k-1]==1){
                        q.offer(j);
                        q.offer(k-1);
                        grid[j][k-1]=2;
                        c--;
                    }
                    if(j+1<grid.length && grid[j+1][k]==1){
                        q.offer(j+1);
                        q.offer(k);
                        grid[j+1][k]=2;
                        c--;
                    }
                    if(k+1<grid[0].length && grid[j][k+1]==1){
                        q.offer(j);
                        q.offer(k+1);
                        grid[j][k+1]=2;
                        c--;
                    }
                }
            }
            if(c != 0){
                return -1;
            }
            else{
                return result;
            }
        }
}
