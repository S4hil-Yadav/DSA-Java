import java.util.Arrays;
import java.util.Collections;

public class ArraysBasics {
	
	public static void printArray(Integer nums[]) {
		for(int i=0; i<nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		return;
	}

	public static void printArray(int nums[]) {
		for(int i=0; i<nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		return;
	}

	public static int index(int numbers[], int num) {
		for(int i=0; i<numbers.length; i++) {
			if(numbers[i] == num) {
				return i;
			}
		}
		return -1;
	}

	public static int largestNum(int nums[]) {
		int largest = Integer.MIN_VALUE;
		for(int i=0; i<nums.length; i++) {
			if(nums[i] > largest) {
				largest = nums[i];
			}
		}
		return largest;
	}

	public static int smallestNum(int nums[]) {
		int smallest = Integer.MAX_VALUE;
		for(int i=0; i<nums.length; i++) {
			if(nums[i] < smallest) {
				smallest = nums[i];
			}
		}
		return smallest;
	}
	
	public static int binarySearch(int nums[], int key) {			// O(log₂n)
		int si = 0, ei = nums.length - 1;
		while(si <= ei) {
			int mi = (si + ei) / 2;
			if(nums[mi] == key) {
				return mi;
			}
			else if(nums[mi] > key) {
				ei = mi - 1;
			}
			else {
				si = mi + 1;
			}
		}
		return -1;
	}

	public static void reverseArray(int[] nums) {
		int si = 0, ei = nums.length - 1;
		while(ei > si) {
			int temp = nums[si];
			nums[si++] = nums[ei];
			nums[ei--] = temp;
		}
		return;
	}

	public static void printPairs(int[] numbers) {
		for(int i=0; i<numbers.length; i++) {
			for(int j=i+1; j<numbers.length; j++) {
				System.out.print("(" + numbers[i] + ", " + numbers[j] + ") ");
			}
			System.out.println();
		}
	}
	
	public static void printSubarrays(int[] numbers) {
		for(int i=0; i<numbers.length; i++) {
			for(int j=i; j<numbers.length; j++) {
				System.out.print("(" + numbers[i]);
				for(int k=i+1; k<=j; k++) {
					System.out.print(", " + numbers[k]);
				}
				System.out.println(") ");
			}
			System.out.println();
		}
		return;
	}
	
	public static int maxSubarraySum(int[] nums) {
		int maxSum = Integer.MIN_VALUE;
		for(int i=0; i<nums.length; i++) {
			for(int j=i; j<nums.length;j++) {
				int currSum = 0;
				for(int k=i; k<=j; k++) {
					currSum += nums[k];
				}
				maxSum = Math.max(maxSum, currSum);
			}
		}
		return maxSum;
	}
	
	public static int maxSubarraySumP(int[] nums) {
		int[] prefix = new int[nums.length];
		int prefixSum = 0;
		for(int i=0; i<nums.length; i++) {
			prefixSum += nums[i];
			prefix[i] = prefixSum;
		}
		int maxSum = Integer.MIN_VALUE;
		for(int i=0; i<nums.length; i++) {
			for(int j=i; j<nums.length; j++) {
				int currSum = (i == 0) ? prefix[j] : (prefix[j] - prefix[i-1]);
				maxSum = Math.max(maxSum, currSum);
			}
		}
		return maxSum;
	}

	public static int maxSubarraySumK(int[] nums) {
		int maxSum = Integer.MIN_VALUE;
		for(int i=0; i<nums.length; i++) {
			maxSum = Math.max(maxSum, nums[i]);
		}
		if(maxSum <= 0) {
			return maxSum;
		}
		int currSum = 0;
		for(int i=0; i<nums.length; i++) {
			currSum += nums[i];
			if(currSum < 0) {
				currSum = 0;
			}
			maxSum = Math.max(currSum, maxSum);
		}
		return maxSum;
	}

	public static void main(String[] args) {
		Integer[] numbers = new Integer[] {-2,3,4,-1,-2,1,5,-3};			// Doesn't work for int because it's primitive
		Arrays.sort(numbers, Collections.reverseOrder());
		printArray(numbers);
		// Arrays.fill(numbers, -1);
	}

}