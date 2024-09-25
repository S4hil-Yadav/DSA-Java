import java.util.Stack;

public class QueueStk {

	static class Queue {																					// HW!
		static Stack<Integer> s1 = new Stack<>();
		static Stack<Integer> s2 = new Stack<>();

		public boolean isEmpty() {
			return s1.isEmpty();
		}

		public void add(int data) {																			// O(n)
			while(!s1.isEmpty()) {
				s2.push(s1.pop());
			}
			s1.push(data);
			while(!s2.isEmpty()) {
				s1.push(s2.pop());
			}
		}

		public int remove() {																				// O(1)
			if(isEmpty()) {
				System.out.println("Error! Queue is empty!");
				return Integer.MIN_VALUE;
			}
			return s1.pop();
		}

		public int peek() {																					// O(1)
			if(isEmpty()) {
				System.out.println("Error! Queue is empty!");
				return Integer.MIN_VALUE;
			}
			return s1.peek();
		}

		public void print() {
			if(isEmpty()) {
				System.out.println("Error! Queue is empty!");
				return;
			}
			while(!isEmpty()) {
				System.out.print(remove() + " ");
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