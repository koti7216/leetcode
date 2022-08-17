public class CycleLinkedList {

//Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
        public static ListNode detectCycle(ListNode head) {
            boolean result = false;
            ListNode currentNode = head;
            ListNode currentNode1 = head;
            int t = 0;
            if(head == null || head.next == null)
                return null;
            else{
                while((currentNode != currentNode1 || t == 0) && (currentNode1 != null && currentNode1.next != null)){
                    currentNode = currentNode.next;
                    currentNode1 = currentNode1.next.next;
                    if(currentNode == currentNode1){
                        result = true;
                    }
                    if(currentNode1 == null || currentNode1.next == null)
                        result = false;
                    t++;
                }
            }
            if(result == false){
                return null;
            }
            else{
                while(head != currentNode){
                    head = head.next;
                    currentNode = currentNode.next;

                }
            }
            return head;
        }
        public static void main(String[] args){
            ListNode head = new ListNode(1);
             head.next = new ListNode(2);
             head.next.next = new ListNode(3);
             head.next.next.next = head;
             ListNode result = detectCycle(head);
             System.out.print(result.val);
        }
    }

