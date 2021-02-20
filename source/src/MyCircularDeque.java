public class MyCircularDeque {
    // 1、不用设计成动态数组，使用静态数组即可
    // 2、设计 head 和 tail 指针变量
    // 3、head == tail 成立的时候表示队列为空
    // 4、tail + 1 == head

    private int capacity;
    private int[] arr;
    private int front;
    private int rear;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        capacity = k + 1;
        arr = new int[capacity];
        front = 0;
        rear = 0;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        front = (front - 1 + capacity) % capacity;
        arr[front] = value;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) return false;
        arr[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        if (rear> 0) {
            rear = (rear - 1) % capacity;
        } else {
            rear = capacity - 1;
        }
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (isEmpty()) return -1;
        return arr[front];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (isEmpty()) return -1;
        if (rear > 0) {
            return arr[rear - 1];
        } else {
            return arr[capacity - 1];
        }
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }


    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(8); // 设置容量大小为3
        System.out.println(circularDeque.insertFront(5));                    // 返回 true
        System.out.println(circularDeque.getFront());                    // 返回 true
        System.out.println(circularDeque.isEmpty());                    // 返回 true
        System.out.println(circularDeque.deleteFront());                    // 已经满了，返回 false
        System.out.println(circularDeque.insertLast(3));                // 返回 2
        System.out.println(circularDeque.getRear());                        // 返回 true
//        System.out.println(circularDeque.deleteLast());                    // 返回 true
//        System.out.println(circularDeque.insertFront(4));                    // 返回 true
//        System.out.println(circularDeque.getFront());                // 返回 4

    }
}
