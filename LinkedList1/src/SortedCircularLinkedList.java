public class SortedCircularLinkedList {
    //Given a Circular Linked List node, which is sorted in ascending order,
    // write a function to insert a value insertVal into the list such that it remains a sorted circular list.
    // The given node can be a reference to any single node in the list and may not necessarily be the smallest
    // value in the circular list.
//If there are multiple suitable places for insertion, you may choose any place to insert the new value.
// After the insertion, the circular list should remain sorted.
    //If the list is empty (i.e., the given node is null), you should create a new single circular list
    // and return the reference to that single node. Otherwise, you should return the originally given node.
        public static Node insert(Node head, int insertVal) {
            // time complexity is O(n) and space complexity is O(1)
            Node cur = head;
            Node ans = new Node(insertVal);
            if(head == null){
                ans.next = ans;
                return ans;
            }
            while(cur.next != head && cur.val <= cur.next.val){
                cur = cur.next;}
            if(cur.next == head && cur.val == head.val){
                cur.next = ans;
                ans.next = head;
                return head;
            }
            if((insertVal >= cur.val) || (insertVal <= cur.next.val)){
                ans.next = cur.next;
                cur.next = ans;
                return head;
            }

            cur = cur.next;
            while(cur.val<=cur.next.val){
                if(cur.val <= insertVal && insertVal <= cur.next.val){
                    ans.next = cur.next;
                    cur.next = ans;
                    return head;
                }
                cur = cur.next;
            }
            return head;
        }

    public static void main(String[] args) {
            int t = 0;
        Node head1 = new Node(0);
        head1.next = new Node(1);
        head1.next.next = new Node(2);
        head1.next.next.next = new Node(3);
        head1.next.next.next.next = new Node(4);
        head1.next.next.next.next.next = head1;
        Node cur = insert(head1,3);
        while(t != 6){
            System.out.println(cur.val);
            cur = cur.next;
            t++;
        }
    }
    }

