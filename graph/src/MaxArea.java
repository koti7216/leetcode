import java.util.LinkedList;
import java.util.Queue;
//You are given an m x n binary matrix grid. An island is a group of 1's (representing land)
// connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
//The area of an island is the number of cells with a value 1 in the island.
//Return the maximum area of an island in grid. If there is no island, return 0.
public class MaxArea {
        public int maxAreaOfIsland(int[][] grid) {
            int ans = 0;
            int max = 0;
            Queue<Integer> q = new LinkedList<>();
            int l = grid.length;
            int h = grid[0].length;
            for(int i = 0; i < l; i++){
                for(int j = 0; j < h;j++){
                    if(grid[i][j]==1){
                        q.offer(i);
                        q.offer(j);
                        ans = 1;
                        grid[i][j] = 2;
                        while(!q.isEmpty()){
                            int a = q.size();
                            for(int k = 1; k <= a; k++){
                                int b = q.poll();
                                k++;
                                int c = q.poll();
                                if(b>=0 && b < l && c-1 >=0 && c-1<h && grid[b][c-1]==1){
                                    grid[b][c-1]=2;
                                    q.offer(b);
                                    q.offer(c-1);
                                    ans++;
                                }
                                if(b-1>=0 && b-1 < l && c >=0 && c<h && grid[b-1][c]==1){
                                    grid[b-1][c]=2;
                                    q.offer(b-1);
                                    q.offer(c);
                                    ans++;
                                }
                                if(b>=0 && b < l && c+1 >=0 && c+1<h && grid[b][c+1]==1){
                                    grid[b][c+1]=2;
                                    q.offer(b);
                                    q.offer(c+1);
                                    ans++;
                                }
                                if(b+1>=0 && b+1 < l && c >=0 && c<h && grid[b+1][c]==1){
                                    grid[b+1][c]=2;
                                    q.offer(b+1);
                                    q.offer(c);
                                    ans++;
                                }
                            }
                        }
                        max = Math.max(ans,max);
                    }
                }
            }
            return max;
        }
    }
