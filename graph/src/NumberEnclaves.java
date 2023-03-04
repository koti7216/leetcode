import java.util.LinkedList;
import java.util.Queue;
//You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
//
//A move consists of walking from one land cell to another adjacent (4-directionally) land cell or
// walking off the boundary of the grid.
//
//Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
public class NumberEnclaves {
        public int numEnclaves(int[][] grid) {
            int ans = 0;
            int ans1 = 0;
            int t=0;
            Queue<Integer> q = new LinkedList<>();
            int l = grid.length;
            int h = grid[0].length;
            for(int i=0; i<l;i++){
                for(int j =0; j<h;j++){
                    if(grid[i][j]==1){
                        q.offer(i);
                        q.offer(j);
                        if(i==0||i==l-1||j==0||j==h-1)
                            t=0;
                        else
                            t=1;
                        grid[i][j]=2;
                        while(!q.isEmpty()){
                            int a =q.size();
                            for(int k =1; k<= a;k++){
                                int b = q.poll();
                                k++;
                                int c = q.poll();
                                ans++;
                                if(b>=0 && b<l && c-1>=0 && c-1<h && grid[b][c-1]==1){
                                    if((b==0 || b==l-1 || c-1==0 || c-1==h-1) && t==1){
                                        t=0;
                                    }
                                    grid[b][c-1]=2;
                                    q.offer(b);
                                    q.offer(c-1);
                                }
                                if(b-1>=0 && b-1<l && c>=0 && c<h && grid[b-1][c]==1){
                                    if((b-1==0 || b-1==l-1 || c==0 || c==h-1) && t==1){
                                        t=0;
                                    }
                                    grid[b-1][c]=2;
                                    q.offer(b-1);
                                    q.offer(c);
                                }
                                if(b>=0 && b<l && c+1>=0 && c+1<h && grid[b][c+1]==1){
                                    if((b==0 || b==l-1 || c+1==0 || c+1==h-1) && t==1){
                                        t=0;
                                    }
                                    grid[b][c+1]=2;
                                    q.offer(b);
                                    q.offer(c+1);
                                }
                                if(b+1>=0 && b+1<l && c>=0 && c<h && grid[b+1][c]==1){
                                    if((b+1==0 || b+1==l-1 || c==0 || c==h-1) && t==1){
                                        t=0;
                                    }
                                    grid[b+1][c]=2;
                                    q.offer(b+1);
                                    q.offer(c);
                                }
                            }
                        }
                        if(t==1){
                            ans1+=ans;
                            ans=0;
                        }
                        else
                            ans=0;
                    }
                }
            }

            return ans1;
        }
    }

