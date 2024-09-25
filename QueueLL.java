public class QueueLL {
	
	static class Node {
		int data;
		Node next;
		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	static class Queue {

		static Node head;
		static Node tail;

		public boolean isEmpty() {
			return head == null;
		}

		public void add(int data) {																				// O(1)
			Node newNode = new Node(data);
			if(isEmpty()) {
				head = tail = newNode;
				return;
			}
			tail.next = newNode;
			tail = newNode;
		}

		public int remove() {																					// O(1)
			if(isEmpty()) {
				System.out.println("Error! Queue is empty!");
				return Integer.MIN_VALUE;
			}
			int front = head.data;
			if(head == tail) {
				head = tail = null;
			}
			else {
				head = head.next;
			}
			return front;
		}

		public int peek() { 																					// O(1)
			if(isEmpty()) {
				System.out.println("Error! Queue is empty!");
				return Integer.MIN_VALUE;
			}
			return head.data;
		}

		public void print() {																					// O(n)
			if(isEmpty()) {
				System.out.println("Error! Queue is empty!");
				return;
			}
			while(!isEmpty()) {
				System.out.print(peek() + " ");
				remove();
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		Queue q = new Queue();
		q.add(0);
		q.add(1);
		q.add(2);
		q.add(3);
		q.remove();
		q.print();
	}

}
