import java.util.HashMap;

public class CopyRandomLinkedList {
//A linked list of length n is given such that each node contains an additional random pointer,
// which could point to any node in the list, or null.
//Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes,
// where each new node has its value set to the value of its corresponding original node.
// Both the next and random pointer of the new nodes should point to new nodes in the copied list
// such that the pointers in the original list and copied list represent the same list state.
// None of the pointers in the new list should point to nodes in the original list.
//For example, if there are two nodes X and Y in the original list, where X.random --> Y,
// then for the corresponding two nodes x and y in the copied list, x.random --> y.
    //Return the head of the copied linked list.
       /* public static Node copyRandomList(Node head) { // time complexity is O(n^2) n is length of list
            // space complexity is O(1)
            if(head == null)
                return null;
            Node head1 = new Node(head.val);
            Node cur1 = head1;
            Node cur = head;
            while(cur.next!= null){
                cur1.next = new Node(cur.next.val);
                cur1 = cur1.next;
                cur = cur.next;
            }
            cur1.next = null;
            cur = head;
            cur1 = head1;
            while(cur != null){
                Node temp = head;
                Node temp1 = head1;
                if(cur.random != null){
                    while(cur.random != temp){
                        temp = temp.next;
                        temp1 = temp1.next;
                    }
                    cur1.random = temp1;
                }
                cur = cur.next;
                cur1 = cur1.next;
            }
            return head1;
        }*/
static HashMap<Node,Node> cloned = new HashMap<>();
public static Node getclonedNode(Node node){
    if(node == null) return null;
    if(cloned.containsKey(node) == true){
        return cloned.get(node);
    }
    else{
        Node  clonenode = new Node(node.val);
        cloned.put(node, clonenode);
        return cloned.get(node);
    }
}
public static Node copyRandomList(Node head){ // O(n) time complexity and O(n) space complexity
    if(head == null) return null;
    Node head1 = new Node(head.val);
    cloned.put(head,head1);
    Node cur = head;
    Node cur1 = head1;
    while(cur != null){
        cur1.next = getclonedNode(cur.next);
        cur1.random = getclonedNode(cur.random);
        cur = cur.next;
        cur1 = cur1.next;
    }
    return head1;
}
    public static void main(String[] args){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.random = head.next;
        Node result = copyRandomList(head); // gives head of the copied linked list
        System.out.println("head radnom is :" + result.random.val);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
