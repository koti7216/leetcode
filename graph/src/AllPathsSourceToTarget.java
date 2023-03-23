import java.util.*;
//Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1,
// find all possible paths from node 0 to node n - 1 and return them in any order.
//
//The graph is given as follows: graph[i] is a list of all nodes you can visit from node i
// (i.e., there is a directed edge from node i to node graph[i][j]).
public class AllPathsSourceToTarget {
        final Deque<Integer> path = new ArrayDeque<>();
        final List<List<Integer>> paths = new ArrayList<>();
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            if (graph == null || graph.length == 0) {
                return paths;
            }

            dfs(graph, 0);
            return paths;
        }

        void dfs(int[][] graph, int node) {
            path.addLast(node);
            if (node == graph.length - 1) {
                paths.add(new ArrayList<>(path));
                return;
            }
            for (int nextNode: graph[node]) {
                dfs(graph, nextNode);
                path.removeLast();
            }
        }
    }

