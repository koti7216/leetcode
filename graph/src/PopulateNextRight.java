import java.util.*;
//You are given a perfect binary tree where all leaves are on the same level, and every parent has two children.
// The binary tree has the following definition:
//
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//}
//Populate each next pointer to point to its next right node. If there is no next right node,
// the next pointer should be set to NULL.
//
//Initially, all next pointers are set to NULL.
public class PopulateNextRight {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
            if(root == null)
                return null;
            Queue<Node> q = new LinkedList<>();
            q.offer(root);
            while(!q.isEmpty()){
                int s = q.size();
                for(int i=0;i<s;i++){
                    Node a = q.poll();
                    if(i<s-1)
                        a.next = q.peek();
                    if(a.left !=null){
                        q.offer(a.left);
                        q.offer(a.right);}
                }

            }
            return root;
        }
}
