//An image is represented by an m x n integer grid image where image[i][j] represents
// the pixelvalue of the image.
//You are also given three integers sr, sc, and color. You should perform a flood fill on the image
// starting from the pixel image[sr][sc].
//To perform a flood fill, consider the starting pixel, plus any pixels connected
// 4-directionally to the starting pixel of the same color as the starting pixel, plus
// any pixels connected 4-directionally to those pixels (also with the same color), and so on.
// Replace the color of all of the aforementioned pixels with color.
//Return the modified image after performing the flood fill.

import java.util.*;
public class FloodFill {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //BFS
        // time complexity is O(m*n)
        //space complexity is O(m*n)
        Queue<Integer> q = new LinkedList<>();
        List<int[]> l = Arrays.asList(new int[]{1,0},new int[]{0,1},new int[]{-1,0},new int[]{0,-1});
        int a = image[sr][sc];
        if(a == color)
            return image;
        q.offer(sr);
        q.offer(sc);
        while(!q.isEmpty()){
            int i = q.poll();
            int j = q.poll();
            image[i][j] = color;
            for(int[] direction : l){
                int b = i + direction[0];
                int c = j + direction[1];
                if(b < 0 || c < 0 || b >= image.length || c >= image[0].length || image[b][c] != a)
                    continue;
                q.offer(b);
                q.offer(c);
            }
        }
        return image;
    }


/*

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
    //DFS
    // time complexity is O(m*n)
        //space complexity is O(m*n)
        Stack<Integer> s = new Stack<>();
        List<int[]> l = Arrays.asList(new int[]{1,0},new int[]{0,1},new int[]{-1,0},new int[]{0,-1});
        int a = image[sr][sc];
        if(a == color)
            return image;
        s.push(sr);
        s.push(sc);
        while(!s.empty()){
            int j = s.pop();
            int i = s.pop();
            image[i][j] = color;
            for(int[] direction : l){
                int b = i + direction[0];
                int c = j + direction[1];
                if(b < 0 || c < 0 || b >= image.length || c >= image[0].length || image[b][c] != a)
                    continue;
                s.push(b);
                s.push(c);
            }
        }
        return image;
    }*/

    public static void main(String[] args) {
   int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
   image = floodFill(image,1,1,2);
   for(int[] x : image){
       for(int y: x){
           System.out.print(y);
       }
   }
    }
}
