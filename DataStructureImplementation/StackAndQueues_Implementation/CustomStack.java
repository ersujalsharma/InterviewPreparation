package DataStructureImplementation.StackAndQueues_Implementation;

import java.util.Arrays;
import java.util.Stack;

public class CustomStack<T> {
    // Stack implementation using an array
    private T array[];
    private int size;
    public CustomStack(){
        array = (T[])new Object[10];
        size = 0;
    }
    public void push(T val){
        array[size] = val;
        size++;
    }
    public T pop(){
        T val = array[size-1];
        array[size-1] = null;
        size--;
        return val;
    }
    public T peek(){
        return array[size-1];
    }
    public int size(){
        return size;
    }
    public void display(){
        System.out.println(Arrays.toString(array));
    }
    public boolean search(T i) {
        // TODO Auto-generated method stub
        
        CustomStack<T> customStack1 = new CustomStack<>();
        boolean exist = false;
        while(this.size()>0){
            if(this.peek().equals(i)){
                exist = true;
                break;
            }
            customStack1.push(this.pop());
        }
        while(customStack1.size()>0){
            this.push(customStack1.pop());
        }
        return exist;
    }

}
class CustomStackTest{
    public static void main(String[] args) {
        CustomStack<Integer> stack = new CustomStack<>();
        stack.push(1);
        stack.display();
        System.out.println(stack.peek());
        System.out.println(stack.size());
        stack.pop();
        stack.display();
        System.out.println(stack.size());
        stack.push(2);
        stack.push(4);
        stack.push(5);
        boolean ans = stack.search(1);
        System.out.println(ans);
    }
}
