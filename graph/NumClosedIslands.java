public class NumClosedIslands {
        public int closedIsland(int[][] grid) {
            int ans = 0;
            int t=0;
            Queue<Integer> q = new LinkedList<>();
            int l = grid.length;
            int h = grid[0].length;
            for(int i=0; i<l;i++){
                for(int j =0; j<h;j++){
                    if(grid[i][j]==0){
                        if(i==0 || j ==0 || i==l-1 ||j ==h-1){
                            continue;
                        }
                        else{
                            q.offer(i);
                            q.offer(j);
                            grid[i][j]=2;
                            ans++;
                            t=1;
                            while(!q.isEmpty()){
                                int a =q.size();
                                for(int k =1; k<= a;k++){
                                    int b = q.poll();
                                    k++;
                                    int c = q.poll();
                                    if(b>=0 && b<l && c-1>=0 && c-1<h && grid[b][c-1]==0){
                                        if((b==0 || b==l-1 || c-1==0 || c-1==h-1) && t==1){
                                            t=0;
                                            ans--;
                                        }
                                        grid[b][c-1]=2;
                                        q.offer(b);
                                        q.offer(c-1);
                                    }
                                    if(b-1>=0 && b-1<l && c>=0 && c<h && grid[b-1][c]==0){
                                        if((b-1==0 || b-1==l-1 || c==0 || c==h-1) && t==1){
                                            t=0;
                                            ans--;
                                        }
                                        grid[b-1][c]=2;
                                        q.offer(b-1);
                                        q.offer(c);
                                    }
                                    if(b>=0 && b<l && c+1>=0 && c+1<h && grid[b][c+1]==0){
                                        if((b==0 || b==l-1 || c+1==0 || c+1==h-1) && t==1){
                                            t=0;
                                            ans--;
                                        }
                                        grid[b][c+1]=2;
                                        q.offer(b);
                                        q.offer(c+1);
                                    }
                                    if(b+1>=0 && b+1<l && c>=0 && c<h && grid[b+1][c]==0){
                                        if((b+1==0 || b+1==l-1 || c==0 || c==h-1) && t==1){
                                            t=0;
                                            ans--;
                                        }
                                        grid[b+1][c]=2;
                                        q.offer(b+1);
                                        q.offer(c);
                                    }
                                }
                            }
                        }
                    }
                }
            }

            return ans;
        }
}
