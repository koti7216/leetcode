public class FlattenLinkedList {
//You are given a doubly linked list, which contains nodes that have a next pointer, a previous pointer, and an additional child pointer. This child pointer may or may not point to a separate doubly linked list, also containing these special nodes. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure as shown in the example below.

//Given the head of the first level of the list, flatten the list so that all the nodes appear in a single-level, doubly linked list. Let curr be a node with a child list. The nodes in the child list should appear after curr and before curr.next in the flattened list.

    //Return the head of the flattened list. The nodes in the list must have all of their child pointers set to null.
        public static Node flatten(Node head) {
            //Time complexity is O(n) where N is total nodes in the LinkedList
            // space complexity is O(1)
            Node cur = head;
            Node temp = head;
            Node temp3 = head;
            while(cur != null){
                if(cur.child != null){
                    temp = cur.next;
                    Node temp1 = cur.child;
                    while(temp1.next != null){
                        temp1 = temp1.next;
                    }
                    temp3 = cur.child;
                    cur.child = null;
                    cur.next = temp3;
                    temp3.prev = cur;
                    if(temp != null){
                        temp1.next = temp;
                        temp.prev = temp1;}
                }
                cur = cur.next;
            }
            return head;
        }
    public static void main(String[] args){
        Node head1 = new Node(0);
        head1.next = new Node(1);
        head1.next.child = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.child = new Node(4);
        head1.next.next.child.next = new Node(5);
        head1.next.next.next = new Node(6);
        head1.next.next.next.next = new Node(7);
        Node result = flatten(head1);
        while(result!=null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
