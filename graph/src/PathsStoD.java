import java.util.*;
//Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1,
// find all possible paths from node 0 to node n - 1 and return them in any order.
//
//The graph is given as follows: graph[i] is a list of all nodes you can visit from node i
// (i.e., there is a directed edge from node i to node graph[i][j]).
public class PathsStoD {
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            List<List<Integer>> paths = new ArrayList<>();
            if (graph == null || graph.length == 0) {
                return paths;
            }
            Queue<List<Integer>> queue = new LinkedList<>();
            List<Integer> path = new ArrayList<>();
            path.add(0);
            queue.add(path);
            while (!queue.isEmpty()) {
                List<Integer> currentPath = queue.poll();
                int node = currentPath.get(currentPath.size() - 1);
                for (int nextNode: graph[node]) {
                    List<Integer> tmpPath = new ArrayList<>(currentPath);
                    tmpPath.add(nextNode);
                    if (nextNode == graph.length - 1) {
                        paths.add(new ArrayList<>(tmpPath));
                    } else {
                        queue.add(new ArrayList<>(tmpPath));
                    }
                }
            }
            return paths;
        }
}
