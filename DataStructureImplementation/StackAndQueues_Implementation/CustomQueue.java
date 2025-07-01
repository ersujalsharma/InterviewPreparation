package DataStructureImplementation.StackAndQueues_Implementation;

import java.util.Arrays;

public class CustomQueue<T> {
    T array[];
    int front;
    int rear;
    int size;
    public CustomQueue(){
        array = (T[])new Object[2];
        front = rear = -1;
        size = 0;
    }
    public void add(T val){
        if(rear == array.length-1){
            System.out.println("Overflow");
            return;
        }
        array[rear+1] = val;
        rear++;
        size++;
    }
    public void remove(){
        if(front == -1 && rear == -1) {
            System.out.println("Underflow");
            return;
        }
        array[front+1] = null;
        front++;
        if(front == rear){
            front = rear = -1;
        }
        size--;
    }
    public int size(){
        return size;
    }
    public void display(){
        System.out.println(Arrays.toString(array));
    }
     
}

class CustomQueueTest{
    public static void main(String[] args) {
        CustomQueue<Integer> queue = new CustomQueue<>();
        queue.add(1);
        queue.add(2);
        queue.display();
        System.out.println(queue.size());
        queue.remove();
        queue.display();
        queue.remove();
        queue.display();
        System.out.println(queue.size());
    }
}  