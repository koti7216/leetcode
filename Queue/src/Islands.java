 //Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
//An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
// You may assume all four edges of the grid are all surrounded by water.

 import java.util.*;

 public class Islands {
     public static int numIslands(char[][] grid) {
         // time complexity is O(size of the grid) since we move through every element only once
         // space complexity is O(min(rows and columns)) since we store atmost min(rows and columns) in queue
            int m = grid.length;
            int n = grid[0].length;
            List<int[]> directions = Arrays.asList(new int[] {1,0},new int[] {-1,0},new int[] {0,1},new int[] {0,-1});
            int result = 0;
            Queue<Integer> q = new LinkedList<>();
            for(int g = 0; g < m; g++){
                for(int f = 0; f < n; f++){
                    if(grid[g][f] == 'j' || Integer.parseInt(String.valueOf(grid[g][f])) == 0){
                        continue;
                    }
                    else{
                        q.offer(g);
                        q.offer(f);
                        grid[g][f] = 'j';
                        result++;
                        while(q.size() != 0){
                            int s = q.poll();
                            int r = q.poll();
                            for(int[] direction : directions){
                                int h = s + direction[0];
                                int d = r + direction[1];

                                if(h >= m || d >= n || h <0 || d <0 ||grid[h][d] == 'j' || Integer.parseInt(String.valueOf(grid[h][d])) == 0 )
                                    continue;
                                q.offer(h);
                                q.offer(d);
                                grid[h][d] = 'j';
                            }
                        }
                    }
                }}
            return result;
    }

     public static void main(String[] args) {
         char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
         System.out.println(numIslands(grid)); // return islands i.e; number of trees
     }
}
