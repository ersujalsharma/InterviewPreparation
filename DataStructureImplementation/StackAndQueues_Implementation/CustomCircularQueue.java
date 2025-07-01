package DataStructureImplementation.StackAndQueues_Implementation;

import java.util.Arrays;

public class CustomCircularQueue<T> {
    public T array[];
    public int front;
    public int rear;
    public int size;
    public CustomCircularQueue() {
        array = (T[]) new Object[2];
        front = rear = -1;
        size = 0;
    }
    public void add(T val) {
        if ((rear + 1) % array.length == front) {
            System.out.println("Overflow");
            return;
        }
        if (front == -1) {
            front = 0;
        }
        rear = (rear + 1) % array.length;
        array[rear] = val;
        size++;
    }
    public void remove() {
        if (front == -1) {
            System.out.println("Underflow");
            return;
        }
        array[front] = null;
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % array.length;
        }
        size--;
    }
    public int size() {
        return size;
    }
    public void display() {
        System.out.println("Queue elements:");
        System.out.println(Arrays.toString(array));
    }
}
class CustomCircularQueueTest{
    public static void main(String[] args) {
        CustomCircularQueue<Integer> queue = new CustomCircularQueue<>();
        queue.add(1);
        queue.add(2);
        queue.display();
        queue.remove();
        queue.display();
        queue.add(3);
        queue.display();
        queue.remove();
        queue.display();
        queue.remove();
        queue.display();
        queue.remove(); // This should print "Underflow"
        System.out.println(queue.size());
    }
}  