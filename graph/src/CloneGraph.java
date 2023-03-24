import java.util.*;
//Given a reference of a node in a connected undirected graph.
//
//Return a deep copy (clone) of the graph.
//
//Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

public class CloneGraph {

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


    class Solution {
        HashMap<Node,Node> h = new HashMap<>();
        public Node cloneGraph(Node node) {
            if(node == null)
                return null;
            if(h.containsKey(node))
                return h.get(node);

            Node cn = new Node(node.val,new ArrayList<>());
            h.put(node,cn);
            for(Node n:node.neighbors){
                cn.neighbors.add(cloneGraph(n));}

            return cn;
        }
    }
}
