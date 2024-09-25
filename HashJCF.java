import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class HashJCF {

	static ArrayList<Integer> majorityElements(int[] nums) {
		ArrayList<Integer> res = new ArrayList<>();
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int n : nums) {
			// if(hm.containsKey(n)) {
			// 	hm.put(n, hm.get(n) + 1);
			// }
			// else {
			// 	hm.put(n, 1);
			// }
			hm.put(n, hm.getOrDefault(n, 0) + 1);
		}
		for(Integer key : hm.keySet()) {
			if(hm.get(key) > nums.length/3) {
				res.add(key);
			}
		}
		return res;
	}

	static boolean isAnagram(String s1, String s2) {
		int n1 = s1.length();
		int n2 = s2.length();
		if(n1 != n2) {
			return false;
		}
		HashMap<Character, Integer> hm1 = new HashMap<>();
		HashMap<Character, Integer> hm2 = new HashMap<>();
		for(int i=0; i<n1; i++) {
			hm1.put(s1.charAt(i), hm1.getOrDefault(s1.charAt(i), 0) + 1);
			hm2.put(s2.charAt(i), hm2.getOrDefault(s2.charAt(i), 0) + 1);
		}
		for(Character ch : hm1.keySet()) {
			if(hm1.get(ch) != hm2.get(ch)) {
				return false;
			}
		}
		return true;
	}

	static int distinctElements(int[] nums) {
		HashSet<Integer> hs = new HashSet<>();
		for(int n : nums) {
			hs.add(n);
		}
		return hs.size();
	}
	
	static ArrayList<Integer> union(int[] nums1, int[] nums2) {
		HashSet<Integer> hs = new HashSet<>();
		ArrayList<Integer> res = new ArrayList<>();
		for(int n : nums1) {
			hs.add(n);
		}
		for(int n : nums2) {
			hs.add(n);
		}
		for(Integer n : hs) {
			res.add(n);
		}
		return res;
	}

	static ArrayList<Integer> intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> hs = new HashSet<>();
		ArrayList<Integer> res = new ArrayList<>();
		for(int n : nums1) {
			hs.add(n);
		}
		for(int n : nums2) {
			if(hs.contains(n)) {
				res.add(n);
				hs.remove(n);
			}
		}
		return res;
	}

	static String[] itinerary(HashMap<String, String> tickets) {
		String[] res = new String[tickets.size()+1];
		HashMap<String, String> rev = new HashMap<>();
		for(String key : tickets.keySet()) {
			rev.put(tickets.get(key), key);
		}
		String currCity = null;
		for(String key : tickets.keySet()) {
			if(!rev.containsKey(key)) {
				currCity = key;
				break;
			}
		}
		for(int i=0; i<res.length; i++) {
			res[i] = currCity;
			currCity = tickets.get(currCity);
		}
		return res;
	}
	
	static int largestSubArrWith0Sum(int[] nums) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		int len = 0;
		int sum = 0;
		hm.put(0, -1);
		for(int i=0; i<nums.length; i++) {
			sum += nums[i];
			if(hm.containsKey(sum)) {
				len = Math.max(len, i-hm.get(sum));
			}
			else {
				hm.put(sum, i);
			}
		}
		return len;
	}
	
	static int largestSubArrWithKSum(int[] nums, int k) {
		HashMap<Integer, Integer> hm = new HashMap<>();					// <sum, idx>
		int len = Integer.MIN_VALUE;
		int sum = 0;
		hm.put(0, -1);
		for(int i=0; i<nums.length; i++) {
			sum += nums[i];
			if(hm.containsKey(sum-k)) {
				len = Math.max(len, i-hm.get(sum-k));
			}
			if(!hm.containsKey(sum)) {
				hm.put(sum, i);
			}
		}
		if(len == Integer.MIN_VALUE) {
			return -1;
		}
		return len;
	}

	static int smallestSubArrWithKSum(int[] nums, int k) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		int len = Integer.MAX_VALUE;
		int sum = 0;
		hm.put(0, -1);
		for(int i=0; i<nums.length; i++) {
			sum += nums[i];
			if(hm.containsKey(sum-k)) {
				len = Math.min(len, i - hm.get(sum-k));
			}
			hm.put(sum, i);
		}
		if(len == Integer.MAX_VALUE) {
			return -1;
		}
		return len;
	}

	static int subArrsWithKSum(int[] nums, int k) {
		HashMap<Integer, Integer> hm = new HashMap<>();						// <sum, freq>
		int count = 0;
		int sum = 0;
		hm.put(0, 1);
		for(int i=0; i<nums.length; i++) {
			sum += nums[i];
			if(hm.containsKey(sum-k)) {
				count += hm.get(sum-k);
			}
			hm.put(sum, hm.getOrDefault(sum, 0) + 1);
		}
		return count;
	}

	public static void main(String[] args) {
		int[] nums = {10, 2, -2, -20, 10};
		System.out.println(subArrsWithKSum(nums, -10));
	}
	
}
