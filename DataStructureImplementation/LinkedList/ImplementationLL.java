package DataStructureImplementation.LinkedList;
class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
public class ImplementationLL {
    
    Node head;
    Node tail;
    int size;
    public ImplementationLL(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void insertAtFirst(int data){
        Node node = new Node(data);
        if(size == 0){
            head = tail = node;
        }
        else{
            node.next = head;
            head = node;
        }
        size++;
    }

    public void insertAtLast(int data){
        Node node = new Node(data);
        if(size == 0){
            head = tail = node;
        }
        else{
            tail.next = node;
            tail = tail.next;
        }
        size++;
    }
    public void insertAtMiddle(int data){
        Node mid = mid();
        Node midNext = mid.next;
        Node newNode = new Node(data);
        newNode.next = midNext;
        mid.next = newNode;
        size++;
    }
    private Node mid() {
        // TODO Auto-generated method stub
        Node slow = head;
        Node fast = head;
        Node prev = null;
        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return prev;
    }

    public int deleteFirst(){
        if(size == 0) return -1;
        Node node = head;
        head = head.next;
        size--;
        return node.data;
    }
    public int deleteLast(){
        if(size == 0) return -1;
        if(size == 1) {
            return deleteFirst(); 
        }
        Node lastprev = lastPrev();
        tail = lastprev;
        Node last = lastprev.next;
        lastprev.next = null;
        size--;
        return last.data;
    }
    


    private Node lastPrev() {
        // TODO Auto-generated method stub
        Node node = head;
        Node ans = null;
        while(node!=tail){
            ans = node;
            node = node.next;
        }
        return ans;
    }
    private int deleteAtMiddle(){
        if(size<=1) return deleteFirst();
        Node prevmid = mid();
        int val = prevmid.next.data;
        Node mid = prevmid.next;
        prevmid.next = mid.next;
        size--;
        return val;
    }


    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        ImplementationLL linkedlist = new ImplementationLL();
        linkedlist.insertAtFirst(1);
        linkedlist.insertAtLast(3);
        linkedlist.insertAtFirst(4);
        linkedlist.insertAtMiddle(5);
        linkedlist.insertAtMiddle(6);
        linkedlist.insertAtMiddle(7);
        linkedlist.insertAtMiddle(1);
        linkedlist.deleteFirst();
        linkedlist.deleteLast();
        linkedlist.deleteLast();
        linkedlist.deleteAtMiddle();
        linkedlist.deleteAtMiddle();
        linkedlist.deleteAtMiddle();
        // linkedlist.deleteAtMiddle();

        linkedlist.display();

    }
}