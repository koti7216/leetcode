public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        boolean result = false;
        ListNode currentNode = head;
        ListNode currentNode1 = head;
        int t = 0;
        if(head == null || head.next == null)
            return false;
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
        return result;
    }
}

