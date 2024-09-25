import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap {

	static class MinHeap {

		ArrayList<Integer> heap = new ArrayList<>();

		void add(int data) {																										// O(n)
			heap.add(data);
			int child = heap.size() - 1;
			int par = (child-1)/2;
			while(heap.get(child) < heap.get(par)) {
				int temp = heap.get(child);
				heap.set(child, heap.get(par));
				heap.set(par, temp);
				child = par;
				par = (child-1)/2;
			}
		}

		int peek() {
			return heap.get(0);
		}

		int remove() {																												// O(log₂n)
			int data = heap.getFirst();
			heap.set(0, heap.getLast());
			heap.removeLast();
			heapify(0, heap.size());
			return data;
		}
		private void heapify(int parIdx, int heapSize) {																			// O(log₂n)
			int lcIdx = 2*parIdx + 1;
			int rcIdx = 2*parIdx + 2;
			int minIdx = parIdx;
			if(lcIdx < heapSize && heap.get(lcIdx) < heap.get(minIdx)) {
				minIdx = lcIdx;
			}
			if(rcIdx < heapSize && heap.get(rcIdx) < heap.get(minIdx)) {
				minIdx = rcIdx;
			}
			if(minIdx != parIdx) {
				int temp = heap.get(parIdx);
				heap.set(parIdx, heap.get(minIdx));
				heap.set(minIdx, temp);
				heapify(minIdx, heapSize);
			}
		}

	}

	static void heapSort(int[] arr) {																								// O(n×log₂n)
		int lastNonLeafIdx = (arr.length - 2) / 2;																					// MaxHeap for ascending
		for(int i=lastNonLeafIdx; i>=0; i--) {																						// MinHeap for descending
			heapifyMax(arr, i, arr.length);
		}
		for(int i=arr.length-1; i>0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapifyMax(arr, 0, i);
		}
	}
	static void heapifyMax(int[] arr, int parIdx, int size) {
		int lcIdx = 2*parIdx + 1;
		int rcIdx = 2*parIdx + 2;
		int maxIdx = parIdx;
		if(lcIdx < size && arr[lcIdx] > arr[maxIdx]) {
			maxIdx = lcIdx;
		}
		if(rcIdx < size && arr[rcIdx] > arr[maxIdx]) {
			maxIdx = rcIdx;
		}
		if(maxIdx != parIdx) {
			int temp = arr[parIdx];
			arr[parIdx] = arr[maxIdx];
			arr[maxIdx] = temp;
			heapifyMax(arr, maxIdx, size);
		}
	}

	static void nearestCars(int[][] pts, int k) {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		for(int i=0; i<pts.length; i++) {
			pq.add(new Point(pts[i], i));
		}
		for(int i=0; i<k; i++) {
			System.out.print("C" + pq.remove().idx + " ");
		}
	}
	static class Point implements Comparable<Point> {					// "static" keyword (here) is important
		int x, y;
		int distSq;
		int idx;
		Point(int[] pt, int idx) {
			this.x = pt[0];
			this.y = pt[1];
			this.distSq = x*x + y*y;
			this.idx = idx;
		}
		@Override
		public int compareTo(Point p2) {
			return (this.distSq - p2.distSq);
		}
	}

	static int nRopesMinCost(int[] ropes) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<ropes.length; i++) {
			pq.add(ropes[i]);
		}
		int minCost = 0;
		while(pq.size() > 1) {
			int currCost = pq.remove() + pq.remove();
			minCost += currCost;
			pq.add(currCost);
		}
		return minCost;
	}

	static void weakestRows(int[][] army, int k) {
		PriorityQueue<Row> pq = new PriorityQueue<>();
		for(int i=0; i<army.length; i++) {
			pq.add(new Row(army[i], i));
		}
		for(int i=0; i<k; i++) {
			System.out.print("row" + pq.remove().idx + " ");
		}
	}
	static class Row implements Comparable<Row> {
		int strength;
		int idx;
		Row(int[] row, int idx) {
			for(int i=0; i<row.length; i++) {
				this.strength += row[i];
			}
			this.idx = idx;
		}
		@Override
		public int compareTo(Row r2) {
			if(this.strength != r2.strength) {
				return (this.strength - r2.strength);
			}
			return (this.idx - r2.idx);
		}
	}

	static int[] slidingWindowMax(int[] arr, int k) {																				// O(n×log₂k)
		PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.reverseOrder());
		int[] res = new int[arr.length-k+1];
		for(int i=0; i<k; i++) {
			pq.add(new Pair(arr[i], i));
		}
		res[0] = pq.peek().val;
		for(int i=k; i<arr.length; i++) {
			while(pq.peek().idx < i-k+1) {
				pq.remove();
			}
			pq.add(new Pair(arr[i], i));
			res[i-k+1] = pq.peek().val;
		}
		return res;
	}
	static class Pair implements Comparable<Pair> {
		int val;
		int idx;
		Pair(int val, int idx) {
			this.val = val;
			this.idx = idx;
		}
		@Override
		public int compareTo(Pair p2) {
			return (this.val - p2.val);
		}
	}

	public static void main(String[] args) {
		int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
		int[] res = slidingWindowMax(arr, 3);
		for(int i=0; i<res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}

}
