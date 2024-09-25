public class Trie {
	
	static Node root = new Node();
	static int size;

	static class Node {
		Node[] children = new Node[26];
		boolean endOfWord = false;
		int freq = 1;
	}

	static void insert(String word) {																											// O(L)
		Node curr = root;
		for(int lvl=0; lvl<word.length(); lvl++) {
			int idx = word.charAt(lvl)-'a';
			if(curr.children[idx] == null) {
				curr.children[idx] = new Node();
			}
			curr = curr.children[idx];
		}
		curr.endOfWord = true;
		size++;
	}

	static boolean contains(String key) {																										// O(L)
		Node curr = root;
		for(int lvl=0; lvl<key.length(); lvl++) {
			int idx = key.charAt(lvl)-'a';
			if(curr.children[idx] == null) {
				return false;
			}
			curr = curr.children[idx];
		}
		return curr.endOfWord;
	}

	static boolean wordBreak(String key) {																										// O(L)
		if(key.length() == 0) {
			return true;
		}
		for(int i=1; i<=key.length(); i++) {
			if(contains(key.substring(0, i)) && wordBreak(key.substring(i))) {
				return true;
			}
		}
		return false;
	}

	static void shortestUniquePrefix(String[] words, String[] res, int n) {			// To be continued......
		
	}

	public static void main(String[] args) {
		String[] words = {"zebra", "dog", "duck", "dove"};
		for(String word : words) {
			insert(word);
		}
		System.out.println(size);
	}
	
}
