public class Recursion {

	public static int factorial(int n) {				// TC :- O(n)
		if(n == 0) {									// SC :- O(n)
			return 1;
		}
		return n*factorial(n-1);
	}

	public static void printNto1(int n) {
		System.out.print(n + " ");
		if(n == 1) {
			return;
		}
		printNto1(n-1);
	}

	public static void print1toN(int n) {
		if(n == 0) {
			return;
		}
		print1toN(n-1);
		System.out.print(n + " ");
	}
	
	public static int sumTillN(int n) {					// TC :- O(n)
		if(n == 1) {									// SC :- O(n)
			return 1;
		}
		int sum = n+sumTillN(n-1);
		return sum;
	}
	
	public static int fibonacci(int n) {				// Divide & Conquer
		if((n == 0) || (n == 1)) {						// TC :- O(2^n)
			return n;									// SC :- O(n)
		}
		return (fibonacci(n-1) + fibonacci(n-2));
	}
	
	public static boolean isSorted(int[] nums, int i) {
		if(i == nums.length-1) {
			return true;
		}
		if(nums[i] > nums[i+1]) {
			return false;
		}
		return isSorted(nums, i+1);
	}
		
	public static int firstOccurence(int[] nums,int key, int i) {		// O(n)
		if(i == nums.length) {
			return -1;
		}
		if(nums[i] == key) {
			return i;
		}
		return firstOccurence(nums, key, i+1);
	}

	public static int lastOccurence(int[] nums, int key, int i) {		// O(n)
		if(nums[i] == key) {
			return i;
		}
		if(i == 0) {
			return -1;
		}
		return lastOccurence(nums, key, i-1);
	}
	
	public static int power(int x, int n) {						// TC :- O(n)
		if(n == 0) {											// SC :- O(n)
			return 1;
		}
		return (x*power(x, n-1));
	}
	
	public static int powerOptimized(int x, int n) {			// TC :- O(log₂n)
		if(n == 0) {											// SC :- O(log₂n)
			return 1;
		}
		int pow = powerOptimized(x, n/2);
		pow *= pow;
		if(n%2 != 0) {
			pow *= x;
		}
		return pow;
	}
	
	public static int tiling(int n) {			// (m×n) space is to be filled with (m×1 tiles)   [n>m]
		if(n == 0 || n == 1) {
			return 1;
		}
		return (tiling(n-1) + tiling(n-2));		// tiling(n-1) + tiling(n-m)
	}
	
	public static String deleteDuplicates(String str, StringBuilder newStr, boolean[] isPresent, int i) {
		if(i == str.length()) {
			return newStr.toString();
		}
		char ch = str.charAt(i);
		if(!isPresent[ch-'a']) {
			newStr.append(ch);
			isPresent[ch-'a'] = true;
		}
		return deleteDuplicates(str, newStr, isPresent, i+1);
	}
	
	public static int friendsPairing(int n) {
		if(n == 0 || n == 1) {
			return 1;
		}
		return (friendsPairing(n-1) + (n-1)*friendsPairing(n-2));
	}
	
	public static void printBinStrings(int n, int lastDigit, String str) {		// HW :- accomplish the same with StringBuilder
		if(n == 0) {
			System.out.println(str);
			return;
		}
		printBinStrings(n-1, 0, str + '0');
		if(lastDigit == 0) {
			printBinStrings(n-1, 1, str +'1');
		}
	}

	public static void main(String[] args) {
		printBinStrings(4, 0, "");
	}

}
