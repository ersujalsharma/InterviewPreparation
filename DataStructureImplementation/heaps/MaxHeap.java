package heaps;

import java.util.Arrays;

public class MaxHeap {
    private int arr[];
    private int size;
    public MaxHeap(){
        arr = new int[16];
        Arrays.fill(arr,-1);
        size = 0;
    }
    public MaxHeap(int size){
        arr = new int[size];
    }
    public void add(int data){
        if(size == arr.length) {
            System.out.println("Overflow");
        }
        arr[size] = data;
        heapifyUp(size);
        size++;
    }
    private void heapifyUp(int index) {
        // TODO Auto-generated method stub
        while(index>0){
            int parent = (index-1)/2;
            if(arr[parent]>arr[index]) break;
            swap(index,parent);
            index = parent;
        }
    }
    private void swap(int index, int parent) {
        // TODO Auto-generated method stub
        int temp = arr[index];
        arr[index] = arr[parent];
        arr[parent] = temp;
    }
    public void pop(){
        if(isEmpty()) {
            System.out.println("Underflow");
            return;
        }
        // swap with the last one.
        arr[0] = arr[size-1];
        arr[size-1] = -1;
        size--;
        heapifyDown(0);
    }
    private void heapifyDown(int index) {
        // TODO Auto-generated method stub
        while(index<size){
            int largest = index;
            int leftchild = (2*index)+1;
            int rightchild = (2*index)+2;
            if(leftchild<size && arr[leftchild]>arr[largest]) largest = leftchild;
            if(rightchild<size && arr[rightchild]>arr[largest]) largest = rightchild;
            if(arr[largest]==arr[index]) break;
            swap(index,largest);
            index = largest;
        }
    }
    public void peek(){
        if(isEmpty()){
            System.out.println("Underflow");
            return;
        }
        System.out.println(arr[0]);
    }
    public boolean isEmpty(){
        return size==0;
    }
    public int size(){
        return size;
    }
    public void display(){
        System.out.println(Arrays.toString(arr));
        displayPretty(0, "", true);
    }
    private void displayPretty(int i, String string, boolean b) {
        // TODO Auto-generated method stub
        if(i>=size || arr[i]==-1) return;
        System.out.print(string);
        System.out.print(b ? "├── Left -  " : "└── Right - ");
        System.out.println(arr[i]);
        displayPretty((2*i)+1, string + (b ? "│   " : "    "), true);
        displayPretty((2*i)+2, string + (b ? "│   " : "    "), false);
    }
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.add(2);
        maxHeap.add(1);
        maxHeap.add(3);
        maxHeap.add(4);
        maxHeap.add(0);
        maxHeap.add(2);
        maxHeap.display();
        maxHeap.peek();
        maxHeap.pop();
        maxHeap.pop();
        maxHeap.pop();
        maxHeap.display();
    }
}
