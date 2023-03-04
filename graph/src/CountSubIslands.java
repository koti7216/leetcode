import java.util.LinkedList;
import java.util.Queue;
//You are given two m x n binary matrices grid1 and grid2 containing only 0's (representing water)
// and 1's (representing land). An island is a group of 1's connected 4-directionally (horizontal or vertical).
// Any cells outside of the grid are considered water cells.
//
//An island in grid2 is considered a sub-island if there is an island in grid1 that contains
// all the cells that make up this island in grid2.
//
//Return the number of islands in grid2 that are considered sub-islands.
public class CountSubIslands {
        public int countSubIslands(int[][] grid1, int[][] grid2) {
            int ans=0;
            int t=0;
            Queue<Integer> q = new LinkedList<>();
            int l = grid2.length;
            int h= grid2[0].length;
            for(int i = 0; i <l; i++){
                for(int j=0;j<h;j++){
                    if(grid2[i][j]==1 && grid1[i][j]==1){
                        q.offer(i);
                        q.offer(j);
                        grid2[i][j]=2;
                        t=1;
                        while(!q.isEmpty()){
                            int a = q.size();
                            for(int k = 1; k<=a;k++){
                                int b = q.poll();
                                k++;
                                int c = q.poll();
                                if(b>=0&&b<l&&c-1>=0&&c-1<h&&grid2[b][c-1]==1){
                                    if(grid1[b][c-1]==0)
                                        t=0;
                                    grid2[b][c-1]=2;
                                    q.offer(b);
                                    q.offer(c-1);
                                }
                                if(b-1>=0&&b-1<l&&c>=0&&c<h&&grid2[b-1][c]==1){
                                    if(grid1[b-1][c]==0)
                                        t=0;
                                    grid2[b-1][c]=2;
                                    q.offer(b-1);
                                    q.offer(c);
                                }
                                if(b>=0&&b<l&&c+1>=0&&c+1<h&&grid2[b][c+1]==1){
                                    if(grid1[b][c+1]==0)
                                        t=0;
                                    grid2[b][c+1]=2;
                                    q.offer(b);
                                    q.offer(c+1);
                                }
                                if(b+1>=0&&b+1<l&&c>=0&&c<h&&grid2[b+1][c]==1){
                                    if(grid1[b+1][c]==0)
                                        t=0;
                                    grid2[b+1][c]=2;
                                    q.offer(b+1);
                                    q.offer(c);
                                }
                            }
                        }
                        if(t==1)
                            ans++;
                    }
                }
            }
            return ans;
        }
    }

