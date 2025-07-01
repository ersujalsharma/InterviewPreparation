package DataStructureImplementation.StackAndQueues_Implementation;

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

public class CustomStackUsingLinkedList<T> {
    private Node<T> top;
    private Node<T> bottom;
    int size;
    public CustomStackUsingLinkedList(){
        top = null;
        size = 0;
    }
    public void push(T val){
        Node newNode = new Node(val);
        if(top == null){
            top = bottom = newNode;
        }
        else{
            bottom.next = newNode;
            bottom = bottom.next;
        }
        size++;
    }
    public T pop(){
        if(top == null){
            System.out.println("Underflow");
            return null;
        }
        Node<T> val = bottom;
        if(top == bottom){
            top = bottom = null;
        }
        else{
            Node<T> temp = top;
            while(temp.next != bottom) {
                temp = temp.next;
            }
            bottom = temp;
            bottom.next = null;
        }
        return val.data;
    }
    public int size(){
        return size;
    }
    public void display(){
        Node temp = top ;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println();
    }
}
class Test{
    public static void main(String[] args) {
        CustomStackUsingLinkedList stack = new CustomStackUsingLinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.display();
        stack.pop();
        stack.display();
        stack.pop();
        stack.display();
    }
}
