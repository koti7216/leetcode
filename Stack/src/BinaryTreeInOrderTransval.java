import java.util.*;
//Given the root of a binary tree, return the inorder traversal of its nodes' values.
public class BinaryTreeInOrderTransval {
        public static List<Integer> inorderTraversal(TreeNode root) {
            // time complexity is O(n) n is number of nodes in the tree
            // space complexity is O(n)
            List<Integer> l = new ArrayList<>();
            Stack<TreeNode> s = new Stack<>();
            while(root != null || s.size() != 0){
                if(root != null){
                    s.add(root);
                    root = root.left;
                }
                else{
                    root = s.pop();
                    l.add(root.val);
                    root = root.right;
                }
            }
            return l;
        }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        System.out.println(inorderTraversal(root));
    }
}
