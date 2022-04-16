package test.test3;

public class DoublyLinkedListNode {
    DoublyLinkedListNode prev;
    DoublyLinkedListNode next;
    int key;
    int value;

    public DoublyLinkedListNode() {
    }

    public DoublyLinkedListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
