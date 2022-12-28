import java.util.*;
//Given a reference of a node in a connected undirected graph.
//Return a deep copy (clone) of the graph.
//Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
public class CloneGraph {
       static  HashMap<Node,Node> h = new HashMap<>();
        public static Node cloneGraph(Node node) {
            if(node == null)
                return null;
            if(h.containsKey(node))
                return h.get(node);

            Node cloneNode = new Node(node.val);
            h.put(node,cloneNode);
            List<Node> l = new ArrayList<>();
            for(Node d: node.neighbors){
                l.add(cloneGraph(d));}
            cloneNode.neighbors = l;
            return cloneNode;
        }

    public static void main(String[] args) {
            Node left = new Node(2);
            Node right = new Node(3);
            ArrayList<Node> l = new ArrayList<>();
            l.add(left);
            l.add(right);
        Node root = new Node(1,l);
        Node result = cloneGraph(root);
        System.out.println(result.val);
    }
}
