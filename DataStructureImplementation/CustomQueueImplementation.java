/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
class CustomQueue{
    protected int arr[];
    private final int SIZE = 10;
    private int index = -1;
    CustomQueue(){
        arr = new int[SIZE];
    }
    CustomQueue(int size){
        arr = new int[size];
    }
    public void enqueue(int val){
        if(isFull()){ 
            System.out.println("Queue is Full.");
            return;
        }
        arr[++index] = val;
    }
    public int dequeue(){
        if(isEmpty()){ 
            System.out.println("Queue is Empty.");
            return -1;
        }
        int val = arr[0];
        for(int i=0;i<index;i++){
            arr[i] = arr[i+1];
        }
        index--;
        return val;
    }
    public boolean isFull(){
        return index == arr.length-1;
    }
    public boolean isEmpty(){
        return index == -1;
    }
    public void display(){
        System.out.print("START <- ");
        for(int i=0;i<=index;i++){
            System.out.print(arr[i]+" <- ");
        }
        System.out.println("END.");
    }
}
class CustomQueueWithDynamicSizing extends CustomQueue{
    CustomQueueWithDynamicSizing(){
        super();
    }
    CustomQueueWithDynamicSizing(int size){
        super(size);
    }
    public void enqueue(int val){
        if(isFull()){
            int temp[] = new int[arr.length*2];
            for(int i=0;i<arr.length;i++){
                temp[i] = arr[i];
            }
            arr = temp;
        }
        super.enqueue(val);
    }
}
class CustomeCicularQueue{
    protected int[] arr;
    private final int SIZE = 10;
    private int front = -1;
    private int end = -1;
    CustomeCicularQueue(){
        arr = new int[SIZE];
        Arrays.fill(arr,-1);
    }
    CustomeCicularQueue(int size){
        arr = new int[size];
        Arrays.fill(arr,-1);
    }
    public void enqueue(int val){
        if(isFull()){
            System.out.println("Queue is Full.");
            return;
        }
        if(front ==-1) front = 0;
        end = (end+1)%arr.length;
        arr[end] = val;
    }
    public int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty.");
            return -1;
        }
        int val = arr[front];
        arr[front] = -1;
        if(front == end){
            front = end = -1;
        }
        else{
            front = (front + 1)%arr.length;
        }
        return val;
    }
    public boolean isFull(){
        return (end+1)%arr.length == front;
    }
    public boolean isEmpty(){
        return front==-1 && end==-1;
    }
    public void display(){
        // if(isEmpty()){
        //     return;
        // }
        System.out.print("START <- ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" <- ");
        }
        System.out.println("END");
    } 
}
public class CustomQueueImplementation
{
	public static void main(String[] args) {
		CustomeCicularQueue queue = new CustomeCicularQueue(2);
		queue.enqueue(10);
		queue.display();
		queue.dequeue();
		queue.display();
		queue.enqueue(20);
		queue.display();
		while(!queue.isEmpty()){
		    System.out.println(queue.dequeue());
		}
	}
}
