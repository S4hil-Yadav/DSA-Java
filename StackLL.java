public class StackLL {
	
	static Node head;

	static class Node {
		int data;
		Node next;
		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	static class Stack {

		boolean isEmpty() {
			return (head == null);
		}

		void push(int data) {
			Node newNode = new Node(data);
			if(isEmpty()) {
				head = newNode;
				return;
			}
			newNode.next = head;
			head = newNode;
		}

		int pop() {
			if(isEmpty()) {
				System.out.println("Stack is empty!");
				return Integer.MIN_VALUE;
			}
			int top = head.data;
			head = head.next;
			return top;
		}

		int peek() {
			if(isEmpty()) {
				System.out.println("Stack is empty!");
				return Integer.MIN_VALUE;
			}
			return head.data;
		}

		void pushAtBottom(int data) {
			if(isEmpty()) {
				push(data);
				return;
			}
			Node bottom = head;
			while(bottom.next != null) {
				bottom = bottom.next;
			}
			bottom.next = new Node(data);
		}

		void pushAtBottomRec(int data) {
			if(isEmpty()) {
				push(data);
				return;
			}
			int curr = pop();
			pushAtBottomRec(data);
			push(curr);
		}
		
		void print() {
			if(isEmpty()) {
				System.out.println("Stack is empty!");
				return;
			}
			while(head != null) {
				System.out.print(pop() + " ");
			}
			System.out.println();
		}

		void rev() {							// SC :- O(1)
			if(isEmpty()) {
				return;
			}
			int curr = pop();
			rev();
			pushAtBottom(curr);
		}

	}

	public static String revStr(String str) {
		int n = str.length();
		Stack st = new Stack();
		for(int i=0; i<n; i++) {
			st.push(str.charAt(i));
		}
		StringBuilder revStr = new StringBuilder("");
		while(!st.isEmpty()) {
			char curr = (char)st.pop();
			revStr.append(curr);
		}
		return revStr.toString();
	}

	public static void main(String[] args) {
		Stack stk = new Stack();
		stk.push(1);
		stk.push(2);
		stk.push(3);
		stk.push(4);
		stk.rev();
		stk.print();
	}

}

