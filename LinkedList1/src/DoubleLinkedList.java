public class DoubleLinkedList {
    //Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
//A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
//If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

        ListNode head,tail;
        int size;
        public DoubleLinkedList() {
            head = new ListNode(0);
            tail = new ListNode(0);
            head.next = tail;
            tail.prev = head;
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
            ListNode curr = head.next;
            head1.prev = head;
            head1.next = curr;
            head.next = head1;
            curr.prev = head1;
            size++;

        }

        public void addAtTail(int val) {
            ListNode tail1 = new ListNode(val);
            ListNode currentNode = tail.prev;
            currentNode.next = tail1;
            tail1.prev = currentNode;
            tail1.next = tail;
            tail.prev = tail1;
            size++;
        }


        public void addAtIndex(int index, int val) {
            if(index > size) return;
            ListNode AddValue = new ListNode(val);
            ListNode currentNode = head;
            for(int i = 0; i < index; i++){
                currentNode = currentNode.next;
            }
            ListNode curr = currentNode.next;
            AddValue.next = curr;
            currentNode.next = AddValue;
            AddValue.prev = currentNode;
            curr.prev = AddValue;
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
            ListNode curr = currentNode.next.next;
            currentNode.next = curr;
            curr.prev = currentNode;
            size--;
        }
    }

