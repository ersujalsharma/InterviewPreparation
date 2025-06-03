/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/

public class CustomLinkedList
{
    static class LinkedListImplementation<T>{
        Node head;
        Node tail;
        
        class Node{
            T data;
            Node next;
            public Node(T data){
                this.data = data;
            }
        }
        
        public LinkedListImplementation(){
            head = tail = null;
        }
        public void addLast(T data){
            if(tail == null){
                head = tail = new Node(data);
            }
            else{
                tail.next = new Node(data); 
                tail = tail.next;
            }
        }
        public Node addValIndex(T val,int index){
            return addValueIndexHelp(val,index,head);
        }
        public Node addValueIndexHelp(T val,int index,Node head){
            if(index==0){
                Node node = new Node(val);
                node.next = head;
                return node;
            }
            head.next = addValueIndexHelp(val,index-1,head.next);
            return head;
        }
        public void addFirst(T data){
            if(head == null){
                head = tail = new Node(data);
            }
            else{
                Node node = new Node(data);
                node.next = head;
                head = node;
            }
        }
        public void removeFirst(){
            if(head == null) return;
            head = head.next;
        }
        public void removeLast(){
            if(tail==null) return;
            Node prev = null;
            Node cur = head;
            while(cur.next!=null){
                prev = cur;
                cur = cur.next;
            }
            prev.next = null;
            tail = prev;
        }
        public String display(){
            Node temp = head;
            StringBuilder sb = new StringBuilder();
            while(temp!=null){
                sb.append(temp.data+" -> ");
                temp = temp.next;
            }
            return sb.toString();
        }
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		LinkedListImplementation linkedList = new LinkedListImplementation();
		linkedList.addLast(1);
		linkedList.addLast(4);
		linkedList.addFirst("2");
		linkedList.addLast(3);
		linkedList.addValIndex(40,2);
		String val = linkedList.display();
		System.out.println(val);
		linkedList.removeLast();
		linkedList.removeFirst();
		String val2 = linkedList.display();
		System.out.println(val2);
	}
}
