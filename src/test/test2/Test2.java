package test.test2;

public class Test2 {
    private Object[] array;
    private volatile int topIndex = -1;

    public Test2(int length) {
        array = new Object[length];
    }

    public synchronized void push(Object obj) {
        if (topIndex == (array.length - 1)) {
            System.out.println("Stack is full ");
            return;
        }
        array[++topIndex] = obj;
    }

    public synchronized Object peek() {
        if (topIndex == -1) {
            System.out.println("Stack is empty ");
            return null;
        } else {
            return array[array.length - 1];
        }

    }

    public synchronized Object pop() {
        if (topIndex == -1) {
            System.out.println("Stack is empty ");
            return null;
        }
        Object topObject = array[topIndex];
        array[topIndex] = null;
        topIndex--;
        return topObject;
    }

    public synchronized boolean empty() {
        int size = array.length;
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        return true;
    }


    public static void main(String[] args) {
        Test2 test2 = new Test2(2);
        System.out.println( test2.pop());
        System.out.println(test2.peek());
        test2.push(1);
        test2.push(2);
        System.out.println( test2.pop());
        System.out.println(test2.peek());
    }
}
