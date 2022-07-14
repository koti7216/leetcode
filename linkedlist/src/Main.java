public class Main {
    public static void main(String[] args){
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);


        while (myLinkedList.head != null) {
            System.out.println(myLinkedList.head.val);
            myLinkedList.head = myLinkedList.head.next;
        }
    }
}
