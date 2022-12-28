//Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
// return the number of islands.
//An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
// You may assume all four edges of the grid are all surrounded by water.
import java.util.*;
public class NumsIslands{
    // time complexity is O(size of the grid)
    // space complexity is O(size of the grid)
    public static int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(Integer.parseInt(String.valueOf(grid[i][j])) == 1){
                    result++;
                    dfs(grid,i,j);
                }
            }
        }
        return result;
    }
    public static void dfs(char[][] grid, int i, int j){
        if( i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || Integer.parseInt(String.valueOf(grid[i][j])) == 0)
            return;
        grid[i][j] = '0';
        List<int[]> directions = Arrays.asList(new int[] {1,0},new int[] {-1,0},new int[] {0,1},new int[] {0,-1});
        for(int[] direction: directions){
            dfs(grid,i+direction[0],j+direction[1]);
        }
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(numIslands(grid)); // returns the number of islands
    }
}