import java.util.Deque;
import java.util.LinkedList;

public class QueueDQ {

	static class Queue {

		Deque<Integer> dq = new LinkedList<>();

		void add(int data) {
			dq.addLast(data);
		}

		int pop() {
			return dq.removeFirst();
		}

		int peek() {
			return dq.getFirst();
		}

		void print() {
			System.out.println(dq);
		}

	}

	public static void main(String[] args) {
		Queue q = new Queue();
		q.add(0);
		q.add(1);
		q.add(2);
		q.add(3);
		q.print();
		q.pop();
		q.print();
		System.out.println(q.peek());
	}

}
