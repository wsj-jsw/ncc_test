package test.test3;

import java.util.HashMap;

public class Test3 {
    DoublyLinkedListNode head;
    DoublyLinkedListNode tail;
    HashMap<Integer, DoublyLinkedListNode> map;
    int capacity;
    int size;

    public Test3(int capacity) {
        this.head = new DoublyLinkedListNode();
        this.tail = this.head;
        this.map = new HashMap<>();
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        Test3 lru = new Test3(2);
        lru.put(1, 1);
        System.out.println(lru + ", after put(1,1)");
        lru.put(2, 2);
        System.out.println(lru + ", after put(2,2)");
        lru.get(1);
        System.out.println(lru + ", after get(1)");
        lru.put(3, 3);
        System.out.println(lru + ", after put(3,3)");
        lru.get(2);
        System.out.println(lru + ", after get(2)");
        lru.put(4, 4);
        System.out.println(lru + ", after put(4,4)");
        lru.get(1);
        System.out.println(lru + ", after get(1)");
        lru.get(3);
        System.out.println(lru + ", after get(3)");
        lru.get(4);
        System.out.println(lru + ", after get(4)");
    }


    public int get(int key) {
        DoublyLinkedListNode current = this.map.get(key);
        if (current == null) {
            return -1;
        } else {
            DoublyLinkedListNode save = current;
            this.delete(current);
            this.insert(save);
            return save.value;
        }
    }

    public void put(int key, int value) {
        DoublyLinkedListNode current = this.map.get(key);
        if (current == null) {
            current = new DoublyLinkedListNode(key, value);
            if (this.size == this.capacity) {
                // map.remove 必须在前，因为如果先删除，tail 就改变了
                this.map.remove(this.tail.key);
                this.delete(this.tail);
            }
            this.insert(current);
            this.map.put(key, current);
        }
    }

    @Override
    public String toString() {
        StringBuilder list = new StringBuilder();
        DoublyLinkedListNode current = this.head.next;
        while (current != null) {
            list.append(current.value);
            if (current != this.tail) {
                list.append("->");
            }
            current = current.next;
        }
        return list.toString();
    }

    /**
     * 删除节点
     *
     * @param current
     */
    public void delete(DoublyLinkedListNode current) {
        current.prev.next = current.next;
        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            this.tail = current.prev;
            this.tail.next = null;
        }
        this.size--;
    }

    /**
     * 插入到表头
     *
     * @param current
     */
    public void insert(DoublyLinkedListNode current) {
        current.prev = this.head;
        current.next = this.head.next;
        if (this.head.next == null) {
            this.tail = current;
            this.tail.next = null;
        } else {
            this.head.next.prev = current;
        }
        this.head.next = current;
        this.size++;
    }
}
