import java.util.Stack;

public class StackJCF {
	
	public static void pushAtBottom(Stack<Integer> stk, int data) {
		if(stk.isEmpty()) {
			stk.push(data);
			return;
		}
		int curr = stk.pop();
		pushAtBottom(stk, data);
		stk.push(curr);
	}

	public static void revStk(Stack<Integer> stk) {													// SC :- O(1)
		if(stk.isEmpty()) {
			return;
		}
		int curr = stk.pop();
		revStk(stk);
		pushAtBottom(stk, curr);
	}

	public static void stockSpan(int[] stock, int[] span) {											// TC :- O(n)				n+2n --> n
		Stack<Integer> stk = new Stack<>();
		for(int i=0; i<stock.length; i++) {
			while(!stk.isEmpty() && stock[stk.peek()] <= stock[i]) {
				stk.pop();
			}
			if(stk.isEmpty()) {
				span[i] = i+1;
			}
			else {
				span[i] = i-stk.peek();
			}
			stk.push(i);
		}
	}

	public static void nextGreater(int[] nums, int[] nextGreater) {									// TC :- O(n)				n+2n --> n
		Stack<Integer> stk = new Stack<>();
		for(int i=nums.length-1; i>=0; i--) {														// prevGreater --> i = 0  to  i < nums.length-1
			while(!stk.isEmpty() && nums[stk.peek()] <= nums[i]) {									// nextSmaller --> nums[stk.peek()] >= nums[i])
				stk.pop();																			// prevSmaller --> i = 0  to  i < nums.length-1
			}																						//				   &  nums[stk.peek()] >= nums[i])
			if(stk.isEmpty()) {
				nextGreater[i] = -1;
			}
			else {
				nextGreater[i] = nums[stk.peek()];
			}
			stk.push(i);
		}
	}

	public static boolean validParenthesis(String str) {											// TC :- O(n)
		Stack<Character> stk = new Stack<>();
		for(int i=0; i<str.length(); i++) {
			char next = str.charAt(i);
			if(next == '(' || next == '{' || next == '[') {
				stk.push(next);
				continue;
			}
			if(stk.isEmpty()) {
				return false;
			}
			char prev = stk.peek();
			if(next == prev+1 || next == prev+2) {
				stk.pop();
			}
			else {
				return false;
			}
		}
		return stk.isEmpty();
	}

	public static boolean duplicateParenthesis(String str) {
		Stack<Character> stk = new Stack<>();
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if(ch != ')') {
				stk.push(ch);
			}
			else {
				int count = 0;
				while(stk.pop() != '(') {
					count++;
				}
				if(count == 0) {
					return true;
				}
			}
		}
		return false;
	}

	public static int maxRectangularAreaInHistogram(int[] heights) {
		Stack<Integer> stk = new Stack<>();
		int[] nextSmaller = new int[heights.length];
		int[] prevSmaller = new int[heights.length];
		for(int i=heights.length-1; i>=0; i--) {
			while(!stk.isEmpty() && heights[stk.peek()] >= heights[i]) {
				stk.pop();
			}
			if(stk.isEmpty()) {
				nextSmaller[i] = heights.length;
			}
			else {
				nextSmaller[i] = stk.peek();
			}
			stk.push(i);
		}
		while(!stk.isEmpty()) {
			stk.pop();
		}
		for(int i=0; i<heights.length; i++) {
			while(!stk.isEmpty() && heights[stk.peek()] >= heights[i]) {
				stk.pop();
			}
			if(stk.isEmpty()) {
				prevSmaller[i] = -1;
			}
			else {
				prevSmaller[i] = stk.peek();
			}
			stk.push(i);
		}
		int maxArea = Integer.MIN_VALUE;
		for(int i=0; i<heights.length; i++) {
			int currArea = heights[i] * (nextSmaller[i] - prevSmaller[i] - 1);
			maxArea = Math.max(maxArea, currArea);
		}
		return maxArea;
	}

	public static void main(String[] args) {
		int[] heights = {2, 1, 5, 6, 2, 3};
		System.out.println(maxRectangularAreaInHistogram(heights));
	}
}
