package test;

public class ListTest {
	Node head = null;
	class Node{
		public int value = 0;
		public Node next = null;
		public Node(int value) {
			this.value = value;
		}
	}
	
	public void add(int d) {
		Node node = new Node(d) ;
		if(head == null) {
			head = node;
		}
		else {
			Node temp = head;
			while(temp.next!=null) {
				temp = temp.next;
			}
			temp.next = node;
		}
	}
	
	public int length() {
		if(head == null) {
			return 0;
		}
		else {
			Node temp = head;
			int length = 0;
			while(temp.next!=null) {
				temp = temp.next;
				length++;
			}
			return length;
		}
	}
	
	public boolean delete(int index) {
		if(index<1 || index>length())
			return false;
		int i = 1;
		Node pre = head;
		Node cur = head.next;
		while(i!=index) {
			pre = cur;
			cur = cur.next;
			i++;
		}
		pre.next = cur.next;
		return true;
	}
	
	public void print() {
//		temp 就是第一个节点
		Node temp = head;
		while(temp!= null) {
			System.out.println(temp.value );
			temp = temp.next;
		}
	}
	
}
