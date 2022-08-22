//You are given an m x n grid rooms initialized with these three possible values.

//-1 A wall or an obstacle.
//0 A gate.
//INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
//Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

// if diagonal steps is ok

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
   /* public static void wallsAndGates(int[][] rooms) {
   // time complexity of this method is O(numbers of walls * total grid size)
   // space complexity is O(size of grid)
        Queue<Integer> q = new LinkedList();
        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                if(rooms[i][j] == 0){
                    q.offer(i);
                    q.offer(j);
                }
            }
        }
        int steps = 0;
        while(q.size() != 0){
            steps = 0;
            Queue<Integer> q1 = new LinkedList();
            int[][] c = new int[rooms.length][rooms[0].length];
            int i = q.poll();
            int j = q.poll();
            q1.offer(i);
            q1.offer(j);
            c[i][j] = -1;
            while(q1.size() != 0){
                steps++;
                int size = q1.size();
                for(int k = 0; k < size; k+=2){
                    i = q1.poll();
                    j = q1.poll();
                    if(j + 1 < rooms[0].length && rooms[i][j+1] != -1 && rooms[i][j+1] != 0 && c[i][j+1] != -1){
                        rooms[i][j+1] = Math.min(steps,rooms[i][j+1]);
                        q1.offer(i);
                        q1.offer(j+1);
                        c[i][j+1] = -1;
                    }
                    if(i + 1 < rooms.length && rooms[i+1][j] != -1 && rooms[i+1][j] != 0 && c[i+1][j] != -1){
                        rooms[i+1][j] = Math.min(steps,rooms[i+1][j]);
                        q1.offer(i+1);
                        q1.offer(j);
                        c[i+1][j] = -1;
                    }
                    if(j - 1 >= 0 && rooms[i][j-1] != -1 && rooms[i][j-1] != 0 && c[i][j-1] != -1){
                        rooms[i][j-1] =  Math.min(steps,rooms[i][j-1]);
                        q1.offer(i);
                        q1.offer(j-1);
                        c[i][j-1] = -1;}

                    if(i - 1 >= 0 && rooms[i-1][j] != -1 && rooms[i-1][j] != 0 && c[i-1][j] != -1){
                        rooms[i-1][j] =  Math.min(steps,rooms[i-1][j]);
                        q1.offer(i-1);
                        q1.offer(j);
                        c[i-1][j] = -1;
                    }
                }
            }

        }
    }*/
   public  static void wallsAndGates(int[][] rooms) {
       // time complexity is O(size of grid)
       // space complexity is O(n);
       int max = 2147483647;
       Queue<Integer> q1 = new LinkedList<>();
       for(int i = 0; i < rooms.length; i++){
           for(int j = 0; j < rooms[0].length; j++){
               if(rooms[i][j] == 0){
               q1.add(i);
               q1.add(j);}
           }
       }
       int steps = 0;
       while(!q1.isEmpty() == true){
           int s = q1.size()/2;
           steps++;
           for(int h = 0; h < s; h++){
              int i = q1.poll();
              int j = q1.poll();
               if(j + 1 < rooms[0].length && rooms[i][j+1] == max){
                   rooms[i][j+1] = steps;
                   q1.offer(i);
                   q1.offer(j+1);
               }
               if(i + 1 < rooms.length && rooms[i+1][j] == max){
                   rooms[i+1][j] = steps;
                   q1.offer(i+1);
                   q1.offer(j);
               }
               if(j - 1 >= 0 && rooms[i][j-1] == max){
                   rooms[i][j-1] =  steps;
                   q1.offer(i);
                   q1.offer(j-1);}

               if(i - 1 >= 0 && rooms[i-1][j] == max){
                   rooms[i-1][j] =  steps;
                   q1.offer(i-1);
                   q1.offer(j);
               }
           }
       }
   }
    public static void main(String[] args) {
        int[][] a = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        wallsAndGates(a);
        for(int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++)
                System.out.print(a[i][j]);
            System.out.println();
        }
    }
}
