public class RemoveElements {
    //Given the head of a linked list and an integer val, remove all the nodes of the linked list
    // that has Node.val == val, and return the new head.

        public static ListNode removeElements(ListNode head, int val) { // time complexity O(n) and
            //space complexity O(1)
            while(head != null && head.val == val){
                head = head.next;
            }
            ListNode cur = head;
            while(cur != null && cur.next != null){
                if(cur.next.val == val){
                    cur.next = cur.next.next;
                }
                else{
                    cur = cur.next;}
            }
            return head;
        }
        public static void main(String[] args){
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(2);
            head.next.next.next = new ListNode(4);
            head.next.next.next.next = new ListNode(5);
            ListNode cur = removeElements(head,2);
            while(cur!=null){
                System.out.println(cur.val);
            cur = cur.next;}
        }
    }

