public class OddEvenList {
    //Given the head of a singly linked list, group all the nodes with odd indices together
    // followed by the nodes with even indices, and return the reordered list.
    //The first node is considered odd, and the second node is even, and so on.
        public static ListNode oddEvenList(ListNode head) {
            // time complexity O(n) and space complexity is O(1)
            if(head == null || head.next == null)
                return head;
            ListNode temp = head.next;
            ListNode odd = head;
            ListNode even = head.next;
            while(odd.next != null && even.next != null){
                odd.next = even.next;
                even.next = odd.next.next;
                odd = odd.next;
                even = even.next;
            }
            odd.next = temp;
            return head;
        }
        public static void main(String[] args){
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            head.next.next.next.next = new ListNode(5);
            head.next.next.next.next.next = new ListNode(6);
            ListNode result = oddEvenList(head);
            while(result != null){
                System.out.println(result.val);
                result = result.next;
            }

        }
    }

