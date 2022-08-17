public class DoubleLinkedListMain {
    public static void main(String[] args){
        DoubleLinkedList list = new DoubleLinkedList();
        list.addAtHead(1);
        list.addAtTail(2);
        list.addAtHead(0);
        list.addAtIndex(3,3);
        list.deleteAtIndex(3);
        for(int i = 0; i < list.size; i++)
            System.out.println(list.get(i));
    }
}
