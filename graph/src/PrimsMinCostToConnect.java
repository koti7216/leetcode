import java.util.*;
//You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].
//
//The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.
//
//Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.
public class PrimsMinCostToConnect {
    class Solution {
        public int minCostConnectPoints(int[][] points) {
            int s = points.length;
            int[][] a = new int[s][s];
            for(int i = 0; i < s; i++){
                for(int j = i+1; j < s;j++){
                    a[i][j]=(Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]));
                    a[j][i]=a[i][j];
                }
            }
            ArrayList<Integer> d = new ArrayList<>();
            d.add(0);
            int[] d1 = new int[s];
            d1[0]=1;
            int t = 1;
            int result = 0;
            while(t<s){
                int min = Integer.MAX_VALUE;
                int k = 0;
                for(int i : d){
                    for(int j=0; j<s;j++){
                        if(d1[j]!=1){
                            if(a[i][j]<min){
                                min = a[i][j];
                                k = j;
                            }
                        }
                    }
                }
                d.add(k);
                d1[k]=1;
                result+=min;
                t++;
            }
            return result;
        }

    }
}
