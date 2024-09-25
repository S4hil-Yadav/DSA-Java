public class Arrays2D {

	public static void print2Darray(int[][] nums) {
		for(int i=0; i<nums.length; i++) {
			for(int j=0; j<nums[0].length; j++) {
				System.out.print(nums[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void print2DarraySpirally(int[][] nums) {
		int startRow = 0;
		int startCol = 0;
		int endRow = nums.length - 1;
		int endCol = nums[0].length - 1;
		while(startRow <= endRow && startCol <= endCol) {
			for(int j=startCol; j<=endCol; j++) {
				System.out.print(nums[startRow][j] + " ");
			}
			if(startRow == endRow) {
				break;
			}
			for(int i=startRow+1; i<=endRow; i++) {
				System.out.print(nums[i][endCol] + " ");
			}
			if(startCol == endCol) {
				break;
			}
			for(int j=endCol-1; j>=startCol; j--) {
				System.out.print(nums[endRow][j] + " ");
			}
			for(int i=endRow-1; i>startRow; i--) {
				System.out.print(nums[i][startCol] + " ");
			}
			startRow++; startCol++; endRow--; endCol--;
		}
		System.out.println();
	}

	public static int diagonalSum(int[][] nums) {
		int n = nums.length;
		int diagonalSum = 0;
		for(int i=0; i<n; i++) {
			diagonalSum += nums[i][i] + nums[i][n-1-i];
		}
		if(nums.length%2 != 0) {
			diagonalSum -= nums[n/2][n/2];
		}
		return diagonalSum;
	}
	
	public static boolean searchKeySorted(int[][] nums, int key) {
		int si = 0;
		int ei = nums.length - 1;
		int mi1 = 0;
		while(si <= ei) {
			mi1 = (si + ei) / 2;
			if(key == nums[mi1][0]) {
				System.out.println("key found at (" + mi1 + ", 0)");
				return true;
			}
			else if(key > nums[mi1][0]) {
				si = mi1 + 1;
			}
			else {
				ei = mi1 - 1;
			}
		}
		if(key < nums[mi1][0]) {
			mi1--;
		}
		si = 0;
		ei = nums[0].length - 1;
		while(si <= ei) {
			int mi2 = (si + ei) / 2;
			if(key == nums[mi1][mi2]) {
				System.out.println("key found at (" + mi1 + ", " + mi2 + ")");
				return true;
			}
			else if(key > nums[mi1][mi2]) {
				si = mi2 + 1;
			}
			else {
				ei = mi2 - 1;
			}
		}
		System.out.println("key not found");
		return false;
	}
	
	public static boolean staircaseSearch(int[][] nums, int key) {
		int row = nums.length - 1;
		int col = 0;
		while(row>=0 && col<nums[0].length) {
			if(key == nums[row][col]) {
				System.out.println("key found at (" + row + ", " + col + ")");
				return true;
			}
			else if(key < nums[row][col]) {
				row--;
			}
			else {
				col++;
			}
		}
		System.out.println("key not found");
		return false;
	}
	
	public static void main(String[] args) {
		int[][] numbers = new int[5][];
		int[] arr1 = {1, 2, 3};
		int[] arr2 = {7, 8};
		numbers[0] = arr1;
		numbers[1] = arr2;
	}

}

