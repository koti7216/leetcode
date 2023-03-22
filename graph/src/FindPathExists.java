import java.util.*;
//There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive).
// The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes
// a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge,
// and no vertex has an edge to itself.
//
//You want to determine if there is a valid path that exists from vertex source to vertex destination.
//
//Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination,
// or false otherwise.
public class FindPathExists {
        public boolean validPath(int n, int[][] edges, int source, int destination) {
            HashMap<Integer,ArrayList<Integer>> h = new HashMap<>();
            for(int[] i:edges){
                h.putIfAbsent(i[0],new ArrayList<Integer>());
                h.get(i[0]).add(i[1]);
                h.putIfAbsent(i[1],new ArrayList<Integer>());
                h.get(i[1]).add(i[0]);
            }
            Stack<Integer> s = new Stack<>();
            HashMap<Integer,Integer> h1 = new HashMap<>();
            s.push(source);
            while(!s.empty()){

                int b = s.pop();
                if(b == destination)
                    return true;
                if(!h1.containsKey(b)){
                    ArrayList<Integer> a = h.get(b);
                    for(int j:a){
                        s.push(j);
                    }
                    h1.put(b,1);
                }

            }
            return false;
        }
    }

