import java.util.ArrayList;
import java.util.Queue;
import java.util.HashMap;
import java.util.LinkedList;

public class Tree {

	static class Node {
		int data;
		Node left;
		Node right;
		Node(int data) {
			this.data = data;
			// this.left = null;				null by default
			// this.right = null;				null by default
		}
	}

	static class BinaryTree {
	
		int idx = -1;

		Node buildTree(Integer[] nodes) {																							// O(n)
			idx++;
			if(nodes[idx] == null) {
				return null;
			}
			Node newNode = new Node(nodes[idx]);
			newNode.left = buildTree(nodes);
			newNode.right = buildTree(nodes);
			return newNode;
		}

		void preorder(Node root) {																									// O(n)
			if(root == null) {
				// System.out.print(-1 + " ");
				return;
			}
			System.out.print(root.data + " ");
			preorder(root.left);
			preorder(root.right);
		}
		
		void inorder(Node root) {																									// O(n)
			if(root == null) {
				// System.out.print(-1 + " ");
				return;
			}
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}

		void postorder(Node root) {																									// O(n)
			if(root == null) {
				// System.out.print(-1 + " ");
				return;
			}
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data + " ");
		}

		void levelorder(Node root) {																								// O(n)
			if(root == null) {
				return;
			}
			Queue<Node> q = new LinkedList<>();
			q.add(root);
			q.add(null);
			while(!q.isEmpty()) {
				Node currNode = q.remove();
				if(currNode == null) {
					System.out.println();
					if(q.isEmpty()) {
						return;
					}
					q.add(null);
				}
				else {
					System.out.print(currNode.data + " ");
					if(currNode.left != null) {
						q.add(currNode.left);
					}
					if(currNode.right != null) {
						q.add(currNode.right);
					}
				}
			}
		}

		int height(Node root) {
			if(root == null) {
				return 0;
			}
			int lh = height(root.left);
			int rh = height(root.right);
			return Math.max(lh, rh) + 1;
		}

		int count(Node root) {
			if(root == null) {
				return 0;
			}
			int lc = count(root.left);
			int rc = count(root.right);
			return (lc + rc + 1);
		}

		int sum(Node root) {
			if(root == null) {
				return 0;
			}
			int ls = sum(root.left);
			int rs = sum(root.right);
			return (ls + rs + root.data);
		}

		int diameterUnoptimized(Node root) {																						// O(n²)
			if(root == null) {
				return 0;
			}
			int ld = diameterUnoptimized(root.left);
			int lh = height(root.left);
			int rd = diameterUnoptimized(root.right);
			int rh = height(root.right);
			int sd = (lh + rh + 1);
			return Math.max(sd, Math.max(ld, rd));
		}

