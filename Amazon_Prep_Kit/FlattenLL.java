// public class FlattenLL {
    
// }
class ListNode {
	int data;
	ListNode next;
	ListNode down;

	ListNode(int data) {
		this.data = data;
		this.next = null;
		this.down = null;
	}
}

class FlattenLL {
	ListNode flattenTheLinkedList(ListNode root) {
		// add your logic here
		if(root == null) return null;
		if(root.next == null) return downToNext(root);
		ListNode merged = mergedDown(root,root.next);
		ListNode next = root.next.next;
		merged.next = next;
		return flattenTheLinkedList(merged);
	}
	ListNode downToNext(ListNode root){
		ListNode temp = root;
		while(root!=null){
			ListNode next = root.next;
			ListNode down = root.down;
			root.down = next;
			root.next = down;
			root = root.next;
		}
		return temp;
	}
	ListNode mergedDown(ListNode firstNode,ListNode secondNode){
		ListNode temp = new ListNode(0);
		ListNode anstemp = temp;
		while(firstNode!=null && secondNode!=null){
			if(firstNode.data<=secondNode.data){
				temp.down = new ListNode(firstNode.data);
				firstNode = firstNode.down;
			}
			else{
				temp.down = new ListNode(secondNode.data);
				secondNode = secondNode.down;
			}
			temp = temp.down;
		}
		while(firstNode!=null){
			temp.down = new ListNode(firstNode.data);
			firstNode = firstNode.down;
			temp = temp.down;
		}
		while(secondNode!=null){
			temp.down = new ListNode(secondNode.data);
			secondNode = secondNode.down;
			temp = temp.down;
		}
		return anstemp.down;
	}
	
}