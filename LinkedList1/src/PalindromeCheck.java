import java.util.Stack;

public class PalindromeCheck {
    //Given the head of a singly linked list, return true if it is a palindrome.
        public static boolean isPalindrome(ListNode head) { // time complexity is O(n)
            //space complexity is O(n)
            int t = 0;
            boolean result = false;
            ListNode cur = head;
            Stack<Integer> temp = new Stack<>();
            while(cur!=null){
                t++;
                temp.push(cur.val);
                cur = cur.next;
            }
            cur = head;
            while(cur!=null && cur.val == temp.pop()){
                t--;
                cur = cur.next;
            }
            if(t == 0)
                result = true;
            return result;
        }
        public static void main(String[] args){
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(3);
            head.next.next.next.next = new ListNode(2);
            head.next.next.next.next.next = new ListNode(1);
            System.out.println(isPalindrome(head));
        }
    }

