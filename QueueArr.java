public class QueueArr {
	
	static class Queue {

		static int[] arr;
		static int size;
		static int rear;

		Queue(int n) {
			arr = new int[n];
			size = n;
			rear = -1;
		}

		public boolean isEmpty() {
			return rear == -1;
		}

		public boolean isFull() {
			return rear == size-1;
		}

		public void add(int data) {																			// O(1)
			if(isFull()) {
				System.out.println("Error! Queue is full!");
				return;
			}
			rear += 1;
			arr[rear] = data;
		}

		public int remove() {																				// O(n)
			if(isEmpty()) {
				System.out.println("Error! Queue is empty!");
				return Integer.MIN_VALUE;
			}
			int front = arr[0];
			for(int i=0; i<rear; i++) {
				arr[i] = arr[i+1];
			}
			rear -= 1;
			return front;
		}

		public int peek() {																					// O(1)
			if(isEmpty()) {
				System.out.println("Error! Queue is empty!");
				return Integer.MIN_VALUE;
			}
			return arr[0];
		}

		public void print() {																				// O(n²)
			if(isEmpty()) {
				System.out.println("Queue is empty");
				return;
			}
			while(!isEmpty()) {
				System.out.print(peek() + " ");
				remove();
			}
			System.out.println();
		}

	}

	static class CircularQueue {

		static int[] arr;
		static int size;
		static int front;
		static int rear;

		CircularQueue(int n) {
			arr = new int[n];
			size = n;
			front = -1;
			rear = -1;
		}

		public boolean isEmpty() {
			return (front == -1) && (rear == -1);
		}

		public boolean isFull() {
			return front == (rear + 1) % size;
		}

		public void add(int data) {																			// O(1)
			if(isFull()) {
				System.out.println("Error! Queue is full!");
				return;
			}
			if(front == -1) {
				front = 0;
			}
			rear = (rear + 1) % size;
			arr[rear] = data;
		}

		public int remove() {																				// O(1)
			if(isEmpty()) {
				System.out.println("Error! Queue is empty!");
				return Integer.MIN_VALUE;
			}
			int data = arr[front];
			if(front == rear) {
				front = rear = -1;
			}
			else {
				front = (front + 1) % size;
			}
			return data;
		}

		public int peek() {																					// O(1)
			if(isEmpty()) {
				System.out.println("Error! Queue is empty!");
				return Integer.MIN_VALUE;
			}
			return arr[front];
		}

		public void print() {																				// O(n)
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
		CircularQueue q = new CircularQueue(4);
		q.add(0);
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.remove();
		q.print();
	}

}
