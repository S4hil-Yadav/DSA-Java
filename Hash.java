import java.util.LinkedList;
import java.util.ArrayList;

public class Hash {
	
	static class HashMap<K, V> {				// K, V ----> Generics

		private class Node {
			K key;
			V value;
			Node(K key, V value) {
				this.key = key;
				this.value = value;
			}
		}

		private int n;							// n = no. of nodes
		private int N;							// N = buckets.length
		private LinkedList<Node>[] buckets;

		@SuppressWarnings("unchecked")			// this.buckets = new LinkedList[n] won't run in some java versions because of unchecked warning (LinkedList type needs to be specified)
		public HashMap() {
			this.N = 4;
			this.buckets = new LinkedList[4];
			for(int i=0; i<N; i++) {
				this.buckets[i] = new LinkedList<>();
			}
		}

		public int hashFunction(K key) {
			int hc = key.hashCode();
			return Math.abs(hc % N);
		}

		public int searchInLL(K key, int bi) {
			LinkedList<Node> ll = buckets[bi];
			for(int i=0; i<ll.size(); i++) {
				if(ll.get(i).key == key) {
					return i;
				}
			}
			return -1;
		}

		public void put(K key, V value) {
			int bi = hashFunction(key);
			int di = searchInLL(key, bi);
			if(di == -1) {
				buckets[bi].add(new Node(key, value));
				n++;
			}
			else {
				buckets[bi].get(di).value = value;
			}
			double lambda = (double)n/N;
			if(lambda > 2.0) {									// Threshold = 2.0
				rehash();
			}
		}

		@SuppressWarnings("unchecked")
		private void rehash() {																										// O(N)
			LinkedList<Node>[] oldBucket = buckets;
			buckets = new LinkedList[N*2];
			for(int i=0; i<N*2; i++) {
				buckets[i] = new LinkedList<>();
			}
			for(int i=0; i<N; i++) {
				LinkedList<Node> ll = oldBucket[i];
				for(int j=0; j<ll.size(); j++) {
					Node node  = ll.remove();
					put(node.key, node.value);
				}
			}
			N *= 2;
		}

		public boolean containsKey(K key) {
			int bi = hashFunction(key);
			int di = searchInLL(key, bi);
			if(di != -1) {
				return true;
			}
			return false;
		}

		public V remove(K key) {
			int bi = hashFunction(key);
			int di = searchInLL(key, bi);
			if(di != -1) {
				Node node = buckets[bi].remove(di);
				n--;
				return node.value;
			}
			return null;
		}

		public V get(K key) {
			int bi = hashFunction(key);
			int di = searchInLL(key, bi);
			if(di != -1) {
				Node node = buckets[bi].get(di);
				return node.value;
			}
			return null;
		}

		public ArrayList<K> keySet() {
			ArrayList<K> keys = new ArrayList<>();
			for(int i=0; i<N; i++) {
				LinkedList<Node> ll = buckets[i];
				for(Node node : ll) {
					keys.add(node.key);
				}
			}
			return keys;
		}

		public boolean isEmpty() {
			return (n == 0);
		}

	}

	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<>();
		hm.put("India", 1400);
		hm.put("China", 1500);
		hm.put("USA", 140);
		hm.put("Russia", 90);

		System.out.println(hm.get("India"));
		hm.remove("India");
		System.out.println(hm.get("India"));
	}

}
