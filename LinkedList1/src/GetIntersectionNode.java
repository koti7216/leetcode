//Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
// If the two linked lists have no intersection at all, return null.
public class GetIntersectionNode {
        public  static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            // time complexity is O(n) where n is max(a,b) and space complexity is O(1)
            int a = length(headA);
            int b = length(headB);
            ListNode cur = headA;
            ListNode cur1 = headB;
            ListNode result = null;
            int c = 0;
            if(a >= b){
                c = a - b;
                for(int i = 0; i < c; i++){
                    cur = cur.next;
                }
            }
            else{
                c = b - a;
                for(int i = 0; i < c; i++){
                    cur1 = cur1.next;
                }
            }
            if(cur == cur1)
                return cur;
            while(cur != null && cur1 != null && cur != cur1){
                cur = cur.next;
                cur1 = cur1.next;
                if(cur == cur1)
                    result = cur;
            }
            return result;
        }
        public static int length(ListNode head){
            int a = 0;
            ListNode cur = head;
            while(cur != null){
                cur = cur.next;
                a++;
            }
            return a;
        }
        public static void main(String[] args){
            ListNode head1 = new ListNode(0);
            head1.next = new ListNode(2);
            head1.next.next = new ListNode(3);
            head1.next.next.next = new ListNode(4);
            head1.next.next.next.next = new ListNode(5);
            ListNode head2 = new ListNode(1);
            head2.next = head1.next;
            head2.next.next = head1.next.next;
            head2.next.next.next = head1.next.next.next;
            head2.next.next.next.next = head1.next.next.next.next;

            ListNode result = getIntersectionNode(head1,head2);
            System.out.println(result.val); // prints output 2
        }
    }

