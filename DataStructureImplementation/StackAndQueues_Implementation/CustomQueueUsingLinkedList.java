package DataStructureImplementation.StackAndQueues_Implementation;

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}
public class CustomQueueUsingLinkedList<T> {
    Node<T> front;
    Node<T> rear;
    int size;
    public CustomQueueUsingLinkedList() {
        front = rear = null;
        size = 0;
    }
    public void add(T val) {
        Node<T> newNode = new Node<>(val);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }
    public void remove() {
        if (front == null) {
            System.out.println("Underflow");
            return;
        }
        Node<T> temp = front;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
    }
    public int size() {
        return size;
    }
    public void display() {
        Node<T> temp = front;
        System.out.print("Queue elements: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public boolean search(T val) {
        Node<T> temp = front;
        while (temp != null) {
            if (temp.data.equals(val)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public T peek() {
        if (front == null) {
            System.out.println("Queue is empty");
            return null;
        }
        return front.data;
    }

}
class CustomQueueUsingLinkedListTest {
    public static void main(String[] args) {
        CustomQueueUsingLinkedList<Integer> queue = new CustomQueueUsingLinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.display();
        System.out.println("Size: " + queue.size());
        queue.remove();
        queue.display();
        System.out.println("Size: " + queue.size());
        System.out.println("Peek: " + queue.peek());
        System.out.println("Search 2: " + queue.search(2));
        System.out.println("Search 3: " + queue.search(3));
    }
}