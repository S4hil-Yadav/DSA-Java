import java.util.ArrayList;

public class StackAL {

	public static void main(String[] args) {
		Stack st = new Stack();
		st.push(0);
		st.push(1);
		st.push(2);
		st.print();
	}

}

class Stack {

	static ArrayList<Integer> list = new ArrayList<>();

	void push(int data) {
		list.add(data);
	}

	int pop() {
		if(isEmpty()){
			System.out.println("Stack is empty");
			return Integer.MIN_VALUE;
		}
		return list.remove(list.size() - 1);
	}
	
	int peek() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return Integer.MIN_VALUE;
		}
		return list.get(list.size() - 1);
	}

	boolean isEmpty() {
		return (list.size() == 0);
	}

	void print() {
		System.out.println(list);
	}

}
