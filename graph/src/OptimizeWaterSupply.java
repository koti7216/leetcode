import java.util.*;
//There are n houses in a village. We want to supply water for all the houses by building wells and laying pipes.
//
//For each house i, we can either build a well inside it directly with cost wells[i - 1] (note the -1 due to 0-indexing),
// or pipe in water from another well to it. The costs to lay pipes between houses are given by the array pipes
// where each pipes[j] = [house1j, house2j, costj] represents the cost to connect house1j and house2j together using a pipe.
// Connections are bidirectional, and there could be multiple valid connections between the same two houses with different costs.
//
//Return the minimum total cost to supply water to all houses.
public class OptimizeWaterSupply {
        public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
            int result = 0;
            ArrayList<int[]> a = new ArrayList<>();
            UnionFind uf = new UnionFind(n+1);
            for(int i=0;i<wells.length;i++){
                int[] b = {0,i+1,wells[i]};
                a.add(b);
            }
            for(int i = 0; i <pipes.length;i++){
                a.add(pipes[i]);
            }
            Collections.sort(a,Comparator.comparing((o)->o[2]));
            for(int i=0;i<a.size();i++){
                int h1 = a.get(i)[0];
                int h2 = a.get(i)[1];
                int v = a.get(i)[2];
                if(uf.union(h1,h2))
                    result+=v;
            }
            return result;
        }
        class UnionFind{
            private int[] root;
            private int[] rank;
            UnionFind(int s){
                root = new int[s];
                rank = new int[s];
                for(int i = 0;i<s;i++){
                    root[i] = i;
                    rank[i] = 1;
                }
            }
            public int find(int x){
                if(root[x]==x){
                    return x;
                }
                else{
                    return root[x] = find(root[x]);
                }
            }
            public boolean union(int x,int y){
                int rx = find(x);
                int ry = find(y);
                if(rx == ry)
                    return false;
                else {
                    if(rank[rx]>rank[ry]){
                        root[ry] = rx;
                    }
                    else if(rank[ry]>rank[rx]){
                        root[rx] = ry;
                    }
                    else{
                        root[ry] = rx;
                        rank[rx]++;
                    }
                    return true;
                }
            }
        }
    }

