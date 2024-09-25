import java.util.Deque;
import java.util.LinkedList;

public class StackDQ {

	static class Stack {

		Deque<Integer> dq = new LinkedList<>();

		void push(int data) {
			dq.addLast(data);
		}

		int pop() {
			return dq.removeLast();
		}

		int peek() {
			return dq.getLast();
		}

		void print() {
			System.out.println(dq);
		}

	}

	public static void main(String[] args) {

		Stack stk = new Stack();
		stk.push(1);
		stk.push(2);
		stk.push(3);
		stk.push(0);
		stk.print();
		stk.pop();
		stk.print();
		System.out.println(stk.peek());

	}

}
