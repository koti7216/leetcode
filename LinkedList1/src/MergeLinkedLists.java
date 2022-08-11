public class MergeLinkedLists {
    //You are given the heads of two sorted linked lists list1 and list2.

//Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

    //Return the head of the merged linked list.
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // time complexity is O(m+n) where m and n is length
        // space complexity is O(1)
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        ListNode temp;
        if (cur1 == null)
            return cur2;
        if (cur2 == null)
            return cur1;
        if (cur1.val <= cur2.val) {
            temp = cur1;
            cur1 = cur1.next;
        } else {
            temp = cur2;
            cur2 = cur2.next;
        }
        ListNode head = temp;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                temp.next = cur1;
                temp = cur1;
                cur1 = cur1.next;
            } else {
                temp.next = cur2;
                temp = cur2;
                cur2 = cur2.next;
            }
        }
        if (cur1 != null) {
            temp.next = cur1;
        }
        if (cur2 != null) {
            temp.next = cur2;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(0);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(5);
        head1.next.next.next.next = new ListNode(7);
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        ListNode cur = mergeTwoLists(head1, head);
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

}