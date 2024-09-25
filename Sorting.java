public class Sorting {

	public static void main(String[] args) {
		int[] arr = {9, 2, 1, 8};
		selectionSort(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}

	public static void printArray(int numbers[]) {
		for(int i=0; i<numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
	}

	public static void bubbleSort(int[] numbers) {					// Worst case (pre-arranged in descending) :- O(n²)
		for(int i=0; i<numbers.length-1; i++) {						// Best case (pre-arranged in ascending) :- O(n²)
			for(int j=0; j<numbers.length-i-1; j++) {
				if(numbers[j] > numbers[j+1]) {
					int temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
				}
			}
		}
	}

	public static void optimizedBubbleSort(int[] numbers) {			// Worst case (pre-arranged in descending) :- O(n²) 
		for(int i=0; i<numbers.length; i++) {						// Best case (pre-arranged in ascending) :- O(n)
			boolean swapped = false;
			for(int j=0; j<numbers.length-i-1; j++) {
				if(numbers[j] > numbers[j+1]) {
					int temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
					swapped = true;
				}
			}
			if(!swapped) {
				break;
			}
		}
	}

	public static void selectionSort(int[] numbers) {
		int n = numbers.length;
		for(int i=0; i<n-1; i++) {
			int minIndex = i;
			for(int j=i+1; j<n; j++) {
				if(numbers[minIndex] > numbers[j]) {
					minIndex = j;
				}
			}
			int temp = numbers[minIndex];
			numbers[minIndex] = numbers[i];
			numbers[i] = temp;
		}
	}

	public static void insertionSort(int[] numbers) {
		for(int i=1; i<numbers.length; i++) {
			int curr = numbers[i];
			int j=i;
			while(j>0 && curr<numbers[j-1]) {
				numbers[j] = numbers[j-1];
				j--;
			}
			numbers[j] = curr;
		}
	}

	public static void countingSort(int[] nums) {
		int max = Integer.MIN_VALUE;
		for(int i=0; i<nums.length; i++) {
			max = Math.max(max, nums[i]);
		}
		int[] freq = new int[max+1];
		for(int i=0; i<nums.length; i++) {
			freq[nums[i]]++;
		}
		int idx = 0;
		for(int i=0; i<=max; i++) {
			while(freq[i] != 0) {
				nums[idx] = i;
				idx++;
				freq[i]--;
			}
		}
	}

}


