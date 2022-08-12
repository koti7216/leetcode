public class AddTwoNumbers {
    //You are given two non-empty linked lists representing two non-negative integers.
    // The digits are stored in reverse order, and each of their nodes contains a single digit.
    // Add the two numbers and return the sum as a linked list.
    //You may assume the two numbers do not contain any leading zero, except the number 0 itself.
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            //time complexity is O(n) where n is max(lengths of l1 and l2)
            // space complexity is O(1)
            int a = 0;
            int b = 0;
            int carry = 0;
            int sum = 0;
            if(l1 == null)
                return l2;
            if(l2 == null)
                return l1;
            sum = l1.val + l2.val;
            carry = sum/10;
            sum = sum % 10;
           ListNode  head = new ListNode(sum);
            ListNode head1 = head;
            l1 = l1.next;
            l2 = l2.next;
            while(l1 != null || l2 != null){
                if(l1 == null)
                    a = 0;
                else
                    a = l1.val;
                if(l2 == null)
                    b = 0;
                else
                    b = l2.val;
                sum = a + b + carry;
                carry = sum / 10;
                sum = sum % 10;
                head1.next= new ListNode(sum);
                head1 = head1.next;
                if(l1 != null)
                    l1 = l1.next;
                if(l2 != null)
                    l2 = l2.next;
            }
            if(carry != 0)
                head1.next = new ListNode(carry);
            return head;
        }
        public static void main(String[] args){
            ListNode head1 = new ListNode(9);
            head1.next = new ListNode(9);
            head1.next.next = new ListNode(9);
            head1.next.next.next = new ListNode(9);
            head1.next.next.next.next = new ListNode(9);
            ListNode head = new ListNode(1);
            head.next = new ListNode(0);
            head.next.next = new ListNode(0);
            head.next.next.next = new ListNode(1);
            ListNode result = addTwoNumbers(head1,head);
            while(result != null){
                System.out.print(result.val); // numbers in reverse order so 99999 + 1001 = 101000 in reverse is 000101 is output
                result = result.next;}

        }
}
