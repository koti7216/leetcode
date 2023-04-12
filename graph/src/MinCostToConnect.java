import java.util.*;

public class MinCostToConnect {
    class Solution {
        public int minCostConnectPoints(int[][] points) {
            int s = points.length;
            ArrayList<ArrayList<Integer>> a  = new ArrayList<>();
            for(int i = 0; i < s; i++){
                for(int j = i+1; j < s;j++){
                    ArrayList<Integer> b = new ArrayList<>();
                    b.add(i);
                    b.add(j);
                    b.add(Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]));
                    a.add(b);
                }
            }
            Collections.sort(a,Comparator.comparing((c)->c.get(2)));
            Node n = new Node(s);
            int[] d = new int[s];
            int t4 = 0;
            for(ArrayList<Integer> f: a){
                if(!n.connected(f.get(0), f.get(1))){
                    int t1 = d[n.find(f.get(0))];
                    int t2 = d[n.find(f.get(1))];
                    n.union(f.get(0),f.get(1));
                    d[n.find(f.get(0))] = t1+t2+f.get(2);
                    t4++;
                    if(t4 == s-1)
                        break;
                }
            }
            return d[n.find(0)];
        }
        class Node{
            private int[] node;
            private int[] rank;

            Node(int s){
                node = new int[s];
                rank = new int[s];
                for(int i = 0; i < s;i++){
                    node[i]=i;
                    rank[i]=1;
                }
            }
            public int find(int x){
                if(node[x]!=x){
                    return node[x]=find(node[x]);
                }
                else
                    return x;
            }
            public void union(int x,int y){
                int rx = find(x);
                int ry = find(y);
                if(rx != ry){
                    if(rank[rx]>rank[ry]){
                        node[ry]=rx;
                    }
                    else if(rank[rx]<rank[ry])
                        node[rx]=ry;
                    else{
                        node[rx]=ry;
                        rank[ry]++;
                    }
                }
            }
            public boolean connected(int x, int y){
                if(find(x)==find(y))
                    return true;
                else
                    return false;
            }
        }
    }
}
