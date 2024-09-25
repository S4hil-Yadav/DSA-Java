public class DoublyLL {

	public static class Node {
		int data;
		Node next;
		Node prev;
		public Node(int data) {
			this.data = data;
			next = null;
			prev = null;
		}
	}
	
	public static Node head;
	public static Node tail;
	public static int size;

	public void addFirst(int data) {
		Node newNode = new Node(data);
		size++;
		if(head == null) {
			head = tail = newNode;
			return;
		}
		newNode.next = head;
		head.prev = newNode;
		head = newNode;
	}

	public void addLast(int data) {
		Node newNode = new Node(data);
		size++;
		if(head == null) {
			head = tail = newNode;
			return;
		}
		tail.next = newNode;
		newNode.prev = tail;
		tail = newNode;
	}

	public int removeFirst() {
		if(head == null) {
			System.out.println("LL is empty!");
			return Integer.MIN_VALUE;
		}
		size--;
		int data = head.data;
		if(head.next == null) {
			head = tail = null;
			return data;
		}
		head = head.next;
		head.prev = null;
		return data;
	}

	public int removeLast() {
		if(tail == null) {
			System.out.println("LL is empty!");
			return Integer.MIN_VALUE;
		}
		size--;
		int data = tail.data;
		if(tail.prev == null) {
			head = tail = null;
			return data;
		}
		tail = tail.prev;
		tail.next = null;
		return data;
	}

	public void reverse() {
		Node curr = tail = head;
		Node prev = null;
		while(curr != null) {
			Node next = curr.next;
			curr.next = curr.prev;
			curr.prev = next;
			prev = curr;
			curr = next;
		}
		head = prev;
	}

	public void reverse2() {
		Node curr = head;
		head = tail;
		tail = curr;
		while(curr != null) {
			Node next = curr.next;
			curr.next = curr.prev;
			curr.prev = next;
			curr = next;
		}
	}

	public int size() {
		int size = 0	;
		Node temp = head;
		while(temp != null) {
			size++;
			temp = temp.next;
		}
		return size;
	}

	public void print() {
		Node curr = head;
		while(curr != null) {
			System.out.print(curr.data + ", ");
			curr = curr.next;
		}
		System.out.println("null");
	}

	public static void main(String[] args) {
		DoublyLL dll = new DoublyLL();
		dll.addLast(1);
		dll.addLast(2);
		dll.addLast(3);
		dll.addLast(4);
		dll.addLast(5);
		dll.print();
		System.out.println(head.data);
		System.out.println(tail.data);
		dll.reverse2();
		dll.print();
		System.out.println(head.data);
		System.out.println(tail.data);

	} 
}
