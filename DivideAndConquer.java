public class DivideAndConquer {

	public static void printArray(int[] arr) {
		System.out.print("{" + arr[0]);
		for(int i=1; i<arr.length; i++) {
			System.out.print(", " + arr[i]);
		}
		System.out.println("}");
	}

	public static void mergeSort(int[] nums, int si, int ei) {				// TC :- O(n×log₂n)    (both best and worst case)
		if(si == ei) {														// SC :- O(n)
			return;
		}
		int mi = si + (ei-si)/2;
		mergeSort(nums, si, mi);
		mergeSort(nums, mi+1, ei);
		merge(nums, si, mi, ei);
	}

	public static void merge(int[] nums, int si, int mi, int ei) {			// TC :- O(n)
		int[] temp = new int[ei-si+1];										// SC :- O(n)
		int i = si;
		int j = mi+1;
		int k = 0;
		while(i <= mi && j <= ei) {
			if(nums[i] < nums[j]) {
				temp[k++] = nums[i++];
			}
			else {
				temp[k++] = nums[j++];
			}
		}
		while(i <= mi) {
			temp[k++] = nums[i++];
		}
		while(j <= ei) {
			temp[k++] = nums[j++];
		}
		for(k=0; k<temp.length; k++) {
			nums[k+si] = temp[k];
		}
	}

	public static void quickSort(int[] nums, int si, int ei) {				// Pivot and Partition
		if(si >= ei) {														// avg(TC) = O(n×log₂n)
			return;															// max(TC) = n² (occurs when pivot is always the largest or smallest element
		}																	//               i.e., when our array is already arranged in ascending or descending order)
		int pIdx = partition(nums, si, ei);
		quickSort(nums, si, pIdx-1);
		quickSort(nums, pIdx+1, ei);
	}

	public static int partition(int[] nums, int si, int ei) {
		int i = si;
		for(int j=si; j<ei; j++) {
			if(nums[j] <= nums[ei]) {
				int temp = nums[j];
				nums[j] = nums[i];
				nums[i++] = temp;
			}
		}
		int temp = nums[i];
		nums[i] = nums[ei];
		nums[ei] = temp;
		return i;
	}

	public static int searchIndex(int[] nums, int key, int si, int ei) {
		if(si > ei) {
			return -1;
		}
		int mi = si + (ei-si)/2;
		if(nums[mi] == key) {
			return mi;
		}
		if(nums[si] <= nums[mi]) {
			if(nums[si] <= key && key < nums[mi]) {
				return searchIndex(nums, key, si, mi-1);
			}
			else {
				return searchIndex(nums, key, mi+1, ei);
			}
		}
		else {
			if(nums[mi] < key && key <= nums[ei]) {
				return searchIndex(nums, key, mi+1, ei);
			}
			else {
				return searchIndex(nums, key, si, mi-1);
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = {12, 15, 17, 3, 5, 6, 9, 10, 11};
		int n = searchIndex(nums, 11, 0, nums.length-1);
		System.out.println(n);
	}
}
