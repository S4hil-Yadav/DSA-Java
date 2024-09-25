public class LinkedList {

	public static class Node {
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static Node head;
	public static Node tail;
	public static int size;

	public void addFirst(int data) {						// O(1)
		Node newNode = new Node(data);
		size++;
		if(head == null) {
			head = tail = newNode;
			return;
		}
		newNode.next = head;
		head = newNode;
	}

	public void addLast(int data) {							// O(1)
		Node newNode = new Node(data);
		size++;
		if(head == null) {									// We could also have used the condition tail == null but
			head = tail = newNode;							// conventionally a LL is considered empty if its head is null
			return;
		}
		tail.next = newNode;
		tail = newNode;
	}

	public void add(int idx, int data) {					// O(n)
		if(idx == 0) {
			addFirst(data);
			return;
		}
		Node newNode = new Node(data);
		size++;
		Node temp = head;
		for(int i=0; i<idx-1; i++) {
			temp = temp.next;
		}
		newNode.next = temp.next;
		temp.next = newNode;
	}

	public int removeFirst() {									// O(1)
		if(size == 0) {
			System.out.println("LL is empty!");
			return Integer.MIN_VALUE;
		}
		size--;
		int data = head.data;
		if(size == 1) {
			head = tail = null;
			return data;
		}
		head = head.next;
		return data;
	}

	public int removeLast() {									// O(n)
		if(size == 0) {
			System.out.println("LL is empty!");
			return Integer.MIN_VALUE;
		}
		int data = tail.data;
		if(size == 1) {
			head = tail = null;
			size--;
			return data;
		}
		Node prev = head;
		while(prev.next != tail) {
			prev = prev.next;
		}
		prev.next = null;
		tail = prev;
		size--;
		return data;
	}

	public int itrSearch(int key) {								// O(n)
		Node temp = head;
		for(int i=0; i<size; i++) {
			if(temp.data == key) {
				return i;
			}
			temp = temp.next;
		}
		return -1;
	}

	public int recSearch(int key, Node temp, int i) {			// O(n)
		if(temp == null) {
			return -1;
		}
		if(temp.data == key) {
			return i;
		}
		return recSearch(key, temp.next, i+1);
	}

	public void reverse() {										// O(n)
		Node prev = null;
		Node curr = tail = head;
		Node next;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}

	public int removeNthFromLast(int n) {
		if(n == size) {
			return removeFirst();
		}
		Node prev = head;
		for(int i=1; i<size-n; i++) {
			prev = prev.next;
		}
		int data = prev.next.data;
		prev.next = prev.next.next;
		return data;
	}

	public static Node midNode() {								// O(n)
		Node slow = head;		// turtle						// slow fast approach
		Node fast = head;		// hare
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public boolean isPalindrome() {								// TC :- O(n)
		Node mid = midNode();									// SC :- O(1)
		Node prev = null;
		Node curr = mid;
		Node next;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		Node left = head;
		Node right = tail;
		while(right != null) {
			if(left.data != right.data) {
				return false;
			}
			left = left.next;
			right = right.next;
		}
		return true;
	}

	public boolean isCyclic() {									// Floyd's cycle finding algorithm
		Node slow = head;
		Node fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				return true;
			}
		}
		return false;
	}

	public void breakCycle() {								// Note :- not valid for full cycle (it's a corner case)
		Node slow = head;
		Node fast = head;
		boolean cyclic = false;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				cyclic = true;
				break;
			}
		}
		if(!cyclic) {
			return;
		}
		slow = head;
		Node prev = null;
		while(slow != fast) {
			prev = fast;
			fast = fast.next;
			slow = slow.next;
		}
		prev.next = null;
	}

	public Node getMid(Node head) {
		Node slow = head;
		Node fast = head.next;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public Node mergeSort(Node head) {								// main() :-     head = ll.mergeSort(head);
		if(head == null || head.next == null) {
			return head;
		}
		Node mid = getMid(head);
		Node rightHead = mid.next;
		mid.next = null;
		Node newLeft = mergeSort(head);
		Node newRight = mergeSort(rightHead);
		return merge(newLeft, newRight);
	}

	public Node merge(Node head1, Node head2) {
		Node mergedLL = new Node(-1);
		Node temp = mergedLL;
		while(head1 != null && head2 != null) {
			if(head1.data < head2.data) {
				temp.next = head1;
				head1 = head1.next;
				temp = temp.next;
			}
			else {
				temp.next = head2;
				head2 = head2.next;
				temp = temp.next;
			}
		}
		while(head1 != null) {
			temp.next = head1;
			head1 = head1.next;
			temp = temp.next;
		}
		while(head2 != null) {
			temp.next = head2;
			head2 = head2.next;
			temp = temp.next;
		}
		return mergedLL.next;
	}

	public void zigZag() {
		Node slow = head;
		Node fast = head.next;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		Node mid = slow;
		if(fast == null) {
			tail = mid;
		}
		else {
			tail = mid.next;
		}
		Node curr = mid.next;
		mid.next = null;
		Node prev = null;
		Node next;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		Node left = head;
		Node right = prev;
		Node nextL, nextR;
		while(left != null && right != null) {
			nextL = left.next;
			left.next = right;
			nextR = right.next;
			right.next = nextL;
			left = nextL;
			right = nextR;
		}
	}

	public int size() {											// O(n)
		int size = 0;
		Node temp = head;
		while(temp != null) {
			temp = temp.next;
			size++;
		}
		return size;
	}

	public void print() {										// O(n)
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data + ", ");
			temp = temp.next;
		}
		System.out.println("null");
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.addLast(1);
		ll.addLast(2);
		ll.addLast(3);
		ll.addLast(4);
		ll.addLast(5);
		ll.print();
		ll.zigZag();
		ll.print();
		System.out.println(tail.data);
	}

}
