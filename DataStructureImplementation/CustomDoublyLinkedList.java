/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/

public class CustomDoublyLinkedList
{
    static class LinkedListImplementation<T>{
        Node head;
        Node tail;
        class Node{
            T data;
            Node next;
            Node prev;
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
                tail.next.prev = tail;
                tail = tail.next;
            }
        }
        public void addFirst(T data){
            if(head == null){
                head = tail = new Node(data);
            }
            else{
                Node node = new Node(data);
                node.next = head;
                head.prev = node;
                head = node;
            }
        }
        public void removeFirst(){
            if(head == null) return;
            head = head.next;
            head.prev = null;
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
                sb.append(temp.data+",");
                temp = temp.next;
            }
            return sb.toString();
        }
        public String displayReverse(){
            Node temp = tail;
            StringBuilder sb = new StringBuilder();
            while(temp!=null){
                sb.append(temp.data+",");
                temp = temp.prev;
            }
            return sb.toString();
        }
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		LinkedListImplementation linkedList = new LinkedListImplementation();
		linkedList.addLast(1);
		linkedList.addFirst("2");
		linkedList.addLast(3);
		String val = linkedList.display();
		System.out.println(val);
// 		linkedList.removeLast();
// 		linkedList.removeFirst();
		String val2 = linkedList.displayReverse();
		System.out.println(val2);
	}
}