		Info diamAndHt(Node root) {																									// O(n)
			if(root == null) {
				return new Info(0, 0);
			}
			Info li = diamAndHt(root.left);
			Info ri = diamAndHt(root.right);
			int diam = Math.max(li.ht + ri.ht + 1, Math.max(li.diam, ri.diam));
			int ht = Math.max(li.ht, ri.ht) + 1;
			return new Info(diam, ht);
		}
		static class Info {
			int diam;
			int ht;
			Info(int diam, int ht) {
				this.diam = diam;
				this.ht = ht;
			}
		}

	}

	public static boolean isSubtree(Node root, Node subroot) {
		if(subroot == null) {
			return true;
		}
		if(root == null) {
			return false;
		}
		if(isIdentical(root, subroot)) {
			return true;
		}
		return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
	}

	public static boolean isIdentical(Node node, Node subroot) {
		if(node == null && subroot == null) {
			return true;
		}
		if(node == null || subroot == null || node.data != subroot.data) {
			return false;
		}
		if(!isIdentical(node.left, subroot.left)) {
			return false;
		}
		if(!isIdentical(node.right, subroot.right)) {
			return false;
		}
		return true;
		/* 
		if(node == null && subroot == null) {
			return true;
		}
		if(node == null || subroot == null) {
			return false;
		}
		return (node.data == subroot.data && isIdentical(node.left, subroot.left) && isIdentical(node.right, subroot.right));
		*/
	}

	public static void topView(Node root, ArrayList<Node> topView) {

		Queue<Info> q = new LinkedList<>();
		HashMap<Integer, Node> map = new HashMap<>();
		int min = 0, max = 0;
		q.add(new Info(root, 0));
		q.add(null);
		while(!q.isEmpty()) {
			Info curr = q.remove();
			if(curr == null) {
				if(q.isEmpty()) {
					break;
				}
				q.add(null);
			}
			else {
				if(!map.containsKey(curr.hd)) {
					map.put(curr.hd, curr.node);
				}
				if(curr.node.left != null) {
					q.add(new Info(curr.node.left, curr.hd - 1));
					min = Math.min(min, curr.hd - 1);
				}
				if(curr.node.right != null) {
					q.add(new Info(curr.node.right, curr.hd + 1));
					max = Math.max(max, curr.hd + 1);
				}
			}
		}
		for(int i=min; i<=max; i++) {
			topView.add(map.get(i));
		}
	}
	static class Info {
	
		Node node;
		int hd;

		Info(Node root, int hd) {
			this.node = root;
			this.hd = hd;
		}

	}

	public static void kLevelItr(Node root, int k, ArrayList<Node> kLevel) {
		if(root == null) {
			return;
		}
		int lvl = 0;
		Queue<Node> q = new LinkedList<>();
		q.add(null);
		q.add(root);
		while(!q.isEmpty()) {
			Node currNode = q.remove();
			if(currNode == null) {
				lvl++;
				if(q.isEmpty()) {
					return;
				}
				q.add(null);
			}
			if(lvl == k) {
				while(q.peek() != null) {
					kLevel.add(q.remove());
				}
				return;
			}
			if(currNode != null) {
				if(currNode.left != null) {
					q.add(currNode.left);
				}
				if(currNode.right != null) {
					q.add(currNode.right);
				}
			}
		}
	}

	public static void kLevelRec(Node root, int k, int lvl, ArrayList<Node> kLevel) {
		if(root == null) {
			return;
		}
		if(lvl == k) {
			kLevel.add(root);
			return;
		}
		kLevelRec(root.left, k, lvl+1, kLevel);
		kLevelRec(root.right, k, lvl+1, kLevel);
	}

	public static Node lowestCommonAncestor(Node root, Node n1, Node n2) {																// TC :- O(n)
		ArrayList<Node> path1 = new ArrayList<>();																						// SC :- O(n)
		ArrayList<Node> path2 = new ArrayList<>();
		getPath(root, n1, path1);
		getPath(root, n2, path2);
		int i = Math.min(path1.size(), path2.size()) - 1;
		if(i < 0) {
			return null;
		}
		while(path1.get(i) != path2.get(i)) {
			i--;
		}
		return path1.get(i);
	}
	public static boolean getPath(Node root, Node n, ArrayList<Node> path) {
		if(root == null) {
			return false;
		}
		path.add(root);
		if(root == n) {
			return true;
		}
		if(getPath(root.left, n, path) || getPath(root.right, n, path)) {
			return true;
		}
		path.removeLast();
		return false;
	}

	public static Node lca2(Node root, Node n1, Node n2) {																				// TC :- O(n)
		if(root == null || root == n1 || root == n2) {																					// SC :- O(n)
			return root;
		}
		Node leftLCA = lca2(root.left, n1, n2);
		Node rightLCA = lca2(root.right, n1, n2);
		if(leftLCA == null) {
			return rightLCA;
		}
		if(rightLCA == null) {
			return leftLCA;
		}
		return root;
	}

	public static int minDist(Node root, Node n1, Node n2) {
		Node lca = lca2(root, n1, n2);
		int dist1 = dist(lca, n1);
		int dist2 = dist(lca, n2);
		return dist1 + dist2;
	}
	public static int dist(Node subRoot, Node n) {
		if(subRoot == null) {
			return -1;
		}
		if(subRoot == n) {
			return 0;
		}
		int leftDist = dist(subRoot.left, n);
		int rightDist = dist(subRoot.right, n);
		if(leftDist == -1 && rightDist == -1) {
			return -1;
		}
		if(leftDist == -1) {
			return rightDist + 1;
		}
		else {
			return leftDist + 1;
		}
	}

	public static Node KthAnscestor(Node root, Node n, int k) {													// ma'am wala bhi dekh lena
		InfoK ansc = AnscK(root, n, k);
		if(ansc.k > 0) {
			System.out.println("Error! Kth anscestor doesn't exist!");
			return null;
		}
		return ansc.node;
	}
	public static InfoK AnscK(Node root, Node n, int k) {
		if(root == null) {
			return null;
		}
		if(root == n) {
			return new InfoK(root, k);
		}
		InfoK leftAnsc = AnscK(root.left, n, k);
		InfoK rightAnsc = AnscK(root.right, n, k);
		if(leftAnsc == null && rightAnsc == null) {
			return null;
		}
		if(leftAnsc == null && rightAnsc.k == 0) {
			return rightAnsc;
		}
		if(rightAnsc == null && leftAnsc.k == 0) {
			return leftAnsc;
		}
		if(leftAnsc == null) {
			return new InfoK(root, rightAnsc.k-1);
		}
		else {
			return new InfoK(root, leftAnsc.k-1);
		}
	}
	static class InfoK {
		Node node;
		int k;
		InfoK(Node n, int k) {
			this.node = n;
			this.k = k;
		}
	}

	public static int sumTree(Node root) {
		if(root == null) {
			return 0;
		}
		int leftSum = sumTree(root.left);
		int rightSum = sumTree(root.right);
		int currData = root.data;
		root.data = leftSum + rightSum;
		int sum = leftSum + rightSum + currData;
		return sum;
	}

	public static void main(String[] args) {
		Integer[] btNodes = {1, 2, 4, null, null, 5, null, null, 3, 6, null, null, 7, null, null};
		BinaryTree bt = new BinaryTree();
		Node root = bt.buildTree(btNodes);
		sumTree(root);
		bt.preorder(root);
	}

}
