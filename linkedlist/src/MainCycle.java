public class MainCycle {

        public static void main(String[] args){
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = head;

            LinkedListCycle result = new LinkedListCycle();

            System.out.print(result.hasCycle(head));

        }
    }


