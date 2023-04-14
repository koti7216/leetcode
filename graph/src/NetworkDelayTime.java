import java.util.*;
//You are given a network of n nodes, labeled from 1 to n.
// You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node,
// vi is the target node, and wi is the time it takes for a signal to travel from source to target.
//
//We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
public class NetworkDelayTime {
    class Solution {
        public int networkDelayTime(int[][] times, int n, int k) {
            HashMap<Integer,ArrayList<Edges>> h = new HashMap<>();
            for(int[] i:times){
                h.putIfAbsent(i[0],new ArrayList<Edges>());
                h.get(i[0]).add(new Edges(i[1],i[2]));
            }
            int[] a = new int[n+1];
            PriorityQueue<int[]> p = new PriorityQueue<int[]>((w,b)->w[0]-b[0]);
            p.offer(new int[]{0,k});
            int result = 0;
            int g = 0;
            while(!p.isEmpty()){
                int[] edge = p.poll();
                int dis = edge[0];
                int node = edge[1];
                if(a[node]==1)
                    continue;
                a[node]=1;
                g++;
                result = Math.max(result,dis);
                if(h.containsKey(node)){
                    for(Edges f:h.get(node)){
                        if(a[f.s]!=1)
                            p.offer(new int[]{f.cost+dis,f.s});
                    }
                }
            }
            if(g==n)
                return result;
            else
                return -1;
        }
        class Edges{
            private int s;
            private int cost;
            Edges(int s,int cost){
                this.s = s;
                this.cost=cost;
            }
        }
    }
}
