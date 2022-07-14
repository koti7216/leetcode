//Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
//A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
//If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.


public class MyLinkedList{
    ListNode head;
    int size;
    public MyLinkedList() {
        head = new ListNode(0);
        size = 0;
    }

    public int get(int index) {
        if(index < 0 || index >= size)
            return -1;
        ListNode currentnode = head.next;
        for(int i = 0; i < index; i++){
            currentnode = currentnode.next;
        }
        return currentnode.val;
    }

    public void addAtHead(int val) {
        ListNode head1 = new ListNode(val);
        head1.next = head.next;
        head.next = head1;
        size++;
    }

    public void addAtTail(int val) {
        ListNode tail1 = new ListNode(val);
        ListNode currentNode = head;
        while(currentNode.next != null){
            currentNode = currentNode.next;}
        currentNode.next = tail1;
        size++;
    }


    public  void addAtIndex(int index, int val) {
        if(index > size) return;
        ListNode AddValue = new ListNode(val);
        ListNode currentNode = head;
        for(int i = 0; i < index; i++){
            currentNode = currentNode.next;
        }
        AddValue.next = currentNode.next;
        currentNode.next = AddValue;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode currentNode = head;
        for(int i = 0; i < index; i++){
            currentNode = currentNode.next;
        }
        currentNode.next = currentNode.next.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */