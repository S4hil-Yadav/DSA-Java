import java.util.Stack;
import java.util.ArrayList;

public class BinarySearchTree {

	static class Node {
		int data;
		Node left;
		Node right;
		Node(int data) {
			this.data = data;
		}
	}

	public static void preorder(Node root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
	}

	public static void inorder(Node root) {
		if(root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	public static Node buildBST(int[] values) {
		Node root = null;
		for(int i=0; i<values.length; i++) {
			root = insert(root, values[i]);
		}
		return root;
	}
	public static Node insert(Node root, int val) {
		if(root == null) {
			return new Node(val);
		}
		if(root.data > val) {
			root.left = insert(root.left, val);
		}
		if(root.data < val) {
			root.right = insert(root.right, val);
		}
		return root;
	}

	public static Node search(Node root, int key) {																					// O(h)
		if(root == null || root.data == key) {
			return root;
		}
		if(root.data > key) {
			return search(root.left, key);
		}
		else {
			return search(root.right, key);
		}
	}

	public static Node delete(Node root, int val) {
		if(root.data > val) {
			root.left = delete(root.left, val);
		}
		else if(root.data < val) {
			root.right = delete(root.right, val);
		}
		else {
			if(root.left == null && root.right == null) {
				return null;
			}
			if(root.left == null) {
				return root.right;
			}
			if(root.right == null) {
				return root.left;
			}
			else {
				Node is = inorderSuccessor(root);
				root.data = is.data;
				root = delete(root, is.data);
			}
		}
		return root;
	}
	public static Node inorderSuccessor(Node root) {
		while(root.left != null) {
			root = root.left;
		}
		return root;
	}

	public static Node deleteSubTree(Node root, int val) {
		if(root == null || root.data == val) {
			root = null;
			return null;
		}
		if(root.data > val) {
			root.left = deleteSubTree(root.left, val);
		}
		if(root.data < val) {
			root.right = deleteSubTree(root.right, val);
		}
		return root;
	}

	public static void printInRange(Node root, int n1, int n2) {
		if(root == null) {
			return;
		}
		if(root.data < n1) {
			printInRange(root.right, n1, n2);
			return;
		}
		if(root.data > n2){
			printInRange(root.left, n1, n2);
			return;
		}
		printInRange(root.left, n1, n2);
		System.out.print(root.data + " ");
		printInRange(root.right, n1, n2);
	}

	public static void rootToLeaves(Node root, Stack<Integer> path) {
		if(root == null) {
			return;
		}
		path.push(root.data);
		if(root.left == null && root.right == null) {
			System.out.println(path);
		}
		rootToLeaves(root.left, path);
		rootToLeaves(root.right, path);
		path.pop();
	}

	public static boolean isBST(Node root, int min, int max) {
		if(root == null) {
			return true;
		}
		if(min < root.data && root.data < max) {
			return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
		}
		return false;
	}

	public static Node mirrorBST(Node root) {
		if(root == null) {
			return null;
		}
		Node leftMirror = mirrorBST(root.left);
		Node rightMirror = mirrorBST(root.right);
		root.left = rightMirror;
		root.right = leftMirror;
		return root;
	}

	public static Node sortedArrToBalancedBST(int[] arr, int si, int ei) {
		if(si > ei) {
			return null;
		}
		int mi = (si+ei)/2;
		Node root = new Node(arr[mi]);
		root.left = sortedArrToBalancedBST(arr, si, mi-1);
		root.right = sortedArrToBalancedBST(arr, mi+1, ei);
		return root;
	}

	public static Node BSTtoBalancedBST(ArrayList<Integer> inorder, int si, int ei) {
		if(si == ei) {
			return new Node(inorder.get(si));
		}
		int mi = (si+ei)/2;
		Node root = new Node(inorder.get(mi));
		root.left = BSTtoBalancedBST(inorder, si, mi-1);
		root.right = BSTtoBalancedBST(inorder, mi+1, ei);
		return root;
	}
	public static void getInorder(Node root, ArrayList<Integer> inorder) {
		if(root == null) {
			return;
		}
		getInorder(root.left, inorder);
		inorder.add(root.data);
		getInorder(root.right, inorder);
	}

	static int largestBSTsize;
	static Node largestBSTroot;
	public static InfoL largestBST(Node root) {
		if(root == null) {
			return new InfoL(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
		}
		InfoL leftInfo = largestBST(root.left);
		InfoL rightInfo = largestBST(root.right);
		int size = leftInfo.size + rightInfo.size + 1;
		int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
		int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));
		if(!leftInfo.isBST || !rightInfo.isBST || root.data <= leftInfo.max || root.data >= rightInfo.min) {
			return new InfoL(false, size, min, max);
		}
		if(size > largestBSTsize) {
			largestBSTsize = size;
			largestBSTroot = root;
		}
		return new InfoL(true, size, min, max);
	}
	static class InfoL {
		boolean isBST;
		int size;
		int min;
		int max;
		InfoL(boolean isBST, int size, int min, int max) {
			this.isBST = isBST;
			this.size = size;
			this.min = min;
			this.max = max;
		}
	}

	public static Node merge2BST(Node root1, Node root2) {
		ArrayList<Integer> io1 = new ArrayList<>();
		ArrayList<Integer> io2 = new ArrayList<>();
		getInorder(root1, io1);
		getInorder(root2, io2);
		int[] inorder = merge(io1, io2);
		// for(int i=0; i<inorder.length; i++) {
		// 	System.out.print(inorder[i] + " ");
		// }
		Node root = sortedArrToBalancedBST(inorder, 0, inorder.length-1);
		return root;
	}
	public static int[] merge(ArrayList<Integer> al1, ArrayList<Integer> al2) {
		int n1 = al1.size();
		int n2 = al2.size();
		int[] arr = new int[n1+n2];
		int si1 = 0, si2 = 0, i=0;
		while(si1 < n1 && si2 < n2) {
			if(al1.get(si1) < al2.get(si2)) {
				arr[i++] = al1.get(si1++);
			}
			else {
				arr[i++] = al2.get(si2++);
			}
		}
		while(si1 < n1) {
			arr[i++] = al1.get(si1++);
		}
		while(si2 < n2) {
			arr[i++] = al2.get(si2++);
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] values1 = {2, 1, 4};
		Node root1 = buildBST(values1);
		int[] values2 = {9, 3, 12};
		Node root2 = buildBST(values2);
		Node root = merge2BST(root1, root2);
		preorder(root);
	}
	
}
