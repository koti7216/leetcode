public class ReverseList {
    //Given the head of a singly linked list, reverse the list, and return the reversed list.
        public static ListNode reverseList(ListNode head) { // time complexity O(n) n is length of linked list
            // space complexity is O(1)
            if(head == null){ // return null if there is no nodes
                return null;
            }
            else{
                ListNode cur = head;
                ListNode temp = head.next;

                while(head != null  && cur.next!=null){
                    cur.next = temp.next;
                    temp.next = head;
                    head = temp;
                    temp = cur.next;
                }
            }
            return head;
        }


        public static void main(String[] args){
            ListNode head1 = new ListNode(0);
            head1.next = new ListNode(1);
            head1.next.next = new ListNode(2);
            head1.next.next.next = new ListNode(3);
            head1.next.next.next.next = new ListNode(4);
            ListNode result = reverseList(head1);
            while(result != null){
                System.out.println(result.val);
                result = result.next;
            }
        }
    }

