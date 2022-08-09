public class RemoveNthFromEnd {
    //Given the head of a linked list, remove the nth node from the end of the list and return its head.
        public static ListNode removeNthFromEnd(ListNode head, int n) {  // time complexity O(n) and
            // space complexity is O(1)
            ListNode temp = head;
            ListNode result = head;
            int length = 0;
            while(temp.next!=null){
                temp = temp.next;
                length++;
                if(length > n){
                    result = result.next;
                }
            }
            if(length + 1 == n){
                head = head.next;}
            else{
                result.next = result.next.next;}
            return head;
        }
        public static void main(String[] args){
            ListNode head1 = new ListNode(1);
            head1.next = new ListNode(2);
            head1.next.next = new ListNode(3);
            head1.next.next.next = new ListNode(4);
            head1.next.next.next.next = new ListNode(5);
            ListNode result = removeNthFromEnd(head1,1); // removes the last element since n is 1
            while(result != null){
                System.out.println(result.val);
            result = result.next;}
        }
    }

