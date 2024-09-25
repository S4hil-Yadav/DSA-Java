import java.util.ArrayList;
import java.util.Collections;

public class ArrayListJCF {

	public static void operations(ArrayList<Integer> list) {
		list.add(34); list.add(24); list.add(43); list.add(48); list.add(97);			// O(1)
		System.out.println("List after appending five elements : " + list);
		list.add(2, 73);																// O(n)
		System.out.println("List after inserting 73 at index 2 : " + list);
		int val = list.get(1);															// O(1)
		System.out.println("Value at index 1 : " + val);
		list.remove(1);																	// O(n)
		System.out.println("List after removing element at index 1 : " + list);
		list.set(2, 56);																// O(1)
		System.out.println("List after altering value at index 2 to 56 : " + list);
		boolean bl = list.contains(43);													// O(n)
		System.out.println("Does list contain 43? " + bl);
	}

	public static void sortList(ArrayList<Integer> list) {
		System.out.println(list);
		Collections.sort(list);															// ascending
		System.out.println(list);
		Collections.sort(list, Collections.reverseOrder());								// descending
		System.out.println(list);
	}

	public static void arrayList2D() {
		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		ArrayList<Integer> list3 = new ArrayList<>();
		for(int i=1; i<=5; i++) {
			list1.add(2*i);
			list2.add(3*i);
			list3.add(5*i);
		}
		lists.add(list1);
		lists.add(list2);
		lists.add(list3);
		list2.remove(4);
		lists.get(1).remove(3);
		System.out.println(lists);
	}

	public static int maxWater(ArrayList<Integer> height) {								// TC :- O(n)
		int lp = 0;																		// 2 Pointer Approach
		int rp = height.size() - 1;
		int maxWater = 0;
		while(lp < rp) {
			int currWater = (rp - lp) * Math.min(height.get(lp), height.get(rp));
			maxWater = Math.max(maxWater, currWater);
			if(height.get(lp) < height.get(rp)) {
				lp++;
			}
			else {
				rp--;
			}
		}
		return maxWater;
	}

	public static boolean pairSum(ArrayList<Integer> list, int target) {				// TC :- O(n)
		int lp = 0;																		// 2 Pointer Approach (only for sorted ArrayLists)
		int rp = list.size() - 1;
		while(lp < rp) {
			int sum = list.get(lp) + list.get(rp);
			if(sum == target) {
				return true;
			}
			else if(sum < target) {
				lp++;
			}
			else {
				rp--;
			}
		}
		return false;
	}

	public static boolean pairSumRotatted(ArrayList<Integer> list, int target) {			// TC :- O(n)
		int n = list.size();																// Modified 2 Pointer Approach (only for sorted and rotated ArrayLists)
		int pIdx = 0;
		for(int i=1; i<n; i++) {
			if(list.get(i-1) > list.get(i)) {
				pIdx = i;
				break;
			}
		}
		int lp = pIdx;
		int rp = (n + pIdx - 1) % n;
		while(lp != rp) {
			int sum = list.get(lp) + list.get(rp);
			if(sum == target) {
				return true;
			}
			if(sum < target) {
				lp = (lp + 1) % n;
			}
			else {
				rp = (n + rp - 1) % n;
			}
		}
		return false;
	}

}