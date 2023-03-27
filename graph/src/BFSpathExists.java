import java.util.*;
//There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive).
// The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi]
// denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge,
// and no vertex has an edge to itself.
//You want to determine if there is a valid path that exists from vertex source to vertex destination.
//Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination,
// or false otherwise.
public class BFSpathExists {
        public boolean validPath(int n, int[][] edges, int source, int destination) {
            if(source == destination)
                return true;
            HashMap<Integer,ArrayList> h = new HashMap<>();
            for(int[] e:edges){
                h.putIfAbsent(e[0],new ArrayList<>());
                h.putIfAbsent(e[1],new ArrayList<>());
                h.get(e[0]).add(e[1]);
                h.get(e[1]).add(e[0]);
            }
            Queue<Integer> q = new LinkedList<>();
            int[] visited = new int[n];
            q.add(source);
            while(!q.isEmpty()){
                int a = q.poll();
                ArrayList<Integer> b = h.get(a);
                for(int i:b){
                    if(visited[i]==0){
                        if(i==destination)
                            return true;
                        q.offer(i);
                        visited[i]=1;
                    }
                }
            }
            return false;
        }
}
