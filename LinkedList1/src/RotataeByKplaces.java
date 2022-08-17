public class RotataeByKplaces {
    //Given the head of a linked list, rotate the list to the right by k places.
        /*public static ListNode rotateRight(ListNode head, int k) {
            // O(N) time complexity and space complexity is O(1)
            if(head == null || head.next == null)
                return head;
            ListNode cur = head;
            ListNode head1 = head;
            int length = 0;
            while(cur != null){
                cur = cur.next;
                length++;
            }
            while(k>length){
                k = k%length;
            }
            if(k == length)
                return head;
            if(k < length)
            {
                head1 = reverseList(head,length);
                head = reverseList(head1,k);
                ListNode temp = reverseList(head1.next,length-k);
                head1.next = temp;
            }
            return head;
        }
        public static ListNode reverseList(ListNode head,int k) {
            if(head == null){ // return null if there is no nodes
                return head;
            }
            else{
                ListNode cur = head;
                ListNode temp = head.next;

                while(k != 1 && head != null  && cur.next!=null){
                    cur.next = temp.next;
                    temp.next = head;
                    head = temp;
                    temp = cur.next;
                    k--;
                }
            }
            return head;
        }*/
    public static ListNode rotateRight(ListNode head, int k){
        if(head == null)
            return head;
        ListNode cur = head;
        int length = 1;
        while(cur.next != null){
            cur = cur.next;
            length++;
        }
        while(k > length)
            k = k % length;
        if(k == length)
            return head;
        else{
            ListNode temp = head;
            for(int i = 1; i < length-k; i++)
                temp = temp.next;
            cur.next = head;
            head = temp.next;
            temp.next = null;
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1) ;
        head.next = new ListNode(2) ;
        head.next.next = new ListNode(3) ;
        head.next.next.next = new ListNode(4) ;
        head.next.next.next.next = new ListNode(5) ;
        head.next.next.next.next.next = new ListNode(6) ;
        ListNode result = rotateRight(head,2);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
    }


