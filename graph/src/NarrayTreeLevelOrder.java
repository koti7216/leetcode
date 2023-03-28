import java.util.*;
//Given an n-ary tree, return the level order traversal of its nodes' values.
//
//Nary-Tree input serialization is represented in their level order traversal,
// each group of children is separated by the null value (See examples)
public class NarrayTreeLevelOrder {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            Queue<Node> q = new LinkedList<>();
            q.offer(root);
            List<List<Integer>> result = new ArrayList<>();
            if(root==null)
                return result;
            List<Integer> l = new ArrayList<>();
            l.add(root.val);
            result.add(l);
            while(!q.isEmpty()){
                l = new ArrayList<>();
                int s = q.size();
                for(int i=0;i<s;i++){
                    Node n = q.poll();
                    for(Node j:n.children){
                        q.add(j);
                        l.add(j.val);
                    }
                }
                if(l.size()!=0)
                    result.add(l);
            }
            return result;
        }
    }
}
