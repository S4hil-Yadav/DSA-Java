public class Backtracking {

	public static void print2Darray(char[][] ch) {
		for(int i=0; i<ch.length; i++) {
			for(int j=0; j<ch[0].length; j++) {
				System.out.print(ch[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void print2Darray(int[][] n) {
		for(int i=0; i<n.length; i++) {
			for(int j=0; j<n[0].length; j++) {
				System.out.print(n[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void printArr(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void changeArr(int[] arr, int i) {
		if(i == arr.length) {
			printArr(arr);
			return;
		}
		arr[i] = i+1;
		changeArr(arr, i+1);
		arr[i] -= 2;				// Backtracking step
	}
	
	public static void printSubsets(String str, String strSubset, int i) {				// TC :- O(n×2^n)
		if(i == str.length()) {															// SC :- O(n)
			if(strSubset == "") {
				System.out.print("null");
			}
			System.out.println(strSubset);
			return;
		}
		printSubsets(str, strSubset + str.charAt(i), i+1);
		printSubsets(str, strSubset, i+1);
	}

	public static void printPermutations(String str, String strPerm) {					// TC :- O(n×n!)
		if(str.length() == 0) {															// SC :- O(?)
			System.out.println(strPerm);
			return;
		}
		for(int i=0; i<str.length(); i++) {
			char curr = str.charAt(i);
			String newStr = str.substring(0, i) + str.substring(i+1);
			printPermutations(newStr, strPerm + curr);
		}
	}

	static int count;
	
	public static int gridWays(int rows, int cols) {            					// O(2^(r+c))
		if(rows == 1 || cols == 1) {
			return 1;
		}
		return (gridWays(rows-1, cols) + gridWays(rows, cols-1));
	}
	
	public static int gridWaysOptimized(int rows, int cols) {						// O(r+c)
		return factorial(rows+cols-2)/(factorial(rows-1)*factorial(cols-1));
	}

	public static void nQueens(char[][] chessBoard, int row) {							// TC :- O(n!)
		if(row == chessBoard.length) {
			print2Darray(chessBoard);
			count++;
			return;
		}
		for(int col=0; col<chessBoard.length; col++) {
			if(isSafe(chessBoard, row, col)) {
				chessBoard[row][col] = 'Q';
				nQueens(chessBoard, row+1);
				chessBoard[row][col] = 'x';
			}
		}
	}

	public static boolean nQueensOneSolution(char[][] chessBoard, int row) {
		if(row == chessBoard.length) {
			return true;
		}
		for(int col=0; col<chessBoard.length; col++) {
			if(isSafe(chessBoard, row, col)) {
				chessBoard[row][col] = 'Q';
				if(nQueensOneSolution(chessBoard, row+1)) {
					return true;
				}
				chessBoard[row][col] = 'x';
			}
		}
		return false;
	}

	public static boolean isSafe(char[][] chessBoard, int row, int col) {
		for(int i=row; i>=0; i--) {
			if(chessBoard[i][col] == 'Q') {
				return false;
			}
		}
		for(int i=row, j=col; i>=0 && j>=0; i--, j--) {
			if(chessBoard[i][j] == 'Q') {
				return false;
			}
		}
		for(int i=row, j=col; i>=0 && j<chessBoard.length; i--, j++) {
			if(chessBoard[i][j] == 'Q') {
				return false;
			}
		}
		return true;
	}
	
	public static int factorial(int num) {
		int fact = 1;
		for(int i=2; i<=num; i++) {
			fact *= i;
		}
		return fact;
	}

	public static boolean isSafe(int[][] sudokuTable, int n, int row, int col) {
		for(int i=0; i<9; i++) {
			if(sudokuTable[row][i] == n || sudokuTable[i][col] == n) {
				return false;
			}
		}
		int sr = row/3*3;
		int sc = col/3*3;
		for(int i=sr; i<sr+3; i++) {
			for(int j=sc; j<sc+3; j++) {
				if(sudokuTable[i][j] == n) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean sudoku(int[][] sudokuTable, int row, int col) {
		if(col == 9) {
			row++;
			col = 0;
		}
		if(row == 9) {
			return true;
		}
		if(sudokuTable[row][col] != 0) {
			if(sudoku(sudokuTable, row, col+1)) {
				return true;
			}
		}
		for(int n=1; n<10; n++) {
			if(isSafe(sudokuTable, n, row, col)) {
				sudokuTable[row][col] = n;
				if(sudoku(sudokuTable, row, col+1)) {
					return sudoku(sudokuTable, row, col+1);
				}
				sudokuTable[row][col] = 0;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] sudokuTable = { {0, 0, 8, 0, 0, 0, 0, 0, 0},
								{4, 9, 0, 1, 5, 7, 0, 0, 2},
								{0, 0, 3, 0, 0, 4, 1, 9, 0},
								{1, 8, 5, 0, 6, 0, 0, 2, 0},
								{0, 0, 0, 0, 2, 0, 0, 6, 0},
								{9, 6, 0, 4, 0, 5, 3, 0, 0},
								{0, 3, 0, 0, 7, 2, 0, 0, 4},
								{0, 4, 9, 0, 3, 0, 0, 5, 7},
								{8, 2, 7, 0, 0, 9, 0, 1, 3} };
		if(sudoku(sudokuTable, 0, 0)) {
			print2Darray(sudokuTable);
		}
	}
}
